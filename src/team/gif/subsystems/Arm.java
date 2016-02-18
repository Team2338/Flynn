package team.gif.subsystems;

import static team.gif.Globals.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.*;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Arm extends Subsystem {
	private static final CANTalon arm = new CANTalon(armPort);
	
	private static final DigitalInput armMin = new DigitalInput(armMinPort);
	private static final DigitalInput armMax = new DigitalInput(armMaxPort);
	
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
