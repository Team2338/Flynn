package team.gif;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.commands.*;
import team.gif.commands.auto.AntiAuto;
import team.gif.commands.auto.DriveStraightEnc;
import team.gif.commands.auto.LowBarToLowGoal;
import team.gif.commands.auto.Turn;
import team.gif.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Drivetrain chassis = new Drivetrain();
	public static final ShooterAngle shooterAngle = new ShooterAngle();
	public static final Shooter shooter = new Shooter();
	public static final CollectorReceptor collectorReceptor = new CollectorReceptor();
	public static final CollectorAngle collectorAngle = new CollectorAngle();
	public static final Climber climber = new Climber();
	public static final Arm arm = new Arm();
	public static final WheelyBar wheelyBar = new WheelyBar();
	public static OI oi;
	
	Command autonomousCommand;
	Command teleopCommand = new TankDrive();
    SendableChooser chooser;

    public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();
        chooser.addDefault("AntiAuto", new AntiAuto());
        chooser.addObject("Turn", new Turn());
        chooser.addObject("DriveStraight", new DriveStraightEnc());
        chooser.addObject("LowBarToLowGoal", new LowBarToLowGoal());
        SmartDashboard.putData("Auto mode", chooser);
       
        teleopCommand = new TankDrive();
        chassis.init();
        
        SmartDashboard.putNumber("TurnAngle", 0.0);
        SmartDashboard.putNumber("TurnKp", Globals.turnKp);
        SmartDashboard.putNumber("DriveStraightAngleKp", Globals.driveStraightAngleKp);
        SmartDashboard.putNumber("DriveStraightDistKp", Globals.driveStraightDistKp);
        SmartDashboard.putNumber("DriveStraightDist", 0.0);
    }

    public void disabledInit() {}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run(); 
		update();
	}

    public void autonomousInit() {
    	if ((autonomousCommand = (Command) chooser.getSelected()) != null) autonomousCommand.start();
    	wheelyBar.deploy();
    }

    public void autonomousPeriodic() {
        update();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleopCommand.start();
    }

    public void teleopPeriodic() {
        update();
    }
    
    
    public void update() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("ClimberMin: ", climber.getMin());
        SmartDashboard.putBoolean("ClimberMax: ", climber.getMax());
        SmartDashboard.putBoolean("CollectorAngleMin: ", collectorAngle.getMin());
        SmartDashboard.putBoolean("CollectorAngleMax: ", collectorAngle.getMax());
        SmartDashboard.putBoolean("ShooterAngleMin: ", shooterAngle.getMin());
        SmartDashboard.putBoolean("ShooteAngleMax: ", shooterAngle.getMax());
        SmartDashboard.putBoolean("ArmMin: ", arm.getMin());
        SmartDashboard.putBoolean("ArmMax: ", arm.getMax());
        SmartDashboard.putNumber("Flywheel Velocity", shooter.ShooterVel());
        SmartDashboard.putNumber("ChassisAngle", chassis.getAngle());
    	SmartDashboard.putNumber("LeftDist", chassis.getLeftDist());
    	SmartDashboard.putNumber("RightDist", chassis.getRightDist());
    }
}
