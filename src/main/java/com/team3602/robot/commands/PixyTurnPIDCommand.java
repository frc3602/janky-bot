/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.commands;

import com.team3602.robot.OI;
import com.team3602.robot.RobotContainer;

// WPILib imports
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class PixyTurnPIDCommand extends PIDCommand {
  public PixyTurnPIDCommand() {
    super(
        // The controller that the command will use
        new PIDController(0.0040, 0, 0),
        // This should return the measurement
        () -> RobotContainer.pixySubsystem.getLargestBlockX(),
        // This should return the setpoint (can also be a constant)
        () -> 315.0 / 2.0,
        // This uses the output
        output -> {
          // Use the output here
          RobotContainer.drivetrainSubsystem.ArcadeDrive(OI.joystick.getY() * -1.0, output * -1.0);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrainSubsystem);
    // Configure additional PID options by calling `getController` here.
    getController().setSetpoint(315.0 / 2.0);
    getController().setTolerance(5.0);
    getController().setIntegratorRange(-0.10, 0.10);
    getController().enableContinuousInput(0, 315);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
