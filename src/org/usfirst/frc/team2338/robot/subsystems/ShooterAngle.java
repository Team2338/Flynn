package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class ShooterAngle extends Subsystem {
    
	private static final CANTalon shooterAngle = new CANTalon(RobotMap.shooterAngle);
	
	private static final DigitalInput shooterMinAngle = new DigitalInput(RobotMap.shooterMinAngle);
	private static final DigitalInput shooterMaxAngle = new DigitalInput(RobotMap.shooterMaxAngle);

	public void drive(double speed) {
		shooterAngle.set(speed);
	}
	
	public boolean getMin() {
		return shooterMinAngle.get();
	}
	
	public boolean getMax() {
		return shooterMaxAngle.get();
	}
		
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterAngleStandby());
    }
}

