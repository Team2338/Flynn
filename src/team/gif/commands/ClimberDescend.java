package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ClimberDescend extends Command {

    public ClimberDescend() {
        requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.climber.drive(-Globals.climberSpeed);
    }

    protected boolean isFinished() {
        return Robot.climber.getMin();
    }

    protected void end() {
    	Robot.climber.drive(0);
    }

    protected void interrupted() {}
    
}
