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
        requires(Robot.shooter);
    }

    protected void initialize() {
    	initialTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    	Robot.shooter.driveFlywheel(Globals.shooterFlywheelSpeed);
    	
    	if (Timer.getFPGATimestamp() - initialTime > Globals.shooterFlywheelTime) {
    		Robot.shooter.drivePolycord(Globals.shooterPolycordSpeed);
    	}
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - initialTime > Globals.shooterFlywheelTime + 2;
    }

    protected void end() {
    	Robot.shooter.driveFlywheel(0);
    	Robot.shooter.drivePolycord(0);
    }

    protected void interrupted() {}
    
}
