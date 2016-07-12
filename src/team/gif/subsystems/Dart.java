package team.gif.subsystems;

import static team.gif.RobotMap.*;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.Motorized;
import team.gif.Globals;
import team.gif.commands.shooter.ShooterAngleStandby;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Dart extends lib.gif.commands.Subsystem implements Motorized {
	
	public enum Level {
		DOWN, MID, LOW, OUTERWORKS, HIGH, AUTOSHOT
	}
    
	private static final CANTalon dart = new CANTalon(mp_dart);
	private static final AnalogPotentiometer pot = new AnalogPotentiometer(sp_dartPotentiometer);
	private static double setpoint;
	
	public Dart() {
		super();
		dart.enableBrakeMode(true);
		setpoint = pot.get();
	}
		
	public void setStandbySetpoint(double position) {
		setpoint = position;
	}
	
	public double getStandbySetpoint() {
		return setpoint;
	}
	
	@Override
	public void drive(double speed) {
		if (dart.getOutputCurrent() < 30) {
			dart.set(speed);
		}
	}
	
	@Override
	public void displayMetrics() {
		SmartDashboard.putNumber("ShooterPotentiometer: ", getPosition());
	}

	@Override
	public double getPosition() {
		return pot.get();
	}

	@Override
	public boolean getHardMaxLimit() {
		return false;
	}

	@Override
	public boolean getHardMinLimit() {
		return false;
	}

	@Override
	public boolean getSoftMaxLimit() {
		return getPosition() > Globals.t_dartSoftMax;
	}

	@Override
	public boolean getSoftMinLimit() {
		return getPosition() < Globals.t_dartSoftMin;
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ShooterAngleStandby());
	}
    
}
