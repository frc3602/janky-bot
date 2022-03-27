/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.subsystems;

import com.team3602.robot.RobotContainer;
import com.team3602.robot.commands.PixyCommand;

// WPILib imports
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class PixyTurnSubsystem extends PIDSubsystem {
  /** Creates a new PixyTurnSubsystem. */
  public PixyTurnSubsystem() {
    // The PIDController used by the subsystem
    super(new PIDController(0.0040, 0, 0));

    setSetpoint(315.0 / 2.0);

    getController().setTolerance(5.0);
    getController().setIntegratorRange(-0.10, 0.10);
    getController().enableContinuousInput(0, 315);

    disable();
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    RobotContainer.drivetrainSubsystem.ArcadeDrive(0.0, output * -1.0);

    SmartDashboard.putNumber("Output value", output);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here

    double returnValue = 315.0 / 2.0;

    if (PixyCommand.largestBlock != null) {
      returnValue = PixyCommand.largestBlock.getX();
    }
    return returnValue;
  }
}
