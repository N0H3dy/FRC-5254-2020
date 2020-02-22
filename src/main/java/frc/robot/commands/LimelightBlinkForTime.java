/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LedMode;

public class LimelightBlinkForTime extends WaitCommand {
  /** Creates a new LimelightBlinkForTime. */
  private Limelight limelight;

  public LimelightBlinkForTime(Limelight limelight, double seconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    super(seconds);
    this.limelight = limelight;
    addRequirements(limelight);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    limelight.setLedMode(LedMode.FORCE_BLINK);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    limelight.setLedMode(LedMode.PIPELINE);
  }
}
