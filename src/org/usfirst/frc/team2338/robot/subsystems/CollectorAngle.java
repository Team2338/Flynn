package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
=======
import edu.wpi.first.wpilibj.DigitalInput;
>>>>>>> refs/remotes/origin/master
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class CollectorAngle extends Subsystem {
    
	private static final CANTalon collectorAngle = new CANTalon(RobotMap.collectorAngle);
	
	private static final DigitalInput collectorMinAngle = new DigitalInput(RobotMap.collectorMinAngle);
	private static final DigitalInput collectorMaxAngle = new DigitalInput(RobotMap.collectorMaxAngle);
	
	public CollectorAngle() {
		super();
	}
	
	public void drive(double speed) {
		collectorAngle.set(speed);
	}
	
	public boolean getMin() {
		return collectorMinAngle.get();
	}
	
	public boolean getMax() {
		return collectorMaxAngle.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorAngleStandby());
    }
}

