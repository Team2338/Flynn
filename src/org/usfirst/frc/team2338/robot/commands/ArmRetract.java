package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmRetract extends Command {

    public ArmRetract() {
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.drive(-Globals.armSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.getLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.drive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
