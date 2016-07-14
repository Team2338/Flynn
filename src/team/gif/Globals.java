package team.gif;

/**
 * This file is meant for easily changing values in code.
 * It should be simple enough that mechanical can do it.
 */
public class Globals {
	
	/**
	 * k_ : PID constant
	 * m_ : Manual constant
	 * s_ : PID setpoint
	 * t_ : PID tolerance
	 */
	
	// Drivetrain
	public static final int accelSamplePrecision		= 50; // Number of samples to average when calibrating
	public static final double k_turnP					= 0.04;
	public static final double k_turnI					= 0.09;
	public static final double k_turnD					= 0.00;
	public static final double k_turnIZone				= 3.0;
	public static final double k_driveStraightDistP		= 0.0003;
	public static final double k_driveStraightAngleP	= 0.04;
	public static final double t_turnAngularPos			= 0.5; // Degrees
	public static final double t_turnAngularVel			= 2.0;	// Degrees per second
	public static final double t_driveStraightDist		= 250;	// Ticks
	
	// Dart
	public static final double k_dartP					= 14.0; // c: 10.0
	public static double s_dartHigh						= 0.758; // p: .755  pp: .750 c: 0.760
	public static double s_dartCourtyard				= 0.545; // p: .530 c: 0.540
	public static double s_dartLow						= 0.240; // p: .240 c: 0.240
	public static double s_dartMid						= 0.200; // p: .190 c: 0.200
	public static double s_dartDown						= 0.081; // p: 0.067 p: .035 c: 0.050
	public static double s_dartAuto						= 0.550;
	public static final double m_dartSpeed				= 0.75; // Percentage
	public static final double t_dartPosition			= 0.012;
	public static final double t_dartSafePoint			= 0.450; // FIXME: Optimize
	public static final double t_dartSoftMax			= 0.800;
	public static final double t_dartSoftMin			= 0.020;
	
	// Collector (angle)
	public static final double k_collectorP				= 0.12;
	public static final double s_collectorUp			= -4;
//	public static final double s_collectorCheval		= -26;
	public static final double s_collectorMid			= -42; // p: -32 c: -42
	public static final double s_collectorDown			= -87; // p: -84 pp: -82 c: -80
//	public static final double s_collectorPortcullis	= -90;
	public static final double m_collectorAngleSpeed	= 0.8;
	public static final double t_collectorPosition		= 4;
	public static final double t_collectorSafePoint		= -35; // FIXME: Optimize
	
	// Intake
	public static final double k_flywheelP				= 0.180; // 0.180
	public static final double k_flywheelI				= 0.0004; // 0.0004
	public static final double k_flywheelD				= 0.001; // 0.001
	public static final double k_flywheelF				= 0.042; // 0.042
	public static final double k_flywheelCourtyardP		= 0.185;
	public static final int k_flywheelIZone				= 600; // 550
	public static final double m_shooterPolycordSpeed	= 1.0; // Percentage
	public static final double m_shooterFlywheelSpeed	= 0.500; // Percentage
	public static final double m_collectorPolycordSpeed	= 1.0;
	public static final double s_batterPinRPM			= 13000;
	public static final double s_courtyardRPM			= 17400; // 16700
	public static final double s_autoRPM				= 17400;
	public static final double s_lowBarRPM				= 18200;
	public static final double t_flywheelVelocity		= 50;
	public static final double t_flywheelAcceleration	= 2;
	
	// Arm
	public static final double m_armSpeed	= 1.0;
	
	// Camera
	public static final double s_cameraCenterX = 155;
	public static final double s_cameraCenterY = 20;
	public static final double k_cameraTurnP = 0.08;
	public static final double k_cameraTurnI = 0.09; // 0.04
	public static final double k_cameraTurnD = 0.0;
	public static final double k_cameraTurnIZone = 3.0;
	public static final double k_distanceConversionFactor = -65.0;
	public static final double k_angleConversionFactor = -0.16;
	public static final double t_cameraTurnMaxSpeed = 0.5;
	public static final double t_cameraTurnPixels = 8.5;
	
}
