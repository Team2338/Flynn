package team.gif;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import lib.gif.commands.Scheduler;
import team.gif.commands.TankDrive;
import team.gif.commands.auto.*;
import team.gif.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Flynn extends IterativeRobot {

	public static final Drivetrain chassis = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final Dart dart = new Dart();
	public static final CollectorAngle collectorAngle = new CollectorAngle();
	public static final Arm arm = new Arm();
	public static OI oi;
	private boolean isAutomatic;
	
	public static NetworkTable grip;
	Command autonomousCommand;
    SendableChooser autoChooser;
    SendableChooser delayChooser;

    public void robotInit() {
    	isAutomatic = OI.aux11.get();
		oi = new OI(isAutomatic);
		
        autoChooser = new SendableChooser();
        autoChooser.addDefault("AntiAuto", new AntiAuto());
        autoChooser.addObject("Gross Cam Turn", new CameraTurn());
        autoChooser.addObject("Clean Cam Turn", new CleanCameraTurn());
        autoChooser.addObject("Cam Drive", new CameraDrive());
        autoChooser.addObject("CrossDefense", new MultiStageCross());
        autoChooser.addObject("HighGoalAuto", new CameraHighGoal());
//        autoChooser.addObject("Patcullis", new Patcullis());
//        autoChooser.addObject("LowBar", new BackwardsLowBar());
//        autoChooser.addObject("Cheval(DON'T)", new Cheval());
        SmartDashboard.putData("Auto mode chooser", autoChooser);
        
        delayChooser = new SendableChooser();
        delayChooser.addDefault("No delay", new Double(0));
        delayChooser.addObject("5 sec", new Double(5));
        SmartDashboard.putData("Delay chooser", delayChooser);
        
        grip = NetworkTable.getTable("GRIP");
        
        File gripLogFile = new File("/home/lvuser/GRIP.log");
        File gripLockFile = new File("/home/lvuser/GRIP.log.lck");
        
        if (gripLogFile.exists()) {
        	gripLogFile.delete();
        } else {
        	System.out.println("LOG FILE DOES NOT EXIST");
        }
        
        if (gripLockFile.exists()) {
        	gripLockFile.delete();
        } else {
        	System.out.println("LOCK FILE DOES NOT EXIST");
        }
        
        gripLogFile = null;
        gripLockFile = null;
        
        Timer.delay(10);
        
        // Runs GRIP in a new process        
        try {
        	new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        Timer.delay(5);
        
        System.out.println("Hopefully GRIP has started");
        
    }

    public void disabledInit() {}
	
	public void disabledPeriodic() {
		update();
	}

    public void autonomousInit() {
    	if (delayChooser.getSelected() != null) {
    		Timer.delay((Double) delayChooser.getSelected());
    	}
    	if ((autoChooser.getSelected()) != null) {
    		autonomousCommand = (Command) autoChooser.getSelected();
    		autonomousCommand.start();
    	}
    }

    public void autonomousPeriodic() {
        update();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        new TankDrive().start();
    }

    public void teleopPeriodic() {
        update();
    }
    
    public void update() {
        Scheduler.getInstance().run();
    	chassis.displayMetrics();
    	collectorAngle.displayMetrics();
    	dart.displayMetrics();
    	intake.displayMetrics();
    	
    	if (OI.aux11.get() != isAutomatic) {
    		isAutomatic = !isAutomatic;
    		oi = new OI(isAutomatic);
    	}
    }
    
    /**
     * Returns a specified data value of the target. Valid types
     * include centerX, centerY, area, and solidity. If GRIP hasn't yet
     * initialized, or there is no visible target, this method will
     * return -1.
     * 
     * @param type The trait of the target to return
     * @return The value of the specified trait
     */
    public static double getTargetValue(String type) throws ArrayIndexOutOfBoundsException {
    	
    	if (grip.getNumberArray("myContoursReport/" + type, new Double[] {0.0}) != null) {
    		System.out.println("Array length:  " +
    				grip.getNumberArray("myContoursReport/" + type, new Double[] {0.0}).length);
    		
    		if (grip.getNumberArray("myContoursReport/" + type, new Double[] {0.0}).length > 0) {
    			int index = 0;
    			
    			for (int i = 0;
   					 i < grip.getNumberArray("myContoursReport/" + type, new Double[] {0.0}).length;
   					 i++) {
   					
   					if (grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[index] <
   							grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[i]) {
   						index = i;
   					}
   				}
    			
    			System.out.println("Selecting index " + index);
    			return grip.getNumberArray("myContoursReport/" + type, new Double[] {0.0})[index];
    		}
    		
    		System.out.println("!!No target found!!");
    	}
    	
    	System.out.println("!!Contours report does not exist!!");
    	return -1;
    }
    
}
