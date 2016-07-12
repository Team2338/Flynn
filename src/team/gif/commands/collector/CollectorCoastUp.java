package team.gif.commands.collector;

import team.gif.Globals;
import static team.gif.Flynn.collectorAngle;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorCoastUp extends lib.gif.commands.Command {
	

    public CollectorCoastUp() {
    	requires(collectorAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	collectorAngle.drive(Globals.m_collectorAngleSpeed);
    }

    protected boolean isFinished() {
    	if (collectorAngle.getHardMaxLimit()) {
    		collectorAngle.resetPosition();
    		collectorAngle.setStandbySetpoint(1); // Keeps collector pressed against limit.
    		return true;
    	}
    	return false;
    }

    protected void end() {
    	collectorAngle.drive(0);
    }

    protected void interrupted() {
    	end();
    }
    
}
