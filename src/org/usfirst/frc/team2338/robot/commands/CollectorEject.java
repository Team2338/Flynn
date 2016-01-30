package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorEject extends Command {

    public CollectorEject() {
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.drive(-Globals.collectorSpeed);
   }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
