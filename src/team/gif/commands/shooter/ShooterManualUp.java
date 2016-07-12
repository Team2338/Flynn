package team.gif.commands.shooter;

import static team.gif.Flynn.dart;

import team.gif.Globals;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class ShooterManualUp extends lib.gif.commands.Command {
	
    public ShooterManualUp() {
    	requires(dart);
    }

    protected void initialize() {}

    protected void execute() {
    	dart.drive(Globals.m_dartSpeed);
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	dart.drive(0);
    	dart.setStandbySetpoint(dart.getPosition());
    }

    protected void interrupted() {
    	end();
    }
    
}
