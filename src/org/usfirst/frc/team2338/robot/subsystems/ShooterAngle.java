package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterAngle extends Subsystem {
    
	private static final CANTalon shooterAngleLeft = new CANTalon(RobotMap.shooterAngleLeft);
	private static final CANTalon shooterAngleRight = new CANTalon(RobotMap.shooterAngleRight);

	public void drive(double speed) {
		shooterAngleLeft.set(speed);
		shooterAngleRight.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterAngleStandby());
    }
}

