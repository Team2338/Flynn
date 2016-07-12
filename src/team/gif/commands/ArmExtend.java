package team.gif.commands;

import team.gif.Globals;
import static team.gif.Flynn.arm;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ArmExtend extends lib.gif.commands.Command {

    public ArmExtend() {
    	requires(arm);
    }

    protected void initialize() {}

    protected void execute() {
    	arm.drive(Globals.m_armSpeed);
    }

    protected boolean isFinished() {
        return arm.getMax();
    }

    protected void end() {
    	arm.drive(0);
    }

    protected void interrupted() {
    	arm.drive(0);
    }
    
}
