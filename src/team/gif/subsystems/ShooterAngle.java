package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterAngle extends Subsystem {
<<<<<<< HEAD:src/org/usfirst/frc/team2338/robot/subsystems/ShooterAngle.java
	
	private static final CANTalon shooterAngle = new CANTalon(RobotMap.shooterAngle);
=======
    
	private static final CANTalon shooterAngle = new CANTalon(shooterAnglePort);
>>>>>>> refs/remotes/origin/reorganization:src/team/gif/subsystems/ShooterAngle.java
	
	private static final DigitalInput shooterMinAngle = new DigitalInput(shooterMinAnglePort);
	private static final DigitalInput shooterMaxAngle = new DigitalInput(shooterMaxAnglePort);

	public void drive(double speed) {
		shooterAngle.set(speed);
	}
	
	public boolean getMin() {
		return shooterMinAngle.get();
	}
	
	public boolean getMax() {
		return shooterMaxAngle.get();
	}
		
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterAngleStandby());
    }
}
