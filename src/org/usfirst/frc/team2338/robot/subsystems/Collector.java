package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.CollectorStandby;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	private static final CANTalon collector = new CANTalon(RobotMap.collector);
	
	public Collector() {
		super();
		
	}
	
	public void drive(double speed) {
		collector.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorStandby());
    }
}

