package org.usfirst.frc.team2338.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2338.robot.commands.*;
import org.usfirst.frc.team2338.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooterFlywheel = new Shooter();
	public static final ShooterAngle shooterAngle = new ShooterAngle();
	public static final CollectorReceptor collectorReceptor = new CollectorReceptor();
	public static final CollectorAngle collectorAngle = new CollectorAngle();
	public static final Climber climber = new Climber();
	public static final Arm arm = new Arm();
	public static OI oi;
	
	Command autonomousCommand;
    SendableChooser chooser;
    
    private Command teleOpCommand;

    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        SmartDashboard.putData("Auto mode", chooser);
        
        teleOpCommand = new TankDrive();
    }

    public void disabledInit() { }
	
	public void disabledPeriodic() {
		update();
	}

    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        update();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleOpCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        update();
    }
    
    public void testinit() { 	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void update() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("ClimberMin: ", climber.getMin());
        SmartDashboard.putBoolean("ClimberMax: ", climber.getMax());
        SmartDashboard.putBoolean("CollectorAngleMin: ", collectorAngle.getMin());
        SmartDashboard.putBoolean("CollectorAngleMax: ", collectorAngle.getMax());
        SmartDashboard.putBoolean("ShooterAngleMin: ", shooterAngle.getMin());
        SmartDashboard.putBoolean("ShooteAngleMax: ", shooterAngle.getMax());
        SmartDashboard.putBoolean("ArmLimit: ", arm.getLimit());
    }
}
