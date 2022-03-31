/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot;

import com.team3602.robot.commands.*;
import com.team3602.robot.subsystems.*;

// WPILib imports
import edu.wpi.first.wpilibj2.command.Command;

/**
 * The RobotContainer class provides the subsystems, commands, operator
 * interfaces and all the default settings for the robot.
 *
 * @author Cody Wellman
 */
public class RobotContainer {
    // Subsystems
    public final static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
    public final static PixySubsystem pixySubsystem = new PixySubsystem();
    public final static BlingTestSubsystem blingTest = new BlingTestSubsystem();

    // Commands
    public final static DrivetrainCommand drivetrainCommand = new DrivetrainCommand();
    public final static PixyCommand pixyCommand = new PixyCommand();
    public final static PixyTurnPIDCommand pixyTurnPIDCommand = new PixyTurnPIDCommand();

    // Operator interfaces
    public static OI oi;

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();

        blingTest.Init();
    }

    // Defaults

    private void configureDefaultCommands() {
        drivetrainSubsystem.setDefaultCommand(drivetrainCommand);
        pixySubsystem.setDefaultCommand(pixyCommand);
    }

    private void configureButtonBindings() {
        OI.joystickButtonOne.whileHeld(pixyTurnPIDCommand);
    }

    // Autonomous

    public Command getAutonomousCommand() {
        return null;
    }
}
