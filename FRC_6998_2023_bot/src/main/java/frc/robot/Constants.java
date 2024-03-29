// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
 
// -------------------------------------------------------------------- 
  public final static Rotation2d SWERVE_LEFTFRONT_OFFSET = Rotation2d.fromDegrees(243.457031);
  public final static Rotation2d SWERVE_LEFTREAR_OFFSET = Rotation2d.fromDegrees(11.601563);
  public final static Rotation2d SWERVE_RIGHTFRONT_OFFSET = Rotation2d.fromDegrees(71.806641);
  public final static Rotation2d SWERVE_RIGHTREAR_OFFSET = Rotation2d.fromDegrees(175.605469);
// swerve offset need to fix

  public final static double SWERVE_CHASSIS_TRACKWIDTH_METERS = 0.62865;
  public final static double SWERVE_CHASSIS_WHEELBASE_METERS = 0.62865;
  public final static double SWERVE_WHEEL_CIRCUNFERENCE = Units.inchesToMeters(4.0) * Math.PI;
  public final static double MAX_VOLTAGE = 12.0;
  public final static double SWERVE_MAX_SPEED = 4.5;
  public final static double SWERVE_MAX_ANGULAR_VELOCITY = 4.5;

  public final static double VOLTAGE_COMPENSATION = 12.0;

  public final static int SWERVE_ANGLE_CONTINUOUS_CURRENT_LIMIT = 25;
  public final static int SWERVE_ANGLE_PEAK_CURRENT_LIMIT = 40;
  public final static double SWERVE_ANGLE_PEAK_CURRENT_DURATION = 0.1;
  public final static boolean SWERVE_ANGLE_CURRENT_LIMIT_ENABLE = true;

  public final static IdleMode ANGLE_NEUTRAL_MODE = IdleMode.kCoast;

  public final static int SWERVE_DRIVE_CONTINUOUS_CURRENT_LIMIT = 35;
  public final static int SWERVE_DRIVE_PEAK_CURRENT_LIMIT = 60;
  public final static double SWERVE_DRIVE_PEAK_CURRENT_DURATION = 0.1;
  public final static boolean SWERVE_DRIVE_CURRENT_LIMIT_ENABLE = true;

  public final static double SWERVE_DRIVE_MOTOR_KP = 0.05;
  public final static double SWERVE_DRIVE_MOTOR_KI = 0.0;
  public final static double SWERVE_DRIVE_MOTOR_KD = 0.0;
  public final static double SWERVE_DRIVE_MOTOR_KF = 0.0;
  public final static double SWERVE_DRIVE_MOTOR_OPENLOOPRAMP = 0.25;
  public final static double SWERVE_DRIVE_MOTOR_CLOSELOOPRAMP = 0.0;

  public final static NeutralMode DRIVE_NEUTRAL_MODE = NeutralMode.Brake;

  public final static double SWERVE_DRIVE_KS = (0.32 / MAX_VOLTAGE);
  public final static double SWERVE_DRIVE_KV = (1.51 / MAX_VOLTAGE);
  public final static double SWERVE_DRIVE_KA = (0.27 / MAX_VOLTAGE);

  public final static boolean NAVX_INVERTED = true;

  public final static double SWERVE_DRIVE_JOYSTICK_DEADBAND = 0.05;

  public final static SwerveDriveKinematics S_DRIVE_KINEMATICS = new SwerveDriveKinematics(
    new Translation2d(SWERVE_CHASSIS_TRACKWIDTH_METERS / 2.0, SWERVE_CHASSIS_WHEELBASE_METERS / 2.0),
    new Translation2d(-SWERVE_CHASSIS_TRACKWIDTH_METERS / 2.0, SWERVE_CHASSIS_WHEELBASE_METERS / 2.0),
    new Translation2d(SWERVE_CHASSIS_TRACKWIDTH_METERS / 2.0, -SWERVE_CHASSIS_WHEELBASE_METERS / 2.0),
    new Translation2d(-SWERVE_CHASSIS_TRACKWIDTH_METERS / 2.0, -SWERVE_CHASSIS_WHEELBASE_METERS / 2.0)
  );

// --------------------------------------------------------------------

  public static final double SWERVE_AUTO_XY_KP = 5.0;
  public static final double SWERVE_AUTO_XY_KI = 0.0;
  public static final double SWERVE_AUTO_XY_KD = 0.0;

  public static final double SWERVE_AUTO_Z_KP = 0.0;
  public static final double SWERVE_AUTO_Z_KI = 0.0;
  public static final double SWERVE_AUTO_Z_KD = 0.0;

  public static final double BALANCE_DEG_GOAL = 0.0;

// --------------------------------------------------------------------

  public static final int INTAKE_ROTATION_MOTOR_CURRENTLIMIT = 0;
  public static final double INTAKE_ROTATION_MOTOR_VOLTAGE_COMPENSATION = 0.0; 

  public static final IdleMode INTAKE_ROTATION_MOTOR_IDLEMODE = IdleMode.kBrake;

  public static final double INTAKE_ROTATION_MOTOR_KP = 0.0;
  public static final double INTAKE_ROTATION_MOTOR_KI = 0.0;
  public static final double INTAKE_ROTATION_MOTOR_KD = 0.0;
  public static final double INTAKE_ROTATION_MOTOR_KF = 0.0;

  public static final double INTAKE_JOYSTICK_DEADBAND = 0.05;

// --------------------------------------------------------------------

  public static final int SLIDER_LENTGH_MOTOR_CURRENTLIMIT = 0;
  public static final double SLIDER_LENTGH_MOTOR_VOLTAGE_COMPENSATION = 0.0;

  public static final IdleMode SLIDER_LENGTH_IDLEMODE = IdleMode.kBrake;

  public static final double SLIDER_LENGTH_KP = 0.0;
  public static final double SLIDER_LENGTH_KI = 0.0;
  public static final double SLIDER_LENGTH_KD = 0.0;
  public static final double SLIDER_LENGTH_KF = 0.0;

  public static final double SLIDER_MID_NODE_LENGTH = 0.0;
  public static final double SLIDER_HIGH_NODE_LENGTH = 0.0;

}
  


