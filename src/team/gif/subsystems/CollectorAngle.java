package team.gif.subsystems;

import static team.gif.RobotMap.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.Motorized;
import team.gif.commands.collector.CollectorAngleStandby;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorAngle extends lib.gif.commands.Subsystem implements Motorized {
	
	public enum Level {
		UP, MID, DOWN
	}
    
	private static final CANTalon leftAngle = new CANTalon(mp_collectorAngleLeft);
	private static final CANTalon rightAngle = new CANTalon(mp_collectorAngleRight);
	private static final DigitalInput maxLimit = new DigitalInput(sp_collectorMax);
	private static final Encoder encoder = new Encoder(sp_collectorEncoderA,
														sp_collectorEncoderB);
	
//	private static final AnalogTrigger leftTrigger = new AnalogTrigger(1);
//	private static final AnalogTrigger rightTrigger = new AnalogTrigger(2);
//	private static final Counter leftCounter = new Counter(leftTrigger);
//	private static final Counter rightCounter = new Counter(rightTrigger);
	
	private static double setpoint;
	private static final double softMinPosition = -100;
	
	public CollectorAngle() {
		super();
		
		leftAngle.enableBrakeMode(true);
		rightAngle.enableBrakeMode(true);
		
		rightAngle.changeControlMode(TalonControlMode.Follower);
		rightAngle.set(mp_collectorAngleLeft);
		
		setpoint = getPosition();
//		leftTrigger.setLimitsVoltage(2.00, 3.20);
	}
	
	public void setStandbySetpoint(double position) {
		setpoint = position;
	}
	
	public double getStandbySetpoint() {
		return setpoint;
	}
	
	@Override
	public void drive(double speed) {
		leftAngle.set(getHardMaxLimit() && speed > 0 ? 0 : speed);
	}
	
	@Override
	public void displayMetrics() {
		SmartDashboard.putBoolean("CollectorAngleMax: ", getHardMaxLimit());
		SmartDashboard.putNumber("CollectorPosition: ", getPosition());
	}

    @Override
    public void resetPosition() {
    	encoder.reset();
    }
    
	@Override
	public double getPosition() {
		return encoder.get();
	}

	@Override
	public boolean getHardMaxLimit() {
		return !maxLimit.get();
	}

	@Override
	public boolean getHardMinLimit() {
		return false;
	}

	@Override
	public boolean getSoftMaxLimit() {
		return false;
	}

	@Override
	public boolean getSoftMinLimit() {
		return getPosition() < softMinPosition;
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new CollectorAngleStandby());
	}
    
}
