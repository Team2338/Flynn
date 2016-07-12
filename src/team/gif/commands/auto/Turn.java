package team.gif.commands.auto;

import lib.gif.PIDCalculator;
import team.gif.Globals;

import static team.gif.Flynn.chassis;

public class Turn extends lib.gif.commands.Command {

	private double angle = 0;
	private double finalAngle = 0;
	private double error = 0;
	private final boolean relative;
	private PIDCalculator calculator;
	
    public Turn(double angle) {
    	this(angle, true);
    }
    
    public Turn(double angle, boolean relative) {
    	requires(chassis);
    	this.angle = angle;
    	this.relative = relative;
    	calculator = new PIDCalculator(Globals.k_turnP, Globals.k_turnI,
    								   Globals.k_turnD, Globals.k_turnIZone);
    			
    }
    
    protected void initialize() {
    	finalAngle = angle;
    	if (relative) finalAngle += chassis.getAngle();
    	calculator.clearIAccum();
    	error = finalAngle - chassis.getAngle();
    	System.out.println("TURN error: " + error);
    }

    protected void execute() {
    	error = finalAngle - chassis.getAngle();
    	double output = calculator.getOutput(error);
    	chassis.drive(output, -output);
    }

    protected boolean isFinished() {
        return Math.abs(error) < Globals.t_turnAngularPos &&
        		Math.abs(chassis.getRate()) < Globals.t_turnAngularVel;
    }

    protected void end() {
    	chassis.drive(0, 0);
    }

    protected void interrupted() {
    	chassis.drive(0, 0);
    }
    
}
