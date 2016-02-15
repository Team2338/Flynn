package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class ShooterDown extends Command {

    public ShooterDown() {
    	requires(Robot.shooterAngle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterAngle.drive(-Globals.shooterAngleSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooterAngle.getMin();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterAngle.drive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
