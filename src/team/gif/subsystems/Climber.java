package team.gif.subsystems;

import static team.gif.Globals.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
// FIXME: Add failsafe to prevent motor from going over 40 amps
public class Climber extends Subsystem {
	private static final CANTalon climber = new CANTalon(climberPort);
	
	private static final DigitalInput climberMin = new DigitalInput(climberMinPort);
	private static final DigitalInput climberMax = new DigitalInput(climberMaxPort);
    
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
