package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ArmStandby extends Command {

    public ArmStandby() {
    	requires(Robot.arm);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.arm.drive(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
