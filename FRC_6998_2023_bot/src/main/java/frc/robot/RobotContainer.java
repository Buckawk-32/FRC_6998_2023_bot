// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.IntakePivot;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.TransferElevator;

import java.util.HashMap;
import java.util.List;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();

    private final static XboxController controller_driveX = new XboxController(0);

    private final static XboxController controller_operatorX = new XboxController(1);

    public static double LeftY = controller_operatorX.getLeftY();
    public static double RightY = controller_operatorX.getRightY();

    List<PathPlannerTrajectory> pathGroup = 
      PathPlanner.loadPathGroup("New New Path", new PathConstraints(4, 3));
    
    HashMap<String, Command> eventMap = new HashMap<>();

    SwerveAutoBuilder autobuilder = new SwerveAutoBuilder(
      swerveSubsystem::getPose,
      swerveSubsystem::resetOdometry,
      Constants.S_DRIVE_KINEMATICS,
      new PIDConstants(Constants.SWERVE_AUTO_XY_KP, Constants.SWERVE_AUTO_Z_KI, Constants.SWERVE_AUTO_Z_KD),
      new PIDConstants(Constants.SWERVE_AUTO_XY_KP, Constants.SWERVE_AUTO_Z_KI, Constants.SWERVE_AUTO_Z_KD),
      swerveSubsystem::setModuleStates,
      eventMap,
      false,
      swerveSubsystem
    );

    private final Command fullAuto = autobuilder.fullAuto(pathGroup);

    public RobotContainer()
    {
      swerveSubsystem.setDefaultCommand(new SwerveDriveCommand(
        swerveSubsystem,
        () -> controller_driveX.getRawAxis(XboxController.Axis.kLeftY.value),
        () -> controller_driveX.getRawAxis(XboxController.Axis.kLeftX.value),
        () -> controller_driveX.getRawAxis(XboxController.Axis.kRightX.value),
        () -> controller_driveX.getStartButton()
        ));

        configureBindings();

        if (controller_operatorX.getLeftBumperPressed()) {
          IntakePivot.extendIntake();
        } else if (controller_operatorX.getLeftBumperReleased()) {
          IntakePivot.retractIntake();
        } else if (IntakePivot.isIntakeExtended_PIVOT1() && IntakePivot.isIntakeExtended_PIVOT2() == true) {
          IntakeMotor.IntakeSpeed_Motor(Constants.INTAKE_MOTOR_RPM);
        } else if (IntakePivot.isIntakeRetracted_PIVOT1() && IntakePivot.isIntakeRetracted_PIVOT2() == true) {
          IntakeMotor.IntakeSpeed_Motor(0);
        }

        if (controller_operatorX.getXButtonPressed()) {
          TransferElevator.extendEle();
        } else if (controller_operatorX.getXButtonReleased()) {
          TransferElevator.retractEle();
        }

        if (LeftY == LeftY) {
          ArmSubsystem.Drive_Arm_Motor_1();
        } else if (RightY == RightY) {
          ArmSubsystem.Drive_Arm_Motor_2();
        }
    }

    private void configureBindings() {
      new JoystickButton(controller_driveX, XboxController.Button.kStart.value)
        .onTrue(new InstantCommand(swerveSubsystem::zeroGyro));
    }

    public Command getAutonomousCommand() {
      return fullAuto;
    }
} 