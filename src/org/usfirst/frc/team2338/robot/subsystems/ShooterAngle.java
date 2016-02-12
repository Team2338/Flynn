package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.OI;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterAngle extends Subsystem {
    
	private static final CANTalon shooterAngle = new CANTalon(8);

	public static void drive(){
		shooterAngle.set(OI.auxStick.getY());
	}
	
	public static void stop() {
		shooterAngle.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

