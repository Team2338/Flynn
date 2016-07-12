package team.gif.commands.collector;

import team.gif.Globals;

import static team.gif.Flynn.collectorAngle;

/**
 * @author PatrickUbelhor, DerekHo, ArmaanShah
 */
public class CollectorAngleStandby extends lib.gif.commands.Command {
	
    public CollectorAngleStandby() {
        requires(collectorAngle);
    }

    protected void initialize() {}

    // Basic P-loop
    protected void execute() {
   		collectorAngle.drive(Globals.k_collectorP * 
   				(collectorAngle.getStandbySetpoint() - collectorAngle.getPosition()));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	collectorAngle.drive(0);
    }

    protected void interrupted() {
    	collectorAngle.drive(0);
    }
    
}
