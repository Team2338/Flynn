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
public class CollectorAngle extends Subsystem {
    
	private static final CANTalon collectorAngle = new CANTalon(RobotMap.collectorAngle);
	
	public CollectorAngle() {
		super();
		enableVelocityControl();
		shooterRight.set(0);
		shooterLeft.set(0);	
		
	}
<<<<<<< HEAD:src/org/usfirst/frc/team2338/robot/subsystems/Shooter.java

	public static void drive(double speed) {
		shooterRight.set(speed);
		shooterLeft.set(-speed);
	}
	
	public double getRightSetpoint() {
		return shooterRight.getSetpoint();
	}
	
	public double getLeftSetpoint() {
		return shooterLeft.getSetpoint();
	}
	
	public double getRightError() {
		return shooterRight.getClosedLoopError() ;
	}
	
	public double getLeftError() {
		return shooterLeft.getClosedLoopError();
	}
	
	public void enableVelocityControl() {
		shooterRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooterRight.changeControlMode(TalonControlMode.Speed);
		shooterLeft.changeControlMode(TalonControlMode.Speed);
		shooterRight.setPID(Globals.shooterP, Globals.shooterI, Globals.shooterD);
		shooterLeft.setPID(Globals.shooterP, Globals.shooterI, Globals.shooterD);
		drive(0);
	}
	
	public static double rightShooterVel(){
		return shooterRight.getEncVelocity();
	}
	
	public static double leftShooterVel(){
		return shooterLeft.getEncVelocity();
	}
	
	public void dispShooterVel() {
		SmartDashboard.putNumber("Right Velocity", rightShooterVel());
		SmartDashboard.putNumber("Left Velocity", leftShooterVel());
	}
	
	public void enableManualControl(){
		shooterRight.changeControlMode(TalonControlMode.PercentVbus);
		shooterLeft.changeControlMode(TalonControlMode.PercentVbus);
		drive(0);
		shooterRight.enableControl();
		shooterLeft.enableControl();
	}
	
=======
	
	public void drive(double speed) {
		collectorAngle.set(speed);
	}

>>>>>>> refs/remotes/origin/master:src/org/usfirst/frc/team2338/robot/subsystems/CollectorAngle.java
    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorAngleStandby());
    }
}

