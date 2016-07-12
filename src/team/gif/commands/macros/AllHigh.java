package team.gif.commands.macros;

import team.gif.commands.auto.CollectorGoHigh;
import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.Dart;

public class AllHigh extends lib.gif.commands.CommandGroup {
    
    public  AllHigh() {
    	// SHOOTER MUST GO FIRST
    	addSequential(new ShooterSetAngle(Dart.Level.HIGH));
    	addParallel(new ShooterAngleStandby());
    	addSequential(new CollectorGoHigh());
        addParallel(new CollectorAngleStandby());
    }
}
