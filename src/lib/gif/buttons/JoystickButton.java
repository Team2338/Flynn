
package lib.gif.buttons;

import edu.wpi.first.wpilibj.GenericHID;

/**
 *
 * @author bradmiller
 */
public class JoystickButton extends Button {

  GenericHID m_joystick;
  int m_buttonNumber;

  /**
   * Create a joystick button for triggering commands
   *$
   * @param joystick The GenericHID object that has the button (e.g. Joystick,
   *        KinectStick, etc)
   * @param buttonNumber The button number (see
   *        {@link GenericHID#getRawButton(int) }
   */
  public JoystickButton(GenericHID joystick, int buttonNumber) {
    m_joystick = joystick;
    m_buttonNumber = buttonNumber;
  }

  /**
   * Gets the value of the joystick button
   *$
   * @return The value of the joystick button
   */
  public boolean get() {
    return m_joystick.getRawButton(m_buttonNumber);
  }
}
