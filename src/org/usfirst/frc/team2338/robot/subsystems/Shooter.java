package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private static final CANTalon shooterRight = new CANTalon(RobotMap.shooterRight);
	private static final CANTalon shooterLeft = new CANTalon(RobotMap.shooterLeft);
	
	public Shooter() {
		super();
	}

	public void drive(double speed) {
		shooterRight.set(speed);
		shooterLeft.set(-speed);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterStandby());
    }
}

