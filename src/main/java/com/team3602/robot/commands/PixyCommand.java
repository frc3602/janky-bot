/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot.commands;

import com.team3602.robot.RobotContainer;
import com.team3602.robot.subsystems.PixySubsystem;

// Java imports
import java.util.ArrayList;

// WPILib imports
import edu.wpi.first.wpilibj2.command.CommandBase;

// Pixy2JavaAPI imports
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class PixyCommand extends CommandBase {

  private static final int RED_BALL = 1;
  private static final int BLUE_BALL = 2;

  public static Block largestBlock = null;

  public PixyCommand() {
    addRequirements(RobotContainer.pixySubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.pixySubsystem.logDataToSmartDashboard();

    // Gets the number of "blocks", identified targets, does not wait for new data
    // if none is available, and limits the number of returned blocks to 25, for a
    // slight increase in efficiency
    int pixyBlocks = PixySubsystem.pixyCamera.getCCC().getBlocks(false);

    // System.out.println("Found " + blockCount + " blocks!"); // Reports number of
    // blocks found

    // if (blockCount <= 0) {
    // System.err.println("No blocks found!");
    // return; // If blocks were not found, stop processing
    // }

    ArrayList<Block> blocks = PixySubsystem.pixyCamera.getCCC().getBlockCache(); // Gets a list of all blocks found

    for (Block block : blocks) {
      if (block.getSignature() == RED_BALL) {
        System.out.println("Red ball found!");
      } else if (block.getSignature() == BLUE_BALL) {
        System.out.println("Blue ball found!");
      }
    }

    largestBlock = null;

    for (Block block : blocks) { // Loops through all blocks and finds the widest one
      if (largestBlock == null) {
        largestBlock = block;
      } else if (block.getWidth() > largestBlock.getWidth()) {
        largestBlock = block;
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
