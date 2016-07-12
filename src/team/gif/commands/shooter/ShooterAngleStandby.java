package team.gif.commands.shooter;

import static team.gif.Flynn.dart;

import team.gif.Globals;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterAngleStandby extends lib.gif.commands.Command {
	
    public ShooterAngleStandby() {
    	requires(dart);
    }

    protected void initialize() {}

    // Basic P-loop
    protected void execute() {
    	dart.drive(Globals.k_dartP * (dart.getStandbySetpoint() - dart.getPosition()));
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	dart.drive(0);
    }

    protected void interrupted() {
    	dart.drive(0);
    }
    
}
