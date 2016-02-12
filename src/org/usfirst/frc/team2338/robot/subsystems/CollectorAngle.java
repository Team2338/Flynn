package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class CollectorAngle extends Subsystem {
    
	private static final CANTalon collectorAngle = new CANTalon(RobotMap.collectorAngle);
	
	public CollectorAngle() {
		super();
	}
	
	public void drive(double speed) {
		collectorAngle.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorAngleStandby());
    }
}

