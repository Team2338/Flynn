package team.gif.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Logger;

import static team.gif.Robot.chassis;

import java.io.File;
import java.text.DecimalFormat;

// TODO: add in right encoder for error checking
public class DriveStraightEnc extends Command {
	
	private double initTime;
	private double finalDist;
	private double distKp;
	private double distError;
	private double angle;
	private double angleKp;
	private double angleError;
	private final boolean userDefined;
	private static final DecimalFormat df = new DecimalFormat("#.###");
	private static final File distFile = new File("/GearItForward/dist.txt");

    public DriveStraightEnc(double deltaDist) {
    	this.finalDist = deltaDist;
    	this.distKp = Globals.driveStraightDistKp;
    	this.angleKp = Globals.driveStraightAngleKp;
    	userDefined = false;
    }
    
    public DriveStraightEnc() {
    	userDefined = true;
    }

    protected void initialize() {
    	if (userDefined) {
    		finalDist = SmartDashboard.getNumber("DriveStraightDist", 0.0);
    		angleKp = SmartDashboard.getNumber("DriveStraightAngleKp", Globals.driveStraightAngleKp);
    		distKp = SmartDashboard.getNumber("DriveStraightDistKp", Globals.driveStraightDistKp);
    	}
    	
    	chassis.resetEncoders();
    	initTime = Timer.getFPGATimestamp();
    	distError = finalDist;
    	angle = chassis.getAngle();
    	angleError = 0;
    }

    protected void execute() {
    	distError = finalDist - chassis.getLeftDist();
    	initTime = Timer.getFPGATimestamp();
    	angleError = angle - chassis.getAngle();
    	chassis.drive((distError * distKp) + (angleKp * angleError),
    				  (distError * distKp) - (angleKp * angleError));
    	Logger.println(initTime + ", " + df.format(chassis.getLeftDist()), distFile);
    }

    protected boolean isFinished() {
        return Math.abs(distError) < Globals.driveStraightDistTolerance; //&&
//        		Math.abs(vel) < Globals.driveStraightVelTolerance; TODO: Add velocity checker
    }

    protected void end() {
    	chassis.drive(0, 0);
    }

    protected void interrupted() {
    	chassis.drive(0, 0);
    }
    
}
