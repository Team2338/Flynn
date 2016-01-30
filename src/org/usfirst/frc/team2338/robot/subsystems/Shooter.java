package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.Globals;
import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private static final CANTalon shooterRight = new CANTalon(RobotMap.shooterRight);
	private static final CANTalon shooterLeft = new CANTalon(RobotMap.shooterLeft);
	
	public Shooter() {
		super();
		enableVelocityControl();
		shooterRight.set(0);
		shooterLeft.set(0);	
		
	}

	public void drive(double speed) {
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
	
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterStandby());
    }
}

