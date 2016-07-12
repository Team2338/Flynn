package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.Dart.Level;
import team.gif.subsystems.*;

/**
 *
 */
public class Cheval extends CommandGroup {
    
    public  Cheval() {
    	
        addSequential(new DriveStraightEnc(9000, .5));
        addSequential(new CollectorSetAngle(CollectorAngle.Level.DOWN));
        addParallel(new CollectorAngleStandby());
        addSequential(new ShooterSetAngle(Level.MID));
    	addSequential(new ShooterAngleStandby());
    	addSequential(new DriveStraightEnc(10000, .5));
        addParallel(new CollectorSetAngle(CollectorAngle.Level.UP));
    }
}
