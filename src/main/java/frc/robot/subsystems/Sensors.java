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
import edu.wpi.first.wpilibj.Timer; import edu.wpi.first.wpilibj.DriverStation; import com.kauailabs.navx.frc.AHRS; import edu.wpi.first.wpilibj.SPI; import edu.wpi.first.wpilibj.SerialPort.Port;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Sensors extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private AHRS navXMicro2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Sensors() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
try { navXMicro2 = new AHRS(SPI.Port.kMXP);} catch (RuntimeException ex ) {DriverStation.reportError( ex.getMessage(), true);} Timer.delay(1.0);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        

        // Rotate the robot 90 degrees counter-clockwise. The robot's speed will be set to 0.5. I want you to take the initial position and angles (y-axis) and the end position and angles and calculate where the center of the rotation is relative to the robot. Then, correct it by setting constants to multiply x, y, and z by. I will use this in a mecanum drive, so calibrate accordingly.

        // This is the initial position and angles.
        double initX = navXMicro2.getWorldLinearAccelX();
        double initY = navXMicro2.getWorldLinearAccelY();
        double initZ = navXMicro2.getWorldLinearAccelZ();
        double initAngle = navXMicro2.getAngle();

        // This is the end position and angles.
        double endX = navXMicro2.getWorldLinearAccelX();
        double endY = navXMicro2.getWorldLinearAccelY();
        double endZ = navXMicro2.getWorldLinearAccelZ();
        double endAngle = navXMicro2.getAngle();

        // This is the center of rotation.
        double centerX = (initX + endX) / 2;
        double centerY = (initY + endY) / 2;
        double centerZ = (initZ + endZ) / 2;
        double centerAngle = (initAngle + endAngle) / 2;

        // This is the constants.
        double xConstant = centerX / initX;
        double yConstant = centerY / initY;
        double zConstant = centerZ / initZ;
        double angleConstant = centerAngle / initAngle;

        // This is the corrected position.
        double correctedX = initX * xConstant;
        double correctedY = initY * yConstant;
        double correctedZ = initZ * zConstant;
        double correctedAngle = initAngle * angleConstant;

        // This is the corrected position.
        System.out.println("Corrected X: " + correctedX);
        System.out.println("Corrected Y: " + correctedY);
        System.out.println("Corrected Z: " + correctedZ);
        System.out.println("Corrected Angle: " + correctedAngle);

        // This is the initial position.
        System.out.println("Initial X: " + initX);
        System.out.println("Initial Y: " + initY);
        System.out.println("Initial Z: " + initZ);
        System.out.println("Initial Angle: " + initAngle);

        // This is the end position.
        System.out.println("End X: " + endX);
        System.out.println("End Y: " + endY);
        System.out.println("End Z: " + endZ);
        System.out.println("End Angle: " + endAngle);

        // This is the center of rotation.

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

