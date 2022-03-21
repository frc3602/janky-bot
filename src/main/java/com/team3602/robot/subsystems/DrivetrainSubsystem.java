/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.subsystems;

import static com.team3602.robot.Constants.Drivetrain;

// Phoenix imports
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// WPILib imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * Moves the robot around
 *
 * Contains:
 * - 2 motors on left side
 * - 2 motors on right side
 * 
 * @author Cody Wellman
 */
public class DrivetrainSubsystem extends SubsystemBase {
  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(Drivetrain.driveFrontLeftCANID);
  private WPI_TalonSRX backLeft = new WPI_TalonSRX(Drivetrain.driveBackLeftCANID);
  private WPI_TalonSRX frontRight = new WPI_TalonSRX(Drivetrain.driveFrontRightCANID);
  private WPI_TalonSRX backRight = new WPI_TalonSRX(Drivetrain.driveBackRightCANID);

  private MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
  private MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

  private DifferentialDrive differentialDrive = new DifferentialDrive(left, right);

  public DrivetrainSubsystem() {
    configureMotors();
  }

  public void ArcadeDrive(double xSpeed, double xRotation) {
    differentialDrive.arcadeDrive(xSpeed, xRotation);
  }

  /**
   * Method to set the drivetrain motors to factory defaults and to invert the
   * right side.
   */
  private void configureMotors() {
    frontLeft.configFactoryDefault();
    backLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    backRight.configFactoryDefault();

    frontLeft.setInverted(false);
    backLeft.setInverted(false);
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }
}
