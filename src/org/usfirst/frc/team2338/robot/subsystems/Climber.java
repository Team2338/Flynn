package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	private static final CANTalon climberLeft = new CANTalon(RobotMap.climberLeft);
	private static final CANTalon climberRight = new CANTalon(RobotMap.climberRight);
    
	public Climber() {
		super();
	}

	public void drive(double leftSpeed, double rightSpeed) {
		climberLeft.set(leftSpeed);
		climberRight.set(rightSpeed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberStandby());
    }
}

