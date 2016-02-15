package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class ShooterFire extends Command {
	
	private double initialTime;
	
    public ShooterFire() {
        requires(Robot.shooterFlywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterFlywheel.driveFlywheel(Globals.shooterFlywheelSpeed);
    	
    	if (Timer.getFPGATimestamp() - initialTime > Globals.shooterFlywheelTime) {
    		Robot.shooterFlywheel.drivePolycord(Globals.shooterPolycordSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - initialTime > 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterFlywheel.driveFlywheel(0);
    	Robot.shooterFlywheel.drivePolycord(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
