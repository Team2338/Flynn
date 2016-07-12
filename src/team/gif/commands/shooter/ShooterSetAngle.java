package team.gif.commands.shooter;

import static team.gif.Flynn.dart;

import team.gif.Globals;
import team.gif.subsystems.Dart.Level;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterSetAngle extends lib.gif.commands.Command {
	
	private double setpoint;
	private double error = 0;
	private final Level level;

    public ShooterSetAngle(Level level) {
    	requires(dart);
    	this.level = level;
    }

    protected void initialize() {
    	error = 0;
    	
    	switch (level) {
			case HIGH:
				setpoint = Globals.s_dartHigh;
				break;
			case OUTERWORKS:
				setpoint = Globals.s_dartCourtyard;
				break;
			case LOW:
				setpoint = Globals.s_dartLow;
				break;
			case MID:
				setpoint = Globals.s_dartMid;
				break;
			case DOWN:
				setpoint = Globals.s_dartDown;
				break;
			case AUTOSHOT:
				setpoint = Globals.s_dartAuto;
				break;
    	}
    	
    	dart.setStandbySetpoint(setpoint);
    }

    protected void execute() {
    	error = setpoint - dart.getPosition();
    	dart.drive(Globals.k_dartP * error);
    }

    protected boolean isFinished() {
    	return (Math.abs(error) < Globals.t_dartPosition) ||
    			dart.getPosition() > Globals.t_dartSafePoint;
    }

    protected void end() {
    	dart.drive(0);
    }

    protected void interrupted() {
    	dart.drive(0);
    }
    
}
