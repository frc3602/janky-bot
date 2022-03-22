/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.subsystems;

// Java imports
import java.util.ArrayList;

// WPILib imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Pixy2JavaAPI imports
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
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

  private static final int blockSignature = 1;

  private static Block blockColor = null;

  public PixySubsystem() {
    pixyCamera.init();
    pixyCamera.setLamp((byte) 1, (byte) 1);
    pixyCamera.setLED(255, 255, 255);

    getBiggestBlock();
  }

  public static Block getBiggestBlock() {
    // Gets the number of "blocks", identified targets, that match signature 1 on
    // the Pixy2, does not wait for new data if none is available, and limits the
    // number of returned blocks to 25, for a slight increase in efficiency
    int blockCount = pixyCamera.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);

    System.out.println("Found " + blockCount + " blocks!"); // Reports number of blocks found

    if (blockCount <= 0) {
      System.err.println("No blocks found!");
      return null; // If blocks were not found, stop processing
    }

    ArrayList<Block> blocks = pixyCamera.getCCC().getBlockCache(); // Gets a list of all blocks found by the Pixy2

    // for (Block block : blocks) {
    //   if (block.getSignature() == blockSignature) {
    //     if (blockColor == null) {
    //       blockColor = block;
    //     } else if (block.getWidth() > blockColor.getWidth()) {
    //       blockColor = block;
    //     }
    //   }
    // }
    return blockColor;
  }

  public void logDataToSmartDashboard() {
    SmartDashboard.putNumber("Block Signature", blockColor.getSignature());

    SmartDashboard.putNumber("Block X", blockColor.getX());
    SmartDashboard.putNumber("Block Y", blockColor.getY());
  }
}
