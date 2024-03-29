// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Drive.AutoBalanceCommand;
import frc.robot.commands.Drive.SwerveDriveCommand;
import frc.robot.commands.Intake.IntakeRotateCommand;
import frc.robot.commands.Slide.SliderExtendCommand;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.SliderSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import java.util.HashMap;
import java.util.List;

import com.kauailabs.navx.frc.AHRS;
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
    private final IntakeSubsytem intakeSubsytem = new IntakeSubsytem();
    private final SliderSubsystem sliderSubsytem = new SliderSubsystem();

    private final static XboxController controller_driveX = new XboxController(0);

    private final static XboxController controller_operatorX = new XboxController(1);

    private final static AHRS navX = new AHRS();

    // * We need to make more pathplanner and auto stuff

    List<PathPlannerTrajectory> pathGroup = 
      PathPlanner.loadPathGroup("New Path", new PathConstraints(4, 3));
    
    HashMap<String, Command> eventMap = new HashMap<>(){{
      put("AutoBalanceCommand", new AutoBalanceCommand(
        swerveSubsystem,
        Constants.SWERVE_AUTO_XY_KP,
        Constants.SWERVE_AUTO_XY_KI,
        Constants.SWERVE_AUTO_XY_KD,
        navX,
        () -> controller_driveX.getRightBumper()
        ));
    }};
    
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

    /**
     * todo: have to change out left bumper for POV down in Slider, but idk how, without POV angle
     */

    public RobotContainer()
    {
      swerveSubsystem.setDefaultCommand(new SwerveDriveCommand(
        swerveSubsystem,
        () -> controller_driveX.getLeftY(),
        () -> controller_driveX.getLeftX(),
        () -> controller_driveX.getRightX(),
        () -> controller_driveX.getLeftBumper()
      ));

      intakeSubsytem.setDefaultCommand(new IntakeRotateCommand(
        intakeSubsytem, 
        () -> controller_operatorX.getLeftY()
      ));

      sliderSubsytem.setDefaultCommand(new SliderExtendCommand(
        sliderSubsytem,
        () -> controller_operatorX.getYButton(),
        () -> controller_operatorX.getAButton(),
        () -> controller_operatorX.getLeftBumper() //! need to change out the left bumper for POV down
      ));      

        configureBindings();
    }

    // ? Idk wheter this works
    
    private void configureBindings() {
      new JoystickButton(controller_driveX, XboxController.Button.kLeftBumper.value)
        .onTrue(new InstantCommand(swerveSubsystem::zeroGyro));

      new JoystickButton(controller_operatorX, XboxController.Button.kX.value)
        .onTrue(new InstantCommand(intakeSubsytem::INTAKE_GRIPPER_GRAB));

      new JoystickButton(controller_operatorX, XboxController.Button.kB.value)
        .onTrue(new InstantCommand(intakeSubsytem::INTAKE_GRIPPER_RELEASE));
    }

    public Command getAutonomousCommand() {
      return fullAuto;
    } 

}