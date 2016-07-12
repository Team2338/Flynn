package team.gif.commands.auto;

import lib.gif.PIDCalculator;
import team.gif.Globals;

import static team.gif.Flynn.chassis;
import static team.gif.Flynn.grip;

public class CameraDrive extends lib.gif.commands.Command {
	
	private double finalDist;
	private double angle;
	private double centerY;
	private double error;
	private boolean inTolerance;
	private final double speedCap = 0.7;
	private final double pixelTolerance = 25;
	private final double distanceConversionFactor = -65.0;
	private PIDCalculator distCalculator;
	private PIDCalculator angleCalculator;

    public CameraDrive() {
    	distCalculator = new PIDCalculator(Globals.k_driveStraightDistP, 0, 0);
    	angleCalculator = new PIDCalculator(Globals.k_driveStraightAngleP, 0, 0);
    }

    protected void initialize() {
    	System.out.println("Entering CameraDrive");
    	chassis.resetEncoders();
    	angle = chassis.getAngle();
    	
    	if (grip.getNumberArray("myContoursReport/centerY", new Double[] {0.0}) != null) {
    		System.out.println("Array length:  " +
    				grip.getNumberArray("myContoursReport/centerY", new Double[] {0.0}).length);
    		if (grip.getNumberArray("myContoursReport/centerY", new Double[] {0.0}).length > 0) {
    			int index = 0;
    			
    			if (grip.getNumberArray("myContoursReport/centerY", new Double[] {0.0}).length == 2) {
    				if (grip.getNumberArray("myContoursReport/area", new Double[] {0.0})[0] <
    						grip.getNumberArray("myContoursReport/area", new Double[] {0.0})[1]) {
    					index = 1;
    				}
    				
    			}
    			
    			System.out.println("Selecting index " + index);
    			centerY = grip.getNumberArray("myContoursReport/centerY", new Double[] {0.0})[index];
    		} else {
    			centerY = 0;
    		}
    		error = Globals.s_cameraCenterY - centerY; // Pixels
    		
    		if (Math.abs(error) < pixelTolerance) { // Pixels
    			inTolerance = true;
    		} else {
    			inTolerance = false;
    		}
    		System.out.println("Error: " + error + " , Tolerance: " + inTolerance);
    		
    		System.out.println("CenterY: " + centerY);
    		
    		error = error * distanceConversionFactor; // pixels to distance
    		
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
