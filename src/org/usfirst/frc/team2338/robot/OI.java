package org.usfirst.frc.team2338.robot;

import org.usfirst.frc.team2338.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(1);
	public static final Joystick auxStick = new Joystick(2);
	
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
		aux2 = new JoystickButton(auxStick, 2);
		aux3 = new JoystickButton(auxStick, 3);
		aux6 = new JoystickButton(auxStick, 6);
		aux7 = new JoystickButton(auxStick, 7);
		aux10 = new JoystickButton(auxStick, 10);
		aux11 = new JoystickButton(auxStick, 11);
		
		aux2.whenPressed(new CollectorCollect());
		aux2.whenReleased(new CollectorReceptorStandby());
		aux3.whenPressed(new CollectorEject());
		aux3.whenReleased(new CollectorReceptorStandby());
		aux6.whenPressed(new ClimberAscend());
		aux6.whenReleased(new ClimberStandby());
		aux7.whenPressed(new ClimberDescend());
		aux8.whenReleased(new ClimberStandby());
		aux10.whenPressed(new CollectorAngleBackward());
		aux10.whenReleased(new CollectorAngleStandby());
		aux11.whenPressed(new CollectorAngleForward());
		aux11.whenReleased(new CollectorAngleStandby());
	}
}

