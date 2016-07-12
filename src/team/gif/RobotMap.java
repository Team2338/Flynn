 package team.gif;

public abstract class RobotMap {
	
	/*
	 * mp_ : Motor Port
	 * sp_ : Sensor Port
	 * rp_ : Relay Port
	 */

	// CAN Addresses
	public static final int mp_collectorPolycord	= 1;
	public static final int mp_shooterFlywheel2		= 2;
	public static final int mp_shooterPolycord		= 3;
	public static final int mp_shooterFlywheel		= 7;
	public static final int mp_dart					= 8;
	public static final int mp_sallyArm				= 12;

	public static final int mp_collectorAngleLeft	= 4;
	public static final int mp_frontRightDrive		= 5;
	public static final int mp_rearRightDrive		= 6;

	public static final int mp_frontLeftDrive		= 9;
	public static final int mp_rearLeftDrive		= 10;
	public static final int mp_collectorAngleRight	= 11;

	// DIO Ports
	public static final int sp_rightDriveEncoderA	= 0;
	public static final int sp_rightDriveEncoderB	= 1;
	public static final int sp_leftDriveEncoderA	= 2;
	public static final int sp_leftDriveEncoderB	= 3;
	public static final int sp_collectorEncoderA	= 4;
	public static final int sp_collectorEncoderB	= 5;
	public static final int sp_intakeLimit			= 6;
	public static final int sp_collectorMax			= 7;
	public static final int sp_sallyArmMin			= 8;
	public static final int sp_sallyArmMax			= 9;

	// Analog Ports
	public static final int sp_dartPotentiometer	= 0;

	// Relay Ports
	public static final int rp_climberDeployer		= 0;

}
