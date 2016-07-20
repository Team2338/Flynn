package team.gif.commands.shooter;

import static team.gif.Flynn.chassis;
import static team.gif.Flynn.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import team.gif.Globals;
import team.gif.commands.auto.WaitCommand;

/**
 * @author PatrickUbelhor, DerekHo
 */
public class FireShooter extends lib.gif.commands.CommandGroup {

//    public FireShooter(double driveSpeed) {
////    	addSequential(new RevShooter(Globals.s_batterPinRPM));
////    	addSequential(new WaitCommand(0.1));
//        addSequential(new ShooterFire(driveSpeed));
//    }
    
    public FireShooter(double driveSpeed, double shooterVel) {
    	addSequential(new WaitCommand(0.1));
    	addSequential(new ShooterFire(driveSpeed, shooterVel));
    }
    
    private class ShooterFire extends lib.gif.commands.Command {
    	
    	private double initTime;
    	private double lastTime;
    	private double lastVel;
    	private double acceleration;
    	private boolean hasFired;
    	private final double driveSpeed;
    	private final double shooterVel;
    	
//    	private final File logFile = new File("/GearItForward/ShooterPIDF");
//    	private final DecimalFormat df = new DecimalFormat("#.###");
    	
        public ShooterFire(double driveSpeed) {
        	this(driveSpeed, Globals.s_batterPinRPM);
        }
        
        public ShooterFire(double driveSpeed, double shooterVel) {
        	super();
        	requires(intake);
        	requires(chassis);
        	this.driveSpeed = driveSpeed;
        	this.shooterVel = shooterVel;
        }

        protected void initialize() {
        	
        	if (intake.getSetpoint() != shooterVel) {
        		intake.setMode(TalonControlMode.PercentVbus);
            	intake.driveReceptor(0);
            	intake.driveFlywheel(Globals.m_shooterFlywheelSpeed);
            	intake.driveChamber(Globals.m_shooterPolycordSpeed);
            	Timer.delay(0.05);
            	
            	intake.driveFlywheel(0);
            	Timer.delay(0.1);
            	
            	intake.driveChamber(0);
            	intake.setMode(TalonControlMode.Speed);
            	intake.resetIAccum();
            	intake.driveFlywheel(shooterVel);
        	}
        	
	    	chassis.drive(driveSpeed, driveSpeed);
	    	Timer.delay(0.022);
	    	
	    	initTime = Timer.getFPGATimestamp();
	    	lastTime = Timer.getFPGATimestamp();
	    	lastVel = intake.getVelocity();
	    	hasFired = false;
        }
        
        protected void execute() {
        	
           	acceleration = ((intake.getVelocity() - lastVel) / (Timer.getFPGATimestamp() - lastTime));
        	
        	if (Math.abs(intake.getError()) < Globals.t_flywheelVelocity &&
        			Math.abs(acceleration) < Globals.t_flywheelAcceleration) {
        		intake.driveChamber(-Globals.m_shooterPolycordSpeed);
        		hasFired = true;
        	}
        	
        	if (!hasFired) {
        		initTime = Timer.getFPGATimestamp();
        	}
        	
        	lastTime = Timer.getFPGATimestamp();
        	lastVel = intake.getVelocity();
        	
//        	Logger.println("P Gain " + df.format(intake.getPGain()), logFile);
//        	Logger.println("I Gain " + df.format(intake.getIGain()), logFile);
//        	Logger.println("D Gain " + df.format(intake.getDGain()), logFile);
//        	Logger.println("F Gain " + df.format(intake.getFGain()), logFile);
        }

        protected boolean isFinished() {
        	return hasFired &&
        		   intake.getError() < Globals.t_flywheelVelocity &&
        		  !intake.getLimit() &&
        		  Timer.getFPGATimestamp() - initTime > 0.2;
        }

        protected void end() {
        	intake.setMode(TalonControlMode.PercentVbus);
        	intake.driveFlywheel(0);
        	intake.driveChamber(0);
//        	Logger.println("END OF SHOT", logFile);
        }

        protected void interrupted() {
        	end();
        }
    }
}
