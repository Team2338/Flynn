package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Shooter extends Subsystem {
    
	private static final CANTalon shooterFlywheel = new CANTalon(shooterFlywheelPort);
	private static final CANTalon shooterPolycord = new CANTalon(shooterPolycordPort);
	
	public Shooter() {
		super();
	}

	public void driveFlywheel(double speed) {
		shooterFlywheel.set(speed);
	}
	
	public void drivePolycord(double speed) {
		shooterPolycord.set(speed);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterFlywheelStandby());
    }
}
