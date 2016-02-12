package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class ShooterFlywheelStandby extends Command {

    public ShooterFlywheelStandby() {
    	requires(Robot.shooterFlywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterFlywheel.driveFlywheel(0);
    	Robot.shooterFlywheel.drivePolycord(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}