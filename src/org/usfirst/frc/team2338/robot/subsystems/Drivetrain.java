
package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	public Drivetrain() {
		super();
		frontLeft.setPosition(0);
		frontRight.setPosition(0);
		rearLeft.setPosition(0);
		rearRight.setPosition(0);
	}
	
    public void drive(double leftSpeed, double rightSpeed) {
    	frontLeft.set(leftSpeed);
    	frontRight.set(-rightSpeed);
    	rearLeft.set(leftSpeed);
    	rearRight.set(-rightSpeed);
    }
    
    public void initDefaultCommand() {

    }
}

