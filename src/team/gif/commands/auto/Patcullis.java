package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.CollectorAngle.Level;
import team.gif.subsystems.*;

/**
 *
 */
public class Patcullis extends CommandGroup {
    
    public Patcullis() {
        addSequential(new CollectorSetAngle(Level.DOWN));
        addParallel(new CollectorAngleStandby());
        addSequential(new ShooterSetAngle(Dart.Level.DOWN));
        addSequential(new ShooterAngleStandby());
        addSequential(new DriveStraightEnc(17000, .5));
        addSequential(new CameraTurn());
    }
}
