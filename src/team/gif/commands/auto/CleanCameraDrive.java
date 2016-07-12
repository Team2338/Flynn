package team.gif.commands.auto;

import lib.gif.PIDCalculator;
import team.gif.Flynn;
import team.gif.Globals;

import static team.gif.Flynn.chassis;

public class CleanCameraDrive extends lib.gif.commands.Command {
	
	private double finalDist;
	private double angle;
	private double centerY;
	private double error;
	private boolean inTolerance;
	private final double speedCap = 0.7;
	private final double pixelTolerance = 25;
	private PIDCalculator distCalculator;
	private PIDCalculator angleCalculator;

    public CleanCameraDrive() {
    	distCalculator = new PIDCalculator(Globals.k_driveStraightDistP, 0, 0);
    	angleCalculator = new PIDCalculator(Globals.k_driveStraightAngleP, 0, 0);
    }

    protected void initialize() {
    	System.out.println("Entering CameraDrive");
    	chassis.resetEncoders();
    	angle = chassis.getAngle();
    	
    	if ((centerY = Flynn.getTargetValue("centerY")) >= 0) {
    		
    		error = Globals.s_cameraCenterY - centerY; // Pixels
    		inTolerance = Math.abs(error) < pixelTolerance;
    		
    		System.out.println("Error: " + error + " , Tolerance: " + inTolerance);
    		System.out.println("CenterY: " + centerY);
    		
    		error = error * Globals.k_distanceConversionFactor; // pixels to distance
    		
    		finalDist = chassis.getRightDist() + error;
    		distCalculator.clearIAccum();
    		System.out.println("DIST tick error: " + error);
    		
    	} else {
    		centerY = 0;
    		error = 0;
    		finalDist = chassis.getRightDist();
    		inTolerance = true;
    		System.out.println("No target detected");
    	}
    	
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
        return (Math.abs(finalDist - chassis.getRightDist()) < Globals.t_driveStraightDist) ||
        		inTolerance; //&&
//        		Math.abs(vel) < Globals.driveStraightVelTolerance; TODO: Add velocity checker
    }

    protected void end() {
    	chassis.drive(0, 0);
    	System.out.println("Exiting CameraDrive");
    }

    protected void interrupted() {
    	chassis.drive(0, 0);
    }
    
}
