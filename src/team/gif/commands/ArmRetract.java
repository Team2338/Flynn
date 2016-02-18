package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ArmRetract extends Command {

    public ArmRetract() {
    	requires(Robot.arm);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.arm.drive(-Globals.armSpeed);
    }

    protected boolean isFinished() {
        return Robot.arm.getMin();
    }

    protected void end() {
    	Robot.arm.drive(0);
    }

    protected void interrupted() {}
    
}
