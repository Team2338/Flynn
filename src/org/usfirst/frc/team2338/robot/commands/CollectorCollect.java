package org.usfirst.frc.team2338.robot.commands;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.Robot;
<<<<<<< HEAD
=======
import org.usfirst.frc.team2338.robot.subsystems.CollectorReceptor;
>>>>>>> refs/remotes/origin/master

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorCollect extends Command {

    public CollectorCollect() {
    	requires(Robot.collectorReceptor);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.collectorReceptor.drive(Globals.collectorReceptorSpeed);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    }
}
