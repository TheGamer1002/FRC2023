// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Auto;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.RobotDrive;
import frc.robot.subsystems.Shooting;
import frc.robot.subsystems.ShootingRotate;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  //HC 01/18/22
  private final RobotDrive drive_subsystem;
  private final BallIntake intake_subsystem;
  private final Shooting shooting_subsystem;
  private final ShootingRotate rotator_subsystem;
  private final Elevator elevator_subsystem;
  private double m_speed;
  private Timer t;
  private int[] seconds;
  private final double endTime = 14.5; //end of Autonomous period and just 0.5s to transition

/**
 * Creates a new Auto Command
 * @param d_sub - drive subsystem
 * @param i_sub - intake subsystem
 * @param s_sub - shooting subsystem
 * @param r_sub - rotating subsystem
 * @param e_sub
 * @param speed
 * @param angle
 * @param sec
 *        [time to align from start, shooting time, ball retreival]
 */
  public AutoCommand(RobotDrive d_sub, BallIntake i_sub, Shooting s_sub, ShootingRotate r_sub, Elevator e_sub, double speed, int[] sec) {
    //HC 01/18/22
    drive_subsystem = d_sub;
    intake_subsystem = i_sub;
    shooting_subsystem = s_sub;
    rotator_subsystem = r_sub;
    elevator_subsystem = e_sub;
    m_speed = speed;
    seconds = sec;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive_subsystem);
    addRequirements(intake_subsystem);
    addRequirements(shooting_subsystem);
    addRequirements(rotator_subsystem);
    addRequirements(drive_subsystem);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     t = new Timer();
    t.start();
    RobotContainer.startingAngle = RobotContainer.limelightTrackingX();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Autocommand execute.");
    //Align robot - HC
    //RobotDrive.gyro.zeroYaw();
    //drive_subsystem.resetEncoders();

    // if(RobotDrive.getDistanceStraight() >= 1) {
    //   drive_subsystem.arcadeDriveSimple(0, 0, 0);
    // } else {
    //   drive_subsystem.arcadeDriveSimple(-m_speed, 0-RobotDrive.PID(), .5);
    // }

  while(RobotDrive.getDistanceStraight() < 12){
      drive_subsystem.arcadeDriveSimple(-m_speed, 0-RobotDrive.PID(), .5);
    }
    drive_subsystem.arcadeDriveSimple(0, 0, 0);



    shooting_subsystem.shootTop(.5);
    
    while(Elevator.m_E1encoder.getPosition() < 2){
      elevator_subsystem.moveUp();
      elevator_subsystem.moveUp2();
      elevator_subsystem.moveUp3();
    }
    elevator_subsystem.stop1();
    elevator_subsystem.stop2();
    elevator_subsystem.stop3();
    shooting_subsystem.shootTop(0);


    drive_subsystem.resetEncoders();
    RobotDrive.gyro.zeroYaw();
    
    while(drive_subsystem.getTurnAmount() < 70){
      drive_subsystem.arcadeDriveSimple(-m_speed, -.5, .5);
    }
    drive_subsystem.arcadeDriveSimple(0, 0, 0);

    

    RobotDrive.gyro.zeroYaw();
    drive_subsystem.resetEncoders();
    while(RobotDrive.getDistanceStraight() < 10){
      drive_subsystem.arcadeDriveSimple(m_speed, 0-RobotDrive.PID(), .5);
    }
    drive_subsystem.arcadeDriveSimple(0, 0, 0);

    RobotDrive.gyro.zeroYaw();
    drive_subsystem.resetEncoders();
    while(drive_subsystem.getTurnAmount() < .5){ //turning left
      drive_subsystem.arcadeDriveSimple(m_speed, .5-RobotDrive.PID(), .5);
    }
    drive_subsystem.arcadeDriveSimple(0, 0, 0);


    shooting_subsystem.shootTop(.93);
    intake_subsystem.ballTake();
    elevator_subsystem.moveUp();
    elevator_subsystem.moveUp2();
    elevator_subsystem.moveUp3();

    /*
    //Shoot - HC
    while(t.get() > seconds[0] && t.get() < seconds[1]) {
      shooting_subsystem.shootTop(0.5); //TO-DO: Update strength value
    }
    //Retreive ball drive - HC
    
    while(t.get() > seconds[1] && t.get() < seconds[2]) {
      drive_subsystem.arcadeDriveSimple(m_speed, 90-RobotDrive.PID(), .5);
    }
    //Retreive ball intake - HC
    while(t.get() > seconds[2] && t.get() < endTime) {
      intake_subsystem.ballTake();
    }*/

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Autocommand end.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return t.get() > 15; //HC
  }
}
