/* Copyright (C) 2022 Team 3602. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.team3602.robot;

/**
 * The Constants interface provides globally-accessible robot constants.
 *
 * @author Cody Wellman
 */
public interface Constants {

    /**
     * The Drivetrain interface provides CAN IDs and other information for the
     * drivetrain subsystem.
     */
    public interface Drivetrain {
        int driveFrontLeftCANID = 1;
        int driveBackLeftCANID = 2;
        int driveFrontRightCANID = 3;
        int driveBackRightCANID = 4;
    }

    /**
     * The Controller interface provides controller port IDs and button IDs.
     */
    public interface Controller {
        int joystickPort = 0;
    }
}
