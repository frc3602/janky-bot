/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot;

import static com.team3602.robot.Constants.Controller;

// WPILib imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The OI class provides joysticks and buttons for the robot.
 *
 * @author Cody Wellman
 */
public class OI {

  public static Joystick joystick = new Joystick(Controller.joystickPort);

  public static JoystickButton joystickButtonOne = new JoystickButton(joystick, Controller.joystickButton1);
  public static JoystickButton joystickButton11 = new JoystickButton(joystick, 11);
  public static JoystickButton joystickButton12 = new JoystickButton(joystick, 12);

  public OI() {
  }
}
