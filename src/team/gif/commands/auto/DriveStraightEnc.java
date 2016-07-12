package team.gif.commands.auto;

import lib.gif.PIDCalculator;
import team.gif.Globals;

import static team.gif.Flynn.chassis;

// TODO: add in left encoder for error checking
public class DriveStraightEnc extends lib.gif.commands.Command {
	
	private double finalDist;
	private double angle;
	private final double speedCap;
	private PIDCalculator distCalculator;
	private PIDCalculator angleCalculator;

    public DriveStraightEnc(double deltaDist) {
    	this(deltaDist, 0.7);
    }
    
    public DriveStraightEnc(double deltaDist, double speedCap){
    	this.finalDist = deltaDist;
    	this.speedCap = Math.abs(speedCap);
    	distCalculator = new PIDCalculator(Globals.k_driveStraightDistP, 0, 0);
    	angleCalculator = new PIDCalculator(Globals.k_driveStraightAngleP, 0, 0);
    }
    
    protected void initialize() {
    	chassis.resetEncoders();
    	angle = chassis.getAngle();
    }

    protected void execute() {
    	double distOutput = distCalculator.getOutput(finalDist - chassis.getRightDist());
    	double angleOutput = angleCalculator.getOutput(angle - chassis.getAngle());
    	
    	if (distOutput > speedCap) {
    		chassis.drive(speedCap + angleOutput, speedCap - angleOutput);
    	} else if (distOutput < -speedCap) {
    		chassis.drive(-speedCap + distOutput, -speedCap - distOutput);
    	} else {
    		chassis.drive(distOutput + angleOutput, distOutput - angleOutput);
    	}
    	
    }

    protected boolean isFinished() {
        return Math.abs(finalDist - chassis.getRightDist()) < Globals.t_driveStraightDist; //&&
//        		Math.abs(vel < Globals.driveVelTolerance); TODO: Add velocity checker
    }

    protected void end() {
    	chassis.drive(0, 0);
    	System.out.println("Exiting DriveStraightEnc");
    }

    protected void interrupted() {
    	chassis.drive(0, 0);
    }
    
}
