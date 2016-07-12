package team.gif.commands.collector;

import static team.gif.Flynn.intake;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import team.gif.Globals;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class IntakeEject extends lib.gif.commands.Command {

    public IntakeEject() {
    	requires(intake);
    }

    protected void initialize() {
    	intake.setMode(TalonControlMode.PercentVbus);
    }

    protected void execute() {
    	intake.driveFlywheel(-Globals.m_shooterFlywheelSpeed);
    	intake.driveChamber(-Globals.m_shooterPolycordSpeed);
    	intake.driveReceptor(-Globals.m_collectorPolycordSpeed);
   }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	intake.driveFlywheel(0);
    	intake.driveChamber(0);
    	intake.driveReceptor(0);
    }

    protected void interrupted() {
    	end();
    }
    
}
