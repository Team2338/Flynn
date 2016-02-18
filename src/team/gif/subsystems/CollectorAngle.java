package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorAngle extends Subsystem {
    
	private static final CANTalon collectorAngle = new CANTalon(collectorAnglePort);
	
	private static final DigitalInput collectorMinAngle = new DigitalInput(collectorMinAnglePort);
	private static final DigitalInput collectorMaxAngle = new DigitalInput(collectorMaxAnglePort);
	
	public CollectorAngle() {
		super();
	}
	
	public void drive(double speed) {
		collectorAngle.set(speed);
	}
	
	public boolean getMin() {
		return collectorMinAngle.get();
	}
	
	public boolean getMax() {
		return collectorMaxAngle.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorAngleStandby());
    }
}
