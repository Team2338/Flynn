package team.gif.commands.auto;

import lib.gif.Logger;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.commands.shooter.FireGenericShot;
import team.gif.commands.shooter.FireShooter;
import team.gif.commands.shooter.RevShooter;

import static team.gif.Flynn.chassis;
import static team.gif.Flynn.grip;
import java.io.File;
import edu.wpi.first.wpilibj.Timer;

/**
 * @author PatrickUbelhor, DerekHo
 *
 */

public class CameraTurn extends Command {
	
	// Can these all be static?
	private double error;
	private double centerX;
	private double finalAngle;
	private PIDCalculator calculator = new PIDCalculator(
			Globals.k_cameraTurnP, Globals.k_cameraTurnI, Globals.k_cameraTurnD, Globals.k_cameraTurnIZone);
	private final double maxSpeed = Globals.t_cameraTurnMaxSpeed;
	private boolean inTolerance;
	private static final File logFile = new File("/GearItForward/CameraTurn.log");
	private final boolean isAuto;
	private final double shooterVel;
	private boolean isRev = false;

    public CameraTurn() {
        this(false, Globals.s_courtyardRPM);
    }
    
    public CameraTurn(boolean isAuto, double shooterVel) {
    	requires(chassis);
    	this.isAuto = isAuto;
    	this.shooterVel = shooterVel;
    }
    
    public CameraTurn(boolean isAuto) {
    	this(isAuto, Globals.s_courtyardRPM);
    }
    
    public CameraTurn(double shooterVel) {
    	this(false, shooterVel);
    }

    protected void initialize() {
    	System.out.println("Entering CameraStuff");
    	System.out.println(Timer.getMatchTime());
    	
    	if (!isRev) {
        	new RevShooter(Globals.s_courtyardRPM).start();
        	isRev = true;
    	}
    	
    	if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}) != null) {
    		Logger.println("Array length:  " +
    				grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length, logFile);
    		if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length > 0) {
    			int index = 0;
    			
    			if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length > 1) {
    				for (int i = 0;
    					 i < grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length;
    					 i++) {
    					
    					if (grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[index] <
    							grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[i]) {
    						index = i;
    					}
    				}
    				
    			}
    			Logger.println("Selecting index " + index, logFile);
    			centerX = grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0})[index];
    		} else {
    			centerX = 0;
    		}
    		error = Globals.s_cameraCenterX - centerX; // Pixels
    		
    		if (Math.abs(error) < Globals.t_cameraTurnPixels) {
    			inTolerance = true;
    		} else {
    			inTolerance = false;
    		}
    		Logger.println("Error: " + error + " , Tolerance: " + inTolerance, logFile);
    		
    		Logger.println("CenterX: " + centerX, logFile);
    		
    		error = error * -0.16; // pixels to degrees
    		
    		finalAngle = chassis.getAngle() + error;
    		error = finalAngle - chassis.getAngle();
    		calculator.clearIAccum();
    		Logger.println("TURN degree error: " + error, logFile);
    		
    	} else {
    		centerX = 0;
    		error = 0;
    		finalAngle = chassis.getAngle();
    		inTolerance = true;
    		Logger.println("No target detected", logFile);
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
    	
    	if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}) != null) {
    		if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length > 0) {
    			int index = 0;
    			
    			if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length == 2) {
    				if (grip.getNumberArray("myContoursReport/area", new Double[] {0.0})[0] <
    						grip.getNumberArray("myContoursReport/area", new Double[] {0.0})[1]) {
    					index = 1;
    				}
    				
    			}
    			centerX = grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0})[index];
    		} else {
    			centerX = 9;
    		}
    	} else {
    		centerX = 9;
    	}
    	
    	
    	if (Math.abs(Globals.s_cameraCenterX - centerX) >= Globals.t_cameraTurnPixels && !inTolerance) {
    		Logger.println("Reattempting CameraStuff", logFile);
    		new CameraTurn(isAuto).start();
    	} else {
    		Logger.println("Final centerX: " + centerX, logFile);
    		
    		if (isAuto) {
    			new ShootAndTurn().start();    			
    		} else {
    			new FireShooter(0.0).start();
    		}
    	}
    	
    	Logger.println("Exiting CameraStuff", logFile);
    	Logger.println("Match Time: " + Timer.getMatchTime(), logFile);
    	
    }

    protected void interrupted() {}
    
}
