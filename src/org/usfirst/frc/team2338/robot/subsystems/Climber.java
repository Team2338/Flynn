package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class Climber extends Subsystem {
	private static final CANTalon climber = new CANTalon(RobotMap.climber);
	
	private static final DigitalInput climberMin = new DigitalInput(RobotMap.climberMin);
	private static final DigitalInput climberMax = new DigitalInput(RobotMap.climberMax);
    
	public Climber() {
		super();
	}

	public void drive(double speed) {
		climber.set(speed);
	}
	
	public boolean getMin() {
		return climberMin.get();
	}
	
	public boolean getMax() {
		return climberMax.get();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberStandby());
    }
}

