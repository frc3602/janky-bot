/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
  private static final Pixy2 pixyCamera = Pixy2.createInstance(new SPILink());

  public PixySubsystem() {
    pixyCamera.init();
    pixyCamera.setLamp((byte) 1, (byte) 1);
    pixyCamera.setLED(255, 255, 255);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}