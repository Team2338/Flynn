package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.RobotMap;
import org.usfirst.frc.team2338.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Derek Ho, Armaan Shah, and Patrick Ubelhor
 */
public class CollectorReceptor extends Subsystem {
	
	private static final CANTalon collectorReceptor = new CANTalon(RobotMap.collectorReceptor);
	
	public CollectorReceptor() {
		super();
	}
	
	public void drive(double speed) {
		collectorReceptor.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorReceptorStandby());
    }
}

