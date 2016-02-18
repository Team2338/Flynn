package team.gif.subsystems;

import static team.gif.Globals.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorReceptor extends Subsystem {
	
	private static final CANTalon collectorReceptor = new CANTalon(collectorReceptorPort);
	
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

