package team.gif.commands;

import team.gif.OI;
import team.gif.Flynn;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class TankDrive extends lib.gif.commands.Command {
	
    public TankDrive() {
        requires(Flynn.chassis);
    }

    protected void initialize() {}

    protected void execute() {
    	Flynn.chassis.drive(-OI.leftStick.getY(), -OI.rightStick.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Flynn.chassis.drive(0, 0);
    }

    protected void interrupted() {
    	Flynn.chassis.drive(0, 0);
    }
    
}
