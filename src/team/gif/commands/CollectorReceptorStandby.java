package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorReceptorStandby extends Command {

    public CollectorReceptorStandby() {
    	requires(Robot.collectorReceptor);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.collectorReceptor.drive(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
