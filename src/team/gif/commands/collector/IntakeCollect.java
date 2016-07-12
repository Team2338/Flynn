package team.gif.commands.collector;

import team.gif.Globals;
import static team.gif.Flynn.intake;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class IntakeCollect extends lib.gif.commands.Command {
	
    public IntakeCollect() {
    	this(60);
    }

    public IntakeCollect(double timeout) {
    	super(timeout);
    	requires(intake);
	}

	protected void initialize() {
    	intake.setMode(TalonControlMode.PercentVbus);
    }

    protected void execute() {
    	intake.driveFlywheel(Globals.m_shooterFlywheelSpeed);
    	intake.driveChamber(Globals.m_shooterPolycordSpeed);
    	intake.driveReceptor(Globals.m_collectorPolycordSpeed);
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    protected void end() {
    	intake.driveChamber(0);
    	intake.driveFlywheel(0);
    	intake.driveReceptor(0);
    }

    protected void interrupted() {
    	end();
    }
    
}
