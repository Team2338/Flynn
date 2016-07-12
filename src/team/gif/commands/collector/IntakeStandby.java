package team.gif.commands.collector;

import static team.gif.Flynn.intake;

import lib.gif.commands.Command;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class IntakeStandby extends Command {
	
    public IntakeStandby() {
    	requires(intake);
    }

    protected void initialize() {
    	intake.setMode(TalonControlMode.PercentVbus);
    	intake.driveFlywheel(0);
    	intake.driveChamber(0);
    	intake.driveReceptor(0);
    }

    protected void execute() {}

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {}

    protected void interrupted() {
    	end();
    }
    
}
