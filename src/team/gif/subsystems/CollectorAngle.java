package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
// TODO: Add PID control
public class CollectorAngle extends Subsystem {
    
	private static final CANTalon collectorAngleLeft = new CANTalon(collectorAngleLeftPort);
	private static final CANTalon collectorAngleRight = new CANTalon(collectorAngleRightPort);
	
	private static final DigitalInput collectorMinAngle = new DigitalInput(collectorMinAnglePort);
	private static final DigitalInput collectorMaxAngle = new DigitalInput(collectorMaxAnglePort);
	
	public CollectorAngle() {
		super();
	}
	
	public void drive(double speed) {
		collectorAngleLeft.set(speed);
		collectorAngleRight.set(speed);
	}
	
	public boolean getMin() {
		return collectorMinAngle.get();
	}
	
	public boolean getMax() {
		return collectorMaxAngle.get();
	}
	
	public double getRightCollectorSetpoint(){
		return collectorAngleRight.getSetpoint();
	}
	
	public double getLeftCollectorSetpoint(){
		return collectorAngleLeft.getSetpoint();
	}
	
	public double getRightCollectorError(){
		return collectorAngleRight.getClosedLoopError();
	}
	
	public double getLeftCollectorError(){
		return collectorAngleLeft.getClosedLoopError();
	}

	public void enableCollectorPositionControl(){
		collectorAngleRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		collectorAngleLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		collectorAngleRight.changeControlMode(TalonControlMode.Position);
		collectorAngleLeft.changeControlMode(TalonControlMode.Position);
		collectorAngleRight.setPID(Globals.collectorAngleP, Globals.collectorAngleI, Globals.collectorAngleD, Globals.collectorAngleF, 0, 0, 0);
		drive(0);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorAngleStandby());
    }
}
