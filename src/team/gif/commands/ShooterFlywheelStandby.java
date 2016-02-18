package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterFlywheelStandby extends Command {

    public ShooterFlywheelStandby() {
    	requires(Robot.shooter);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooter.driveFlywheel(0);
    	Robot.shooter.drivePolycord(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
