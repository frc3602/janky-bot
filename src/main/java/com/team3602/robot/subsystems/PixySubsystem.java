/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.subsystems;

import com.team3602.robot.commands.PixyCommand;

// WPILib imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Pixy2JavaAPI imports
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.SPILink;

/**
 * Detects if a ball is blue or red
 *
 * Contains:
 * - 1 pixy cam
 * 
 * @author Cody Wellman
 */
public class PixySubsystem extends SubsystemBase {
  public static final Pixy2 pixyCamera = Pixy2.createInstance(new SPILink());

  public PixySubsystem() {
    pixyCamera.init();
  }

  public void logDataToSmartDashboard() {
    if (PixyCommand.largestBlock != null) {
      SmartDashboard.putNumber("Block Signature", PixyCommand.largestBlock.getSignature());
      SmartDashboard.putNumber("Block X", PixyCommand.largestBlock.getX());
      SmartDashboard.putNumber("Block Y", PixyCommand.largestBlock.getY());
    }
  }

  @Override
  public void periodic() {
  }
}
