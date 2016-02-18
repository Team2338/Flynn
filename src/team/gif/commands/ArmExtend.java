package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ArmExtend extends Command {

    public ArmExtend() {
    	requires(Robot.arm);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.arm.drive(Globals.armSpeed);
    }

    protected boolean isFinished() {
        return Robot.arm.getMax();
    }

    protected void end() {
    	Robot.arm.drive(0);
    }

    protected void interrupted() {}
    
}
