package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.shooter.FireShooter;
import team.gif.commands.shooter.ShooterAngleStandby;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.Dart;

/**
 *
 */
public class ShootAndTurn extends CommandGroup {
    
    public  ShootAndTurn() {
    	addSequential(new FireShooter(0.0, Globals.s_courtyardRPM));
        addSequential(new ShooterSetAngle(Dart.Level.MID));
        addParallel(new ShooterAngleStandby());
        addSequential(new Turn(180, false));
//        addSequential(new DriveStraightEnc(16000));
    }
}
