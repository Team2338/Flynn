package team.gif.commands.collector;

import static team.gif.Flynn.collectorAngle;

import team.gif.Globals;
import team.gif.subsystems.CollectorAngle.Level;

/**
 * @author PatrickUbelhor, DerekHo, ArmaanShah
 */
public class CollectorSetAngle extends lib.gif.commands.Command {
	
	private final Level level;
	private double setpoint;
	private double error = 0;
    
    public CollectorSetAngle(Level level) {
    	requires(collectorAngle);
    	this.level = level;
    }

    protected void initialize() {
    	
    	switch (level) {
    		case UP:
    			setpoint = Globals.s_collectorUp;
    			break;
    		case MID:
    			setpoint = Globals.s_collectorMid;
    			break;
    		case DOWN:
    			setpoint = Globals.s_collectorDown;
    			break;
//    		case PORTCULLIS:
//    			setpoint = Globals.s_collectorPortcullis;
//    			break;
//    		case CHEVAL:
//    			setpoint = Globals.s_collectorCheval;
//    			break;
    	}
    	
    	collectorAngle.setStandbySetpoint(setpoint);
    }

    protected void execute() {
    	error = setpoint - collectorAngle.getPosition();
   		collectorAngle.drive(Globals.k_collectorP * error);
    }

    protected boolean isFinished() {
        return (Math.abs(error) < Globals.t_collectorPosition) ||
        		collectorAngle.getPosition() < Globals.t_collectorSafePoint;
    }

    protected void end() {
    	collectorAngle.drive(0);
    }

    protected void interrupted() {
    	collectorAngle.drive(0);
    }
    
}
