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
public class BackwardsLowBar extends CommandGroup {
    
    public  BackwardsLowBar() {
    	addSequential(new CollectorSetAngle(Level.DOWN));
    	addParallel(new CollectorAngleStandby());
    	addSequential(new ShooterSetAngle(Dart.Level.DOWN));
    	addParallel(new ShooterAngleStandby());
    	addSequential(new DriveStraightEnc(-19000, .5));
    	
    	addSequential(new CollectorSetAngle(Level.MID));
    	addParallel(new CollectorAngleStandby());
    	addSequential(new ShooterSetAngle(Dart.Level.OUTERWORKS));
    	addParallel(new ShooterAngleStandby());
    	addSequential(new Turn(180, false));
    	
    	addSequential(new WaitCommand(0.75));
    	addSequential(new CameraTurn(false));
    	
    }
}
