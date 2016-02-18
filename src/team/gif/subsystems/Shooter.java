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
	public double getFlywheelSetpoint() {
		return shooterFlywheel.getSetpoint();
	}
	
	public double getPolycordSetpoint() {
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
		shooterPolycord.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterFlywheel.changeControlMode(TalonControlMode.Speed);
		shooterPolycord.changeControlMode(TalonControlMode.Speed);
		shooterFlywheel.setPID(Globals.shooterFlywheelP, Globals.shooterFlywheelI, Globals.shooterFlywheelD);
		shooterPolycord.setPID(Globals.shooterPolycordP, Globals.shooterPolycordI, Globals.shooterPolycordD);
		driveFlywheel(0);
		drivePolycord(0);
	}
	
	public  double ShooterVel(){
		return shooterFlywheel.getEncVelocity();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterFlywheelStandby());
    }
}