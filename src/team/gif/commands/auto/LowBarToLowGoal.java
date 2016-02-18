package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.auto.Turn;

/**
 * @author PatrickUbelhor
 */
public class LowBarToLowGoal extends CommandGroup {
    
    public  LowBarToLowGoal() {
        addSequential(new DriveStraightEnc(10000));	// Drives under low bar
        addSequential(new Turn(45));				// Turns toward low goal
        addSequential(new DriveStraightEnc(30000));	// Drives to low goal
        // ? addSequential(new DriveStraight(0.25);	// Drives over batter
        // addSequential(new ShooterEject());
    }
}
