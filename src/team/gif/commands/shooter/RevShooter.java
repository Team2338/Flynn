package team.gif.commands.shooter;

import static team.gif.Flynn.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.auto.WaitCommand;
import team.gif.commands.collector.IntakeCollect;

/**
 * @author PatrickUbelhor
 */
public class RevShooter extends CommandGroup {
    
    public  RevShooter(double setpoint) {
    	addSequential(new IntakeCollect(0.1));
        addSequential(new WaitCommand(0.1));
        addSequential(new RevFlywheel(setpoint));
    }
    
    private class RevFlywheel extends lib.gif.commands.Command {
    	
    	private final double setpoint;

        private RevFlywheel(double setpoint) {
            requires(intake);
            this.setpoint = setpoint;
        }

        protected void initialize() {
        	intake.setMode(TalonControlMode.Speed);
        	intake.driveReceptor(0);
        }

		@Override
		protected void execute() {
			intake.driveFlywheel(setpoint);
		}

		@Override
		protected boolean isFinished() {
			return false;
		}

		@Override
		protected void end() {}

		@Override
		protected void interrupted() {}
    	
    }
}
