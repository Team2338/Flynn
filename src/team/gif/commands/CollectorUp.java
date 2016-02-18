package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorUp extends Command {

    public CollectorUp() {
    	requires(Robot.collectorAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.collectorAngle.drive(Globals.collectorAngleSpeed);
    }

    protected boolean isFinished() {
        return Robot.collectorAngle.getMax();
    }

    protected void end() {
    	Robot.collectorAngle.drive(0);
    }

    protected void interrupted() {}
    
}
