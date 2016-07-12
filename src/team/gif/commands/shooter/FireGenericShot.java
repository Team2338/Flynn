package team.gif.commands.shooter;

import static team.gif.Flynn.chassis;
import static team.gif.Flynn.intake;

import java.io.File;
import java.text.DecimalFormat;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.Logger;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import team.gif.Globals;
import team.gif.commands.auto.WaitCommand;
import team.gif.commands.collector.IntakeCollect;

/**
 * 
 * @author PatrickUbelhor, DerekHo
 */

public class FireGenericShot extends lib.gif.commands.CommandGroup {
    
    public FireGenericShot(double setpoint, double driveSpeed) {
    	addSequential(new IntakeCollect(0.05));
        addSequential(new WaitCommand(0.1));
        addSequential(new ShooterFire(setpoint, driveSpeed));
    }
    
    private class ShooterFire extends lib.gif.commands.Command {
    	
    	private double initTime;
    	private double lastTime;
    	private double lastVel;
    	private double acceleration;
    	private boolean hasFired;
    	private boolean hasCollected;
    	private final double setpoint;
    	private final double driveSpeed;
    	
//    	private final File logFile = new File("/GearItForward/ShooterPIDF");
//    	private final DecimalFormat df = new DecimalFormat("#.###");
    	
        public ShooterFire(double setpoint, double driveSpeed) {
        	super();
        	requires(intake);
        	requires(chassis);
        	this.setpoint = setpoint;
        	this.driveSpeed = driveSpeed;
        }
        
        protected void initialize() {
        	intake.setMode(TalonControlMode.Speed);
        	intake.resetIAccum();
        	intake.driveReceptor(0);
        	intake.driveFlywheel(setpoint);
        	chassis.drive(driveSpeed, driveSpeed);
        	Timer.delay(0.022);
        	
        	initTime = Timer.getFPGATimestamp();
        	lastTime = Timer.getFPGATimestamp();
        	lastVel = intake.getVelocity();
        	hasFired = false;
        	hasCollected = false;
        }

        protected void execute() {
        	
        	if (!hasCollected) {
        		intake.driveChamber(Globals.m_shooterPolycordSpeed);
        		Timer.delay(0.15);
        		intake.driveChamber(0);
        		hasCollected = true;
        	}
        	
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
