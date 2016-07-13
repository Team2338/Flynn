
package team.gif.subsystems;

import static team.gif.RobotMap.*;
import static team.gif.Globals.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import team.gif.commands.TankDrive;

/**
 * @author DerekHo, ArmaanShah, and PatrickUbelhor
 */
public class Drivetrain extends lib.gif.commands.Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(mp_frontLeftDrive);
	private static final CANTalon frontRight = new CANTalon(mp_frontRightDrive);
	private static final CANTalon rearLeft = new CANTalon(mp_rearLeftDrive);
	private static final CANTalon rearRight = new CANTalon(mp_rearRightDrive);
	private static final ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private static final BuiltInAccelerometer acc = new BuiltInAccelerometer();
	private static final Encoder leftEncoder = new Encoder(sp_leftDriveEncoderA, sp_leftDriveEncoderB);
	private static final Encoder rightEncoder = new Encoder(sp_rightDriveEncoderA, sp_rightDriveEncoderB);
	private static final ADXRS450_Gyro drift = gyro;
	
	private static double averageX = 0;
	private static double averageY = 0;
	private static double averageZ = 0;
//	private static double driftVal = 0;
//	private static boolean isStopped = false;
	
	/**
	 * Resets encoders and calibrates the gyro and the built-in
	 * accelerometer to the current heading.
	 * The robot MUST remain stationary during this process, or future sensor
	 * readings will be flawed.
	 */
	public Drivetrain() {
		super();
		leftEncoder.reset();
		rightEncoder.reset();
		gyro.calibrate();
		averageX = 0;
		averageY = 0;
		averageZ = 0;
		
		for (int i = 0; i < accelSamplePrecision; i++) {
			averageX += acc.getX();
			averageY += acc.getY();
			averageZ += acc.getZ();
		}
		
		averageX = averageX / accelSamplePrecision;
		averageY = averageY / accelSamplePrecision;
		averageZ = averageZ / accelSamplePrecision;
		
		frontLeft.enableBrakeMode(true);
		frontRight.enableBrakeMode(true);
		rearLeft.enableBrakeMode(true);
		rearRight.enableBrakeMode(true);
		
		rearLeft.changeControlMode(TalonControlMode.Follower);
		rearLeft.set(mp_frontLeftDrive);
		rearRight.changeControlMode(TalonControlMode.Follower);
		rearRight.set(mp_frontRightDrive);
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
		frontRight.set(rightSpeed);
	}
	
	public void displayMetrics() {
		SmartDashboard.putNumber("ChassisAngle: ", getAngle());
		SmartDashboard.putNumber("LeftDist: ", getLeftDist());
		SmartDashboard.putNumber("RightDist: ", getRightDist());
//		SmartDashboard.putBoolean("IsStopped: ", getIsStopped());
	}
	
//	public void calibrateDrift(){
//		if (!rightEncoder.getStopped()) { // &&!leftEncoder.getStopped()
//			drift.reset();
//			driftVal = 0;
//			isStopped = false;
//		}
//		
//		if (rightEncoder.getStopped()) { // &&leftEncoder.getStopped()
//			driftVal += drift.getAngle();
//			isStopped = true;
//		}
//	}
	
	/**
	 * @return Angle of the robot, measured by the gyro
	 */
	public double getAngle() {
//		calibrateDrift();
//		if (rightEncoder.getStopped()) { // &&leftEncoder.getStopped()
//			isStopped = true;
//		}
//		
//		while (isStopped) {
//			driftVal += drift.getAngle();
//		}
		
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
		return -rightEncoder.getDistance();
	}
	
	/**
	 * 
	 * @return Boolean of whether both encoders are not accumulating
	 */
//	public boolean getIsStopped() {
//		return isStopped;
//	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
}
