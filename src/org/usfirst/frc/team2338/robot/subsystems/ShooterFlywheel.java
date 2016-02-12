package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterFlywheel extends Subsystem {
    
	private static final CANTalon shooterFlywheelLeft = new CANTalon(RobotMap.shooterFlywheelLeft);
	private static final CANTalon shooterFlywheelRight = new CANTalon(RobotMap.shooterFlywheelRight);
	
	public ShooterFlywheel() {
		super();
		enableVelocityControl();
		shooterFlywheelRight.set(0);
		shooterFlywheelLeft.set(0);
	}

	public void drive(double speed) {
		shooterFlywheelLeft.set(speed);
		shooterFlywheelRight.set(-speed);
	}
	
	public double getRightSetpoint() {
		return shooterFlywheelRight.getSetpoint();
	}
	
	public double getLeftSetpoint() {
		return shooterFlywheelLeft.getSetpoint();
	}
	
	public double getRightError() {
		return shooterFlywheelRight.getClosedLoopError() ;
	}
	
	public double getLeftError() {
		return shooterFlywheelLeft.getClosedLoopError();
	}
	
	
	public void enableVelocityControl() {
		shooterFlywheelRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterFlywheelLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterFlywheelRight.changeControlMode(TalonControlMode.Speed);
		shooterFlywheelLeft.changeControlMode(TalonControlMode.Speed);
		shooterFlywheelRight.setPID(Globals.shooterP, Globals.shooterI, Globals.shooterD);
		shooterFlywheelLeft.setPID(Globals.shooterP, Globals.shooterI, Globals.shooterD);
		drive(0);
	}
	
	public static double rightShooterVel(){
		return shooterFlywheelRight.getEncVelocity();
	}
	
	public static double leftShooterVel(){
		return shooterFlywheelLeft.getEncVelocity();
	}
	
	public void dispShooterVel() {
		SmartDashboard.putNumber("Right Velocity", rightShooterVel());
		SmartDashboard.putNumber("Left Velocity", leftShooterVel());
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterFlywheelStandby());
    }
}

