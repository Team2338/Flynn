package team.gif.commands;

import static team.gif.Flynn.chassis;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ResetGyro extends lib.gif.commands.Command {

    public ResetGyro() {
    	requires(chassis);
    }

    protected void initialize() {
    	chassis.resetGyro();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    protected void interrupted() {}
    
}
