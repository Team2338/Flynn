package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class Arm extends Subsystem {
	private static final CANTalon arm = new CANTalon(RobotMap.arm);
	
	private static final DigitalInput armMin = new DigitalInput(RobotMap.armMin);
	private static final DigitalInput armMax = new DigitalInput(RobotMap.armMax);
	
	public Arm() {
		super();
	}
	
	public void drive(double speed) {
		arm.set(speed);
	}
	
	public boolean getMin() {
		return armMin.get();
	}
	
	public boolean getMax() {
		return armMax.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmStandby());
    }
}

