package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.auto.DriveStraightEnc;

/**
 * @author PatrickUbelhor
 */
public class CrossDrawbridge extends CommandGroup {
    
    public  CrossDrawbridge() {
        addSequential(new DriveStraightEnc(1000));
//        addSequential(new LowerArm()); // Contact bridge
//        addParallel(new LowerArm()); // Lower bridge while backing up
        addSequential(new DriveStraightEnc(-500));
//        addParallel(new LowerCollector()); // Lower collector to contact bridge
//        addParallel(new RaiseArm());
        addSequential(new DriveStraightEnc(800)); // Drive onto bridge
//        addSequential(new RaiseCollector());
        addSequential(new DriveStraightEnc(2500));
    }
}
