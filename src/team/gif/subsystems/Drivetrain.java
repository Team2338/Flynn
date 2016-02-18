
package team.gif.subsystems;

import static team.gif.Globals.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(frontLeftDrivePort);
	private static final CANTalon frontRight = new CANTalon(frontRightDrivePort);
	private static final CANTalon rearLeft = new CANTalon(rearLeftDrivePort);
	private static final CANTalon rearRight = new CANTalon(rearRightDrivePort);
	private static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private static final BuiltInAccelerometer acc = new BuiltInAccelerometer();
	private static final Encoder leftEncoder = new Encoder(leftEncoderPortA, leftEncoderPortB);
	private static final Encoder rightEncoder = new Encoder(rightEncoderPortA, rightEncoderPortB);
	
	private static double averageX = 0;
	private static double averageY = 0;
	private static double averageZ = 0;
	
	public Drivetrain() {
		super();
	}
	
	/**
	 * Resets encoders and calibrates the gyro and the built-in
	 * accelerometer to the current heading.
	 * The robot MUST remain stationary during this process, or future sensor
	 * readings will be flawed.
	 */
	public void init() {
		leftEncoder.setReverseDirection(Globals.leftDriveEncoderInverted);
		rightEncoder.setReverseDirection(Globals.rightDriveEncoderInverted);
		leftEncoder.reset();
		rightEncoder.reset();
		gyro.calibrate();
		averageX = 0;
		averageY = 0;
		averageZ = 0;
		
		for (int i = 0; i < gyroSamplePrecision; i++) {
			averageX += acc.getX();
			averageY += acc.getY();
			averageZ += acc.getZ();
		}
		
		averageX = averageX / gyroSamplePrecision;
		averageY = averageY / gyroSamplePrecision;
		averageZ = averageZ / gyroSamplePrecision;
		
	}
	
	/**
	 * Sets the encoders' counts to zero
	 */
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	/**
	 * Sets the speed of the drivetrain motors
	 * @param leftSpeed Speed of the left drive motors
	 * @param rightSpeed Speed of the right drive motors
	 */
	public void drive(double leftSpeed, double rightSpeed) {
		frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		frontRight.set(-rightSpeed);
		rearRight.set(-rightSpeed);
	}
	
	/**
	 * @return Angle of the robot, measured by the gyro
	 */
	public double getAngle() {
		return gyro.getAngle();
	}
	
	/**
	 * @return Rate of the gyro
	 */
	public double getRate() {
		return gyro.getRate();
	}
	
	/**
	 * @return X-axis acceleration of the built-in accelerometer
	 */
	public double getAccX() {
		return acc.getX() - averageX;
	}
	
	/**
	 * @return Y-axis acceleration of the built-in accelerometer
	 */
	public double getAccY() {
		return acc.getY() - averageY;
	}
	
	/**
	 * @return Z-axis acceleration of the built-in accelerometer
	 */
	public double getAccZ() {
		return acc.getZ() - averageZ;
	}
	
	/**
	 * @return Total ticks of left drive encoder
	 */
	public double getLeftDist() {
		return leftEncoder.getDistance();
	}
	
	/**
	 * @return Total ticks of right drive encoder
	 */
	public double getRightDist() {
		return rightEncoder.getDistance();
	}
    
    public void initDefaultCommand() {}
    
}
