package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private static final CANTalon arm = new CANTalon(RobotMap.arm);
	
	private static final DigitalInput armLimit = new DigitalInput(RobotMap.armLimit);
	
	public Arm() {
		super();
	}
	
	public void drive(double speed) {
		arm.set(speed);
	}
	
	public boolean getLimit() {
		return armLimit.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmStandby());
    }
}

