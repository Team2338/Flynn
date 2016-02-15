package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class CollectorReceptorStandby extends Command {

    public CollectorReceptorStandby() {
    	requires(Robot.collectorReceptor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collectorReceptor.drive(0);
    }

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
