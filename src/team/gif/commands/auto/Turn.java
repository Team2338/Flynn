package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;

import static team.gif.Robot.chassis;

public class Turn extends Command {

	private double angle = 0;
	private double error = 0;
	private double Kp = 0;
	private double finalAngle = 0;
	private final boolean userDefined;
	
    public Turn(double angle) {
    	requires(chassis);
    	this.angle = angle;
    	this.Kp = Globals.turnKp;
    	userDefined = false;
    }
    
    public Turn() {
    	requires(chassis);
    	userDefined = true;
    }

    protected void initialize() {
    	if (userDefined) {
    		Kp = SmartDashboard.getNumber("TurnKp", Globals.turnKp);
    		angle = SmartDashboard.getNumber("TurnAngle", 0.0);
    	}
    	
    	finalAngle = chassis.getAngle() + angle;
    	
    }

    protected void execute() {
    	error = finalAngle - chassis.getAngle();
    	chassis.drive(Kp * error, -Kp * error);
    }

    protected boolean isFinished() {
        return Math.abs(error) < Globals.turnAngularPosTolerance &&
        		Math.abs(chassis.getRate()) < Globals.turnAngularVelTolerance;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
