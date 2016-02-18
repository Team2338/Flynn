package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterAngleStandby extends Command {

    public ShooterAngleStandby() {
    	requires(Robot.shooterAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooterAngle.drive(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
