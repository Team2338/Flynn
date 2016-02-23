package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
// TODO: Test if PID will bring velocity to 0 in standby mode. If not... (see next)
// TODO: Add enableManualControl() method for setting speed to absolute zero
// TODO: Implement enableVelocityControl() in Commands
public class Shooter extends Subsystem {
    
	private static final CANTalon shooterFlywheel = new CANTalon(shooterFlywheelPort);
	private static final CANTalon shooterPolycord = new CANTalon(shooterPolycordPort);
	
	public Shooter() {
		super();
	}

	// NOTE: in PID control, this is in ticks per 100 ms
	public void driveFlywheel(double speed) {
		shooterFlywheel.set(speed);
	}
	
	public void drivePolycord(double speed) {
		shooterPolycord.set(speed);
	}
	
	public double getFlywheelSetpoint() {
		return shooterFlywheel.getSetpoint();
	}
	
	public double getFlywheelError() {
		return shooterFlywheel.getClosedLoopError();
	}
	
	public double getPolycordError() {
		return shooterPolycord.getClosedLoopError();
	}

	public void enableVelocityControl() {
		shooterFlywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterFlywheel.changeControlMode(TalonControlMode.Speed);
		shooterFlywheel.setPID(Globals.shooterFlywheelP, Globals.shooterFlywheelI, Globals.shooterFlywheelD, Globals.shooterFlywheelF, 0, 0, 0);
		driveFlywheel(0);
	}
	
	public  double ShooterVel(){
		return shooterFlywheel.getEncVelocity();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterFlywheelStandby());
    }
}
