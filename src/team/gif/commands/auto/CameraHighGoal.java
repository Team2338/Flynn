package team.gif.commands.auto;

import team.gif.Globals;
import team.gif.commands.ResetGyro;
import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.CollectorAngle;
import team.gif.subsystems.Dart;

/**
 * @author PatrickUbelhor
 */
public class CameraHighGoal extends lib.gif.commands.CommandGroup {
    
    public  CameraHighGoal(double shooterVel) {
    	addSequential(new CollectorSetAngle(CollectorAngle.Level.MID));
    	addParallel(new CollectorAngleStandby());
    	addSequential(new ResetGyro());
    	addSequential(new DriveStraightEnc(18000));
        addSequential(new ShooterSetAngle(Dart.Level.AUTOSHOT));
        addParallel(new ShooterAngleStandby());
        addSequential(new WaitCommand(1.1));
//        addSequential(new CameraDrive());
        addSequential(new CameraTurn(true, shooterVel));
    }
    
    public CameraHighGoal() {
    	this(Globals.s_autoRPM);
    }
    
}
