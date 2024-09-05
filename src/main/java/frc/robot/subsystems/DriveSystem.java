// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommand;

public class DriveSystem extends SubsystemBase {
  /** Creates a new DriveSystem. */

  TalonFX topLeft, topRight, bottomLeft, bottomRight; 
  DriveSystem ds1;
  DriveCommand dc1;
  double ticks; 
  double rotations;
  double meters;

PIDController pd = new PIDController(0.1, 0, 0);

  public DriveSystem() {
    ds1 = new DriveSystem();
    dc1 = new DriveCommand(ds1);
    topLeft = new TalonFX(4);
    topRight = new TalonFX(3);
    bottomLeft = new TalonFX(2);
    bottomRight = new TalonFX(1);
    ticks = 0.0;
    initDefaultCommand();

  }

  public void initDefaultCommand() {
    setDefaultCommand(dc1);
  }


  public void reset()
  {
    topLeft.setPosition(0);
    bottomLeft.setPosition(0);
    topRight.setPosition(0);
    bottomRight.setPosition(0);


  }

  public void move(double forwardSpeed, double turnSpeed)
  {
      topLeft.set(forwardSpeed + turnSpeed);
      topRight.set(forwardSpeed - turnSpeed);
      bottomLeft.set(forwardSpeed + turnSpeed);
      bottomRight.set(forwardSpeed - turnSpeed);
  }

  public void stop()
  {
    topLeft.set(0);
    topRight.set(0);
    bottomRight.set(0);
    bottomLeft.set(0);
  }

  public double getSpeed()
  { 


  return pd.calculate(meters, 3);

  }

  public double getMeters()
  {
     ticks = topLeft.getPosition().getValueAsDouble();
 rotations =  ticks / 2048;
   meters = rotations*0.0254*0.0762*Math.PI;

   return meters; 
  }

 

  public void moveRotate()
  {
    bottomLeft.set(0.5);
    topLeft.set(0.5);
    bottomRight.set(0.5);
    topRight.set(0.5);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
