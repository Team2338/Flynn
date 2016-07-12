package team.gif.commands.collector;

import team.gif.Globals;
import static team.gif.Flynn.collectorAngle;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class CollectorManualDown extends lib.gif.commands.Command {
	
    public CollectorManualDown() {
    	requires(collectorAngle);
    }

    protected void initialize() {}

    protected void execute() {
    	collectorAngle.drive(-Globals.m_collectorAngleSpeed);
    }

    protected boolean isFinished() {
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
