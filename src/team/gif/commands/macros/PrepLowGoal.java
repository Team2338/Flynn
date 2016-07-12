package team.gif.commands.macros;

import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.CollectorAngle;
import team.gif.subsystems.Dart;

public class PrepLowGoal extends lib.gif.commands.CommandGroup {
    
    public  PrepLowGoal() {
    	// COLLECTOR MUST GO FIRST
        addSequential(new CollectorSetAngle(CollectorAngle.Level.DOWN));
        addParallel(new CollectorAngleStandby());
        addSequential(new ShooterSetAngle(Dart.Level.LOW));
        addParallel(new ShooterAngleStandby());
    }
}
