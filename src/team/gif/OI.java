package team.gif;

import edu.wpi.first.wpilibj.Joystick;
import lib.gif.buttons.Button;
import lib.gif.buttons.JoystickButton;
import lib.gif.commands.Scheduler;
import team.gif.commands.*;
import team.gif.commands.auto.CameraHighGoal;
import team.gif.commands.auto.CameraTurn;
import team.gif.commands.auto.CameraTurn;
import team.gif.commands.collector.IntakeCollect;
import team.gif.commands.collector.CollectorCoastUp;
import team.gif.commands.collector.CollectorManualDown;
import team.gif.commands.collector.IntakeEject;
import team.gif.commands.collector.CollectorManualUp;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.commands.macros.*;
import team.gif.commands.shooter.FireGenericShot;
import team.gif.commands.shooter.FireShooter;
import team.gif.commands.shooter.RevShooter;
import team.gif.commands.shooter.ShooterManualDown;
import team.gif.commands.shooter.ShooterManualUp;
import team.gif.commands.shooter.ShooterSetAngle;
import team.gif.subsystems.CollectorAngle;
import team.gif.subsystems.Dart;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(1);
	public static final Joystick aux = new Joystick(2);
	
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

	private static Button aux1;
	private static Button aux2;
	private static Button aux3;
	private static Button aux4;
	private static Button aux5;
	private static Button aux6;
	private static Button aux7;
	private static Button aux8;
	private static Button aux9;
	private static Button aux10;
	public static Button aux11 = new JoystickButton(aux, 11);
	private static Button aux12;
	private static Button aux13;
	
	public OI(boolean automatic) {
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
		aux1 = new JoystickButton(aux, 12);
		aux2 = new JoystickButton(aux, 2);
		aux3 = new JoystickButton(aux, 3);
		aux4 = new JoystickButton(aux, 4);
		aux5 = new JoystickButton(aux, 5);
		aux6 = new JoystickButton(aux, 6);
		aux7 = new JoystickButton(aux, 7);
		aux8 = new JoystickButton(aux, 8);
		aux9 = new JoystickButton(aux, 9);
		aux10 = new JoystickButton(aux, 10);
		aux12 = new JoystickButton(aux, 15); // FIXME: Check actual port #
		aux13 = new JoystickButton(aux, 14); // FIXME: Check actual port #
		
		
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().removeAllButtons();
		
		// Right stick actions
//		right2.whileHeld(new ArmExtend());
//		right3.whileHeld(new ArmRetract());
		
		// Auxiliary actions
		aux1.whileHeld(new CollectorManualUp());
		aux2.whileHeld(new CollectorManualDown());
		aux5.whileHeld(new IntakeEject());
		if (automatic) {
			aux3.whenPressed(new RevShooter(Globals.s_batterPinRPM));
			aux4.whenPressed(new FireShooter(0.25));
			aux6.whenPressed(new CollectToDrive());
			aux7.whenPressed(new AllHigh());
			aux8.whenPressed(new ShooterSetAngle(Dart.Level.OUTERWORKS));
			aux9.whenPressed(new AllMid());
			aux10.whenPressed(new AllLow());
//			aux12.whenPressed(new CameraTurn(18200)); // Low goal w/ camera
//			aux12.whenPressed(new FireGenericShot(Globals.s_lowBarRPM, 0.0)); // Low goal shot
			aux12.whenPressed(new FireGenericShot(Globals.s_autoRPM, 0.0));
//			aux13.whenReleased(new CollectorSetAngle(CollectorAngle.Level.CHEVAL));
			aux13.whenReleased(new CollectorCoastUp()); // TODO: Don't let this intersect w/ shooter
		} else {
			aux4.whenPressed(new CameraTurn());
			aux6.whileHeld(new IntakeCollect());
			aux7.whileHeld(new ShooterManualUp());
			aux9.whenPressed(new PrepLowGoal());
			aux10.whileHeld(new ShooterManualDown());
//			aux12.whenPressed(new RevShooter(Globals.s_courtyardRPM));
			aux12.whenPressed(new FireGenericShot(Globals.s_courtyardRPM, 0.0));
		}
			
	}
}
