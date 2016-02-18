package team.gif.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterFire extends Command {
	
	private double initialTime;
	
    public ShooterFire() {
        requires(Robot.shooterFlywheel);
    }

    protected void initialize() {
    	initialTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    	Robot.shooterFlywheel.driveFlywheel(Globals.shooterFlywheelSpeed);
    	
    	if (Timer.getFPGATimestamp() - initialTime > Globals.shooterFlywheelTime) {
    		Robot.shooterFlywheel.drivePolycord(Globals.shooterPolycordSpeed);
    	}
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - initialTime > 5;
    }

    protected void end() {
    	Robot.shooterFlywheel.driveFlywheel(0);
    	Robot.shooterFlywheel.drivePolycord(0);
    }

    protected void interrupted() {}
    
}
