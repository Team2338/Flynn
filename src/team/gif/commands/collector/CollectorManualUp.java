package team.gif.commands.collector;

import team.gif.Globals;
import static team.gif.Flynn.collectorAngle;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorManualUp extends lib.gif.commands.Command {
	
    public CollectorManualUp() {
    	requires(collectorAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	collectorAngle.drive(Globals.m_collectorAngleSpeed);
    }

    protected boolean isFinished() {
    	if (collectorAngle.getHardMaxLimit()) {
    		collectorAngle.setStandbySetpoint(1); // Keeps the collector pushed against limit.
    		return true;
    	}
        return false;
    }

    protected void end() {
    	collectorAngle.drive(0);
    	collectorAngle.setStandbySetpoint(collectorAngle.getPosition());
    }

    protected void interrupted() {
    	end();
    }
    
}
