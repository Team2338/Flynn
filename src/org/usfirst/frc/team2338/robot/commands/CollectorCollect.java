package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;
import org.usfirst.frc.team2338.robot.subsystems.Collector;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorCollect extends Command {

    public CollectorCollect() {
    	requires(Robot.collector);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.collector.drive(Globals.collectorSpeed);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    }
}
