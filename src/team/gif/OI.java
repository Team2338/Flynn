package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import team.gif.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(1);
	public static final Joystick auxStick = new Joystick(2);
	
	public static Button leftTrigger;
	private static Button left2;
	private static Button left3;
	private static Button left4;
	private static Button left5;
	
	private static Button rightTrigger;
	private static Button right2;
	private static Button right3;
	private static Button right4;
	private static Button right5;

	private static Button auxTrigger;
	private static Button aux2;
	private static Button aux3;
	private static Button aux4;
	private static Button aux5;
	private static Button aux6;
	private static Button aux7;
	private static Button aux8;
	private static Button aux9;
	private static Button aux10;
	private static Button aux11;
	
	public OI() {
		// Left stick buttons
		leftTrigger = new JoystickButton(leftStick, 1);
		left2 = new JoystickButton(leftStick, 2);
		left3 = new JoystickButton(leftStick, 3);
		left4 = new JoystickButton(leftStick, 4);
		left5 = new JoystickButton(leftStick, 5);
		
		// Right stick buttons
		rightTrigger = new JoystickButton(rightStick, 1);
		right2 = new JoystickButton(rightStick, 2);
		right3 = new JoystickButton(rightStick, 3);
		right4 = new JoystickButton(rightStick, 4);
		right5 = new JoystickButton(rightStick, 5);
		
		// Auxiliary buttons
		auxTrigger = new JoystickButton(auxStick, 1);
		aux2 = new JoystickButton(auxStick, 2);
		aux3 = new JoystickButton(auxStick, 3);
		aux4 = new JoystickButton(auxStick, 4);
		aux5 = new JoystickButton(auxStick, 5);
		aux6 = new JoystickButton(auxStick, 6);
		aux7 = new JoystickButton(auxStick, 7);
		aux8 = new JoystickButton(auxStick, 8);
		aux9 = new JoystickButton(auxStick, 9);
		aux10 = new JoystickButton(auxStick, 10);
		aux11 = new JoystickButton(auxStick, 11);
		
		// Right stick actions
		right2.whileHeld(new ArmRetract());
		right3.whileHeld(new ArmExtend());
		
		// Auxiliary actions
		auxTrigger.whenPressed(new ShooterFire());
		aux2.whileHeld(new CollectorCollect());
		aux3.whileHeld(new CollectorEject());
		aux6.whileHeld(new ClimberAscend());
		aux7.whileHeld(new ClimberDescend());
		aux8.whileHeld(new ShooterDown());
		aux9.whileHeld(new ShooterUp());
		aux10.whileHeld(new CollectorDown());
		aux11.whileHeld(new CollectorUp());
	}
}

