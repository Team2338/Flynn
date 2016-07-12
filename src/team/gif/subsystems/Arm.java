package team.gif.subsystems;

import static team.gif.RobotMap.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Arm extends lib.gif.commands.Subsystem {
	private static final CANTalon arm = new CANTalon(mp_sallyArm);
	private static final DigitalInput minLimit = new DigitalInput(sp_sallyArmMin);
	private static final DigitalInput maxLimit = new DigitalInput(sp_sallyArmMax);
	
	public Arm() {
		super();
		arm.enableBrakeMode(false);
		arm.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		arm.setPosition(0);
	}
	
	public void drive(double speed) {
		if ((getPosition() < 0 && speed < 0) || (getMin() && speed < 0) || (getMax() && speed > 0)) {
			arm.set(0);
		} else {			
			arm.set(speed);
		}
	}
	
	public void displayMetrics() {}
	
	public boolean getMin() {
		return !minLimit.get();
	}
	
	public boolean getMax() {
		return !maxLimit.get();
	}
	
	public double getPosition() {
		return -arm.getPosition();
	}

    public void initDefaultCommand() {}
    
}
