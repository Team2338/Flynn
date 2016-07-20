package team.gif.subsystems;

import static team.gif.RobotMap.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.StatusFrameRate;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.commands.collector.IntakeStandby;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Intake extends lib.gif.commands.Subsystem {
    
	private static final CANTalon flywheel = new CANTalon(mp_shooterFlywheel);
	private static final CANTalon flywheel2 = new CANTalon(mp_shooterFlywheel2);
	private static final CANTalon chamber = new CANTalon(mp_shooterPolycord);
	private static final CANTalon receptor = new CANTalon(mp_collectorPolycord);
	private static final DigitalInput intakeLimit = new DigitalInput(sp_intakeLimit);
	private static final Solenoid intakeLimitPower = new Solenoid(0);
	
	public Intake() {
		super();
		
		flywheel.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
		
		flywheel.enableBrakeMode(true);
		flywheel2.enableBrakeMode(true);
		chamber.enableBrakeMode(true);
		receptor.enableBrakeMode(true);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.setPID(Globals.k_flywheelP, Globals.k_flywheelI, Globals.k_flywheelD);
		flywheel.setF(Globals.k_flywheelF);
		flywheel.setIZone(Globals.k_flywheelIZone);
		flywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		flywheel.setPosition(0);
		
		flywheel.reverseOutput(true);
		flywheel.reverseSensor(false);
		chamber.setInverted(true);
		receptor.setInverted(true);
//		flywheel.setInverted(true);
		
		flywheel2.changeControlMode(TalonControlMode.Follower);
		flywheel2.set(mp_shooterFlywheel);
		
		intakeLimitPower.set(true);
		
	}
	
	public void setMode(TalonControlMode mode) {
		flywheel.changeControlMode(mode);
	}
	
	public void displayMetrics() {
		SmartDashboard.putNumber("ShooterVelocity", getVelocity());
		SmartDashboard.putNumber("ShooterError", getError());
		SmartDashboard.putNumber("P Gain", getPGain());
    	SmartDashboard.putNumber("I Gain", getIGain());
    	SmartDashboard.putNumber("D Gain", getDGain());
    	SmartDashboard.putNumber("F Gain", getFGain());
//    	SmartDashboard.putNumber("Fly1", flywheel.getOutputVoltage());
//    	SmartDashboard.putNumber("Fly2", flywheel2.getOutputVoltage());
	}
		
	public double getVelocity() {
		return flywheel.getSpeed();
	}
	
	public double getError() {
		return flywheel.getError();
	}
	
	public void driveFlywheel(double speed) {
		flywheel.setP(speed > Globals.s_batterPinRPM ?
						Globals.k_flywheelCourtyardP : Globals.k_flywheelP);
		flywheel.set(speed);
	}
	
	public void driveChamber(double speed) {
		chamber.set(speed);
	}
	
	public void driveReceptor(double speed) {
		receptor.set(speed);
	}
	
	public boolean getLimit() {
		return intakeLimit.get();
	}
	
	public double getChamberCurrent() {
		return chamber.getOutputCurrent();
	}
	
	public double getPGain() {
		return flywheel.getP() * flywheel.getError() / 1023;
	}
	
	public double getIGain() {
		return flywheel.GetIaccum() / 1023;
	}
	
	public double getDGain() {
		return flywheel.getD() * flywheel.getSpeed() * (flywheel.getError() / 
				Math.abs(flywheel.getError())) / 1023;
	}
	
	public double getFGain() {
		return flywheel.getF() * flywheel.getSetpoint() / 1023;
	}
	
	public double getSetpoint() {
		return flywheel.getSetpoint();
	}
	
	public void resetIAccum() {
		flywheel.clearIAccum();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeStandby());
    }
    
}
