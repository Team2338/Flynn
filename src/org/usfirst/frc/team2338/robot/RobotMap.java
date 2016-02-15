package org.usfirst.frc.team2338.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// CAN Addresses
	public static int frontLeft = 1;
	public static int frontRight = 2;
	public static int rearLeft = 3;
	public static int rearRight = 4;
	public static int collectorAngle = 5;
	public static int collectorReceptor = 6;
	public static int shooterFlywheel = 7;
	public static int shooterPolycord = 8;
	public static int shooterAngle = 9;
	public static int climber = 10;
	public static int arm = 11;
	
	
	// DIO Ports
	public static int collectorMinAngle = 1;
	public static int collectorMaxAngle = 2;
	public static int shooterMinAngle = 3;
	public static int shooterMaxAngle = 4;
	public static int climberMin = 5;
	public static int climberMax = 6;
	public static int armMin = 7;
	public static int armMax = 8;
}
