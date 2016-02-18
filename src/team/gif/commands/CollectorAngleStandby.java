package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorAngleStandby extends Command {

    public CollectorAngleStandby() {
    	requires(Robot.collectorAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.collectorAngle.drive(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
