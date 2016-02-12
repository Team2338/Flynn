package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterFlywheel extends Subsystem {
    
	private static final CANTalon shooterFlywheelLeft = new CANTalon(RobotMap.shooterFlywheelLeft);
	private static final CANTalon shooterFlywheelRight = new CANTalon(RobotMap.shooterFlywheelRight);
	
	public ShooterFlywheel() {
		super();
	}

	public void drive(double speed) {
		shooterFlywheelLeft.set(speed);
		shooterFlywheelRight.set(-speed);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterFlywheelStandby());
    }
}

