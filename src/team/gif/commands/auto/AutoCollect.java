package team.gif.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import team.gif.Globals;
import static team.gif.Flynn.intake;

/**
 * @author PatrickUbelhor, DerekHo, and ArmaanShah 
 */
public class AutoCollect extends lib.gif.commands.Command {

    public AutoCollect() {
    	requires(intake);
    }

    protected void initialize() {
    	intake.setMode(TalonControlMode.PercentVbus);
    }

    protected void execute() {
    	intake.driveChamber(Globals.m_shooterPolycordSpeed);
    	intake.driveFlywheel(Globals.m_shooterFlywheelSpeed);
    	intake.driveReceptor(Globals.m_collectorPolycordSpeed);
    }

    protected boolean isFinished() {
        return intake.getLimit();
    }

    protected void end() {
    	intake.driveChamber(Globals.m_shooterPolycordSpeed);
    	Timer.delay(0.1);
    	
    	intake.driveChamber(0);
    	intake.driveFlywheel(0);
    	intake.driveReceptor(0);
    }

    protected void interrupted() {
    	intake.driveChamber(0);
    	intake.driveFlywheel(0);
    	intake.driveReceptor(0);
    }
    
}
