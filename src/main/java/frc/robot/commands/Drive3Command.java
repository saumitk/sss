// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSystem;

public class Drive3Command extends Command {
  /** Creates a new Drive3Command. */

  DriveSystem ds1 = new DriveSystem();
  

  public Drive3Command(DriveSystem ds) {
    ds1 = ds;
    addRequirements(ds1);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ds1.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ds1.move(ds1.getSpeed(), 0);

   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if(ds1.getMeters() > 2.95 && ds1.getMeters() < 3.05 )
      return true; 
    else
     return false;
  }
}
