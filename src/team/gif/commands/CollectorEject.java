package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorEject extends Command {

    public CollectorEject() {
    	requires(Robot.collectorReceptor);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.collectorReceptor.drive(-Globals.collectorReceptorSpeed);
   }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
