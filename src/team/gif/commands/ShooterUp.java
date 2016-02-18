package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterUp extends Command {

    public ShooterUp() {
    	requires(Robot.shooterAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooterAngle.drive(Globals.shooterAngleSpeed);
    }

    protected boolean isFinished() {
        return Robot.shooterAngle.getMax();
    }

    protected void end() {
    	Robot.shooterAngle.drive(0);
    }

    protected void interrupted() {}
    
}