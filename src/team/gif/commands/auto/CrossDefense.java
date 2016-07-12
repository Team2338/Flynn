package team.gif.commands.auto;

import static team.gif.Flynn.chassis;

import lib.gif.commands.Command;

public class CrossDefense extends Command {
	
	private boolean hasReached;

    public CrossDefense() {
        requires(chassis);
    }

    protected void initialize() {
    	hasReached = false;
    }

    protected void execute() {
    	chassis.drive(0.7, 0.7);
    	if (Math.abs(chassis.getAccX()) > 2) hasReached = true;
    }

    protected boolean isFinished() {
        return hasReached && Math.abs(chassis.getAccX()) < 1;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
