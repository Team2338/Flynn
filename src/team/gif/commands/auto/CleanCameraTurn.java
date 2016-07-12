package team.gif.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Flynn;
import team.gif.Globals;
import team.gif.commands.shooter.FireGenericShot;
import team.gif.commands.shooter.FireShooter;
import team.gif.commands.shooter.RevShooter;

import static team.gif.Flynn.chassis;

public class CleanCameraTurn extends Command {
	
	private double error;
	private double centerX;
	private double finalAngle;
	private PIDCalculator calculator = new PIDCalculator(
			Globals.k_cameraTurnP, Globals.k_cameraTurnI, Globals.k_cameraTurnD, Globals.k_cameraTurnIZone);
	private final double maxSpeed = Globals.t_cameraTurnMaxSpeed;
	private boolean inTolerance;
	private boolean isRev = false;

    public CleanCameraTurn() {
        requires(chassis);
    }

    protected void initialize() {
    	System.out.println("Entering CameraStuff");
    	System.out.println(Timer.getMatchTime());
    	
    	if (!isRev) {
        	new RevShooter(Globals.s_courtyardRPM).start();
        	isRev = true;
    	}
    	
    	centerX = Flynn.getTargetValue("centerX");
    	
    	if ((centerX = Flynn.getTargetValue("centerX")) >= 0) {
    		
    		error = Globals.s_cameraCenterX - centerX; // Pixels
    		inTolerance = Math.abs(error) < Globals.t_cameraTurnPixels;
    		
    		System.out.println("Error: " + error + " , Tolerance: " + inTolerance);
    		System.out.println("CenterX: " + centerX);
    		
    		error = error * Globals.k_angleConversionFactor; // pixels to degrees
    		
    		finalAngle = chassis.getAngle() + error;
    		calculator.clearIAccum();
    		System.out.println("TURN degree error: " + error);
    		
    	} else {
    		centerX = 0;
    		error = 0;
    		finalAngle = chassis.getAngle();
    		inTolerance = true;
    		System.out.println("No target detected");
    	}
    	
    }

    protected void execute() {
    	double output = calculator.getOutput(finalAngle - chassis.getAngle());
    	
    	if (output > maxSpeed) {
    		chassis.drive(maxSpeed, -maxSpeed);
    	} else if (output < -maxSpeed) {
    		chassis.drive(-maxSpeed, maxSpeed);
    	} else {
    		chassis.drive(output, -output);
    	}
    	
    }

    protected boolean isFinished() {
        return ((Math.abs(finalAngle - chassis.getAngle()) < Globals.t_turnAngularPos &&
        		Math.abs(chassis.getRate()) < Globals.t_turnAngularVel) ||
        		inTolerance);
    }

    protected void end() {
    	chassis.drive(0, 0);
    	Timer.delay(0.75);
    	
    	System.out.println("Double-checking angle");
    	
    	centerX = Flynn.getTargetValue("centerX");
    	
    	if (Math.abs(Globals.s_cameraCenterX - centerX) >= Globals.t_cameraTurnPixels) {
    		System.out.println("Reattempting CameraStuff");
    		new CleanCameraTurn().start();
    	} else {
    		System.out.println("Final centerX: " + centerX);

			new FireShooter(0.0).start();
    	}
    	
    	System.out.println("Exiting CameraStuff");
    	System.out.println(Timer.getMatchTime());
    }

    protected void interrupted() {}
    
}
