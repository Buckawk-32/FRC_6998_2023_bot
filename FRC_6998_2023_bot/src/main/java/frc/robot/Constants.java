// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
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
public final class Constants {public final static Rotation2d SWERVE_LEFTFRONT_OFFSET = Rotation2d.fromDegrees(227.374047);
 
// -------------------------------------------------------------------- 

  public final static Rotation2d SWERVE_LEFTREAR_OFFSET = Rotation2d.fromDegrees(11.601563);
  public final static Rotation2d SWERVE_RIGHTFRONT_OFFSET = Rotation2d.fromDegrees(71.806641);
  public final static Rotation2d SWERVE_RIGHTREAR_OFFSET = Rotation2d.fromDegrees(175.605469);

  public final static double SWERVE_CHASSIS_TRACKWIDTH_METERS = 0.62865;
  public final static double SWERVE_CHASSIS_WHEELBASE_METERS = 0.62865;
  public final static double SWERVE_WHEEL_CIRCUNFERENCE = Units.inchesToMeters(4.0) * Math.PI;
  public final static double MAX_VOLTAGE = 12.0;
  public final static double SWERVE_MAX_SPEED = 4.5;
  public final static double SWERVE_MAX_ANGULAR_VELOCITY = 4.5;

  public final static int SWERVE_ANGLE_CONTINUOUS_CURRENT_LIMIT = 25;
  public final static int SWERVE_ANGLE_PEAK_CURRENT_LIMIT = 40;
  public final static double SWERVE_ANGLE_PEAK_CURRENT_DURATION = 0.1;
  public final static boolean SWERVE_ANGLE_CURRENT_LIMIT_ENABLE = true;

  public final static NeutralMode ANGLE_NEUTRAL_MODE = NeutralMode.Coast;

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

// --------------------------------------------------------------------

  public static final boolean INTAKE_RIGHT_MOTOR_INVERTED = false;
  public static final boolean INTAKE_LEFT_MOTOR_INVERTED = false;

  public static final double INTAKE_MOTOR_KP = 0.75;
  public static final double INTAKE_MOTOR_KI = 0.0;
  public static final double INTAKE_MOTOR_KD = 0.0;
  public static final double INTAKE_MOTOR_KF = 0.0;

  public static final double INTAKE_VOLTAGE_COMPENSATION = 12.0;
  public static final double INTAKE_MOTOR_RPM = 730;
  public static final int INTAKE_MOTOR_CURRENTLIMIT = 30;

// --------------------------------------------------------------------

  public static final boolean TRANSFER_BELT_FRONT_MOTOR_INVERTED = false;
  public static final boolean TRANSFER_BELT_BACK_MOTOR_INVERTED = false;

  public static final double TRANSFER_BELT_FRONT_MOTOR_KP = 0.75;
  public static final double TRANSFER_BELT_FRONT_MOTOR_KI = 0.0;
  public static final double TRANSFER_BELT_FRONT_MOTOR_KD = 0.0;
  public static final double TRANSFER_BELT_FRONT_MOTOR_KF = 0.0;

  public static final double TRANSFER_BELT_BACK_MOTOR_KP = 0.75;
  public static final double TRANSFER_BELT_BACK_MOTOR_KI = 0.0;
  public static final double TRANSFER_BELT_BACK_MOTOR_KD = 0.0;
  public static final double TRANSFER_BELT_BACK_MOTOR_KF = 0.0;

  public static final int TRANSFER_BELT_FRONT_MOTOR_CURRENTLIMIT = 40;
  public static final int TRANSFER_BELT_BACK_MOTOR_CURRENTLIMIT = 40;

  public static final double TRANSFER_BELT_FRONT_MOTOR_VOLTAGE_COMPENSATION = 12.0;
  public static final double TRANSFER_BELT_BACK_MOTOR_VOLTAGE_COMPENSATION = 12.0;

  public static final double TRANSFER_BELT_MOTOR_FRONT_RPM = 375;
  public static final double TRANSFER_BELT_MOTOR_BACK_RPM = 375;

// --------------------------------------------------------------------

  public static final double TRANSFER_SENSOR_RESO = 0;
  public static final double TRANSFER_SENSOR_RATE = 0;
  public static final double TRANSFER_SENSOR_GAIN = 0;

// --------------------------------------------------------------------

  public static final boolean TRANSFER_UPRIGHT_MOTOR_INVERTED = false;
 
  public static final double TRANSFER_UPRIGHT_MOTOR_KP = 0.75;
  public static final double TRANSFER_UPRIGHT_MOTOR_KI = 0.0;
  public static final double TRANSFER_UPRIGHT_MOTOR_KD = 0.0;
  public static final double TRANSFER_UPRIGHT_MOTOR_KF = 0.0;
 
  public static final int TRANSFER_UPRIGHT_MOTOR_CURRENTLIMIT = 40;
  public static final double TRANSFER_UPRIGHT_MOTOR_VOLTAGE_COMPENSATION = 12.0;

// --------------------------------------------------------------------

  public static final double ARM_JOINT_1_KP = 0;
  public static final double ARM_JOINT_1_KI = 0;
  public static final double ARM_JOINT_1_KD = 0;
  public static final double ARM_JOINT_1_KF = 0;

  public static final double ARM_JOINT_2_KP = 0;
  public static final double ARM_JOINT_2_KI = 0;
  public static final double ARM_JOINT_2_KD = 0;
  public static final double ARM_JOINT_2_KF = 0;

  public static final double ARM_JOINT_1_KS = 0;
  public static final double ARM_JOINT_1_KG = 0;
  public static final double ARM_JOINT_1_KV = 0;
  public static final double ARM_JOINT_1_KA = 0;

  public static final double ARM_JOINT_2_KS = 0;
  public static final double ARM_JOINT_2_KG = 0;
  public static final double ARM_JOINT_2_KV = 0;
  public static final double ARM_JOINT_2_KA = 0;

  public static final double ARM_JOINT_1_POSRADIANS_SETPOINT = 0;
  public static final double ARM_JOINT_1_VELRADIANS_PERSEC_SETPOINT = 0;
  public static final double ARM_JOINT_1_ACCEL_PERSEC_SQUARED_SETPOINT = 0;

  public static final double ARM_JOINT_2_POSRADIANS_SETPOINT = 0;
  public static final double ARM_JOINT_2_VELRADIANS_PERSEC_SETPOINT = 0;
  public static final double ARM_JOINT_2_ACCEL_PERSEC_SQUARED_SETPOINT = 0;
  public static final double ARM_JOINT_1_RPM = 0;
  public static final double ARM_JOINT_2_RPM = 0;

// --------------------------------------------------------------------
}
  


