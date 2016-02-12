package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class ShooterAngle extends Subsystem {
    
	private static final CANTalon shooterAngle = new CANTalon(RobotMap.shooterAngle);

	public void drive(double speed) {
		shooterAngle.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterAngleStandby());
    }
}

