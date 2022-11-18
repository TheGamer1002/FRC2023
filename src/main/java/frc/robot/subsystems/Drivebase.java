// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivebase extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Spark fLeft;
private Spark fRight;
private MotorControllerGroup front;
private Spark bLeft;
private Spark bRight;
private MotorControllerGroup back;
private MecanumDrive mecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Drivebase() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
fLeft = new Spark(0);
 addChild("FLeft",fLeft);
 fLeft.setInverted(false);

fRight = new Spark(1);
 addChild("FRight",fRight);
 fRight.setInverted(false);

front = new MotorControllerGroup(fLeft, fRight  );
 addChild("Front",front);
 

bLeft = new Spark(2);
 addChild("BLeft",bLeft);
 bLeft.setInverted(false);

bRight = new Spark(3);
 addChild("BRight",bRight);
 bRight.setInverted(false);

back = new MotorControllerGroup(bLeft, bRight  );
 addChild("Back",back);
 

mecanumDrive = new MecanumDrive(fLeft, bLeft,
fRight, bRight);
 addChild("Mecanum Drive",mecanumDrive);
 mecanumDrive.setSafetyEnabled(true);
mecanumDrive.setExpiration(0.1);
mecanumDrive.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Hopefully working.

    /**
     * Drive method for the mecanum base.
     * 
     * <p>Uses driveCartesian as the driver.
     * @param y      Left value, perhaps from a joystick.
     * @param x      Right value, also perhaps from a joystick.
     * @param z      Rotation value, from-AHA! You thought I was about to type "perhaps from a joystick!" You fool! It might come from a SEPERATE joystick, because a joystick only has 2 axes!
     */
    public void drive(double y, double x, double z) {
        mecanumDrive.driveCartesian(y, x, z);
    }

}

