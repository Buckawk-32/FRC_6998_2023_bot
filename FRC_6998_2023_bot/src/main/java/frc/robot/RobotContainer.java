// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.IntakePivotCommand;
import frc.robot.commands.SliderDriveCommand;
import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SliderSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
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

    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private final SliderSubsystem sliderSubsystem = new SliderSubsystem();

    private final static XboxController controller_driveX = new XboxController(0);

    private final static XboxController controller_operatorX = new XboxController(1);

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
        () -> controller_driveX.getLeftBumper()
        ));

      intakeSubsystem.setDefaultCommand(new IntakePivotCommand(
        intakeSubsystem,
        () -> controller_operatorX.getRawAxis(XboxController.Axis.kLeftTrigger.value),
        () -> controller_operatorX.getRawAxis(XboxController.Axis.kRightTrigger.value),
        () -> controller_operatorX.getRawButton(XboxController.Button.kA.value),
        () -> controller_operatorX.getRawButton(XboxController.Button.kB.value),
        () -> controller_operatorX.getRawButton(XboxController.Button.kX.value),
        () -> controller_operatorX.getRawAxis(XboxController.Axis.kLeftY.value)
        ));

      sliderSubsystem.setDefaultCommand(new SliderDriveCommand(
        sliderSubsystem,
        () -> controller_operatorX.getRawAxis(XboxController.Axis.kRightX.value)        
        ));

        configureBindings();
    }

    private void configureBindings() {
      new JoystickButton(controller_driveX, XboxController.Button.kLeftBumper.value)
        .onTrue(new InstantCommand(swerveSubsystem::zeroGyro));
    }

    public Command getAutonomousCommand() {
      return fullAuto;
    }
} 