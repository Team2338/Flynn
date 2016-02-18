package team.gif;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Globals {
	
	// SPEEEEEEEEEEEDS
	public static final double shooterFlywheelSpeed	= 1.0;
	public static final double shooterPolycordSpeed	= 1.0;
	public static final double shooterAngleSpeed	= 0.5;
	public static final double collectorReceptorSpeed = 1.0;
	public static final double collectorAngleSpeed	= 0.5;
	public static final double climberSpeed	= 1.0;
	public static final double armSpeed	= 1.0;
	
	
	// TIMEEEEEEEEEEES
	public static final double shooterFlywheelTime	= 2.0;

	// CAN Addresses
	public static final int frontLeftDrivePort		= 1;
	public static final int frontRightDrivePort		= 2;
	public static final int rearLeftDrivePort		= 3;
	public static final int rearRightDrivePort		= 4;
	public static final int collectorAngleLeftPort	= 5;
	public static final int collectorAngleRightPort	= 6;
	public static final int collectorReceptorPort	= 7;
	public static final int shooterFlywheelPort		= 8;
	public static final int shooterPolycordPort		= 9;
	public static final int shooterAnglePort		= 10;
	public static final int climberPort				= 11;
	public static final int armPort					= 12;

	// DIO Ports
	public static final int rightEncoderPortA		= 0;
	public static final int rightEncoderPortB		= 1;
	public static final int leftEncoderPortA		= 2;
	public static final int leftEncoderPortB		= 3;
	public static final int collectorMinAnglePort	= 4;
	public static final int collectorMaxAnglePort	= 5;
	public static final int shooterMinAnglePort		= 6;
	public static final int shooterMaxAnglePort		= 7;
	public static final int climberMinPort			= 8;
	public static final int climberMaxPort			= 9;
	public static final int armMinPort				= 10;
	public static final int armMaxPort				= 11;
	
	// Relay Ports
	public static final int wheelyBarPort			= 0;
	
	// Drivetrain Constants
	public static final int gyroSamplePrecision	= 50; // Number of samples to average when calibrating
	public static final double turnKp = 0.025;
	public static final double turnAngularPosTolerance = 2;		// Degrees; FIXME: Evaluate
	public static final double turnAngularVelTolerance = 100;	// Degrees per second; FIXME: Evaluate
	public static final double driveStraightDistKp = 0.0;		// FIXME: Evaluate
	public static final double driveStraightAngleKp	= 0.0;		// FIXME: Evaluate
	public static final double driveStraightDistTolerance = 0.1;// meters FIXME: Evaluate
	public static final double driveStraightVelTolerance = 0.25;// meter per second; FIXME: Evaluate
	public static final boolean leftDriveEncoderInverted = false;
	public static final boolean rightDriveEncoderInverted = false;
	
	//PID STUUUUUUUUUUF
	public static final double shooterFlywheelP = 0d; 
	public static final double shooterFlywheelI = 0d; 
	public static final double shooterFlywheelD = 0d; 
	public static final double shooterPolycordP = 0d; 
	public static final double shooterPolycordI = 0d; 
	public static final double shooterPolycordD = 0d; 

	
}

