package org.usfirst.frc.team2338.robot.subsystems;

<<<<<<< HEAD
import org.usfirst.frc.team2338.robot.OI;
=======
import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;
>>>>>>> refs/remotes/origin/master

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterAngle extends Subsystem {
    
<<<<<<< HEAD
	private static final CANTalon shooterAngle = new CANTalon(8);

	public void drive(){
		shooterAngle.set(OI.auxStick.getY());
	}
	
	public void stop() {
		shooterAngle.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
=======
	private static final CANTalon shooterAngleLeft = new CANTalon(RobotMap.shooterAngleLeft);
	private static final CANTalon shooterAngleRight = new CANTalon(RobotMap.shooterAngleRight);

	public void drive(double speed) {
		shooterAngleLeft.set(speed);
		shooterAngleRight.set(speed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterAngleStandby());
>>>>>>> refs/remotes/origin/master
    }
}

