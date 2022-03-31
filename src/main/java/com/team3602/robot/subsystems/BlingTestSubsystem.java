// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team3602.robot.subsystems;

import com.team3602.EColorStrip;
import com.team3602.robot.OI;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BlingTestSubsystem extends SubsystemBase {

  private static EColorStrip colorStrip = new EColorStrip(0, 72, 2, 0);

  private boolean onOne = false;
  private boolean onTwo = false;

  private boolean prevOne = false;
  private boolean prevTwo = false;

  /** Creates a new BlingTestSubsystem. */
  public BlingTestSubsystem()
  {

    DriverStation.getAlliance();
  }

  public void Init()
  {
    colorStrip.start();
  }

  public static Color GetAllianceColor()
  {
    if(DriverStation.getAlliance() == Alliance.Blue)
     return Color.kFirstBlue;
    else
     return Color.kFirstRed;
  }

  public void SetAllianceColor()
  {
    colorStrip.SetAllColor(GetAllianceColor());
  }

  public void SetOne(boolean on)
  {
    onOne = on;
  }

  public void SetTwo(boolean on)
  {
    onTwo = on;
  }

  @Override
  public void periodic()
  {

    onOne = OI.joystick.getRawButton(11);
    onTwo = OI.joystick.getRawButton(12);


    if(onOne && !prevOne) 
    {
      colorStrip.SetSectionColor(0, Color.kGreen);
    }
    else if(!onOne && prevOne)
    {
      colorStrip.SetSectionColor(0, GetAllianceColor());
    }

    if(onTwo && !prevTwo)
    {
      colorStrip.SetSectionColor(1, Color.kGreen);
    }
    else if(!onTwo && prevTwo)
    {
      colorStrip.SetSectionColor(1, GetAllianceColor());
    }

    prevOne = onOne;
    prevTwo = onTwo;

   // colorStrip.start();

    // This method will be called once per scheduler run
  }
}
