package team.gif.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author DerekHo, ArmaanShah, PatrickUbelhor
 */
public class WheelyBar extends Subsystem {
    
	private static final Relay deployer = new Relay(0);
	
	public void deploy() {
		deployer.set(Value.kForward);
	}
	
    public void initDefaultCommand() {}
    
}
