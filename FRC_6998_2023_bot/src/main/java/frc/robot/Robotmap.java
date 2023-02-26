package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Robotmap {
    public static final String SWERVE_CANBUS_TYPE = "rio";
    public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.REVPH;

    public static final int SWERVE_LEFTFRONT_DRIVEMOTOR = 1;
    public static final int SWERVE_LEFTFRONT_ANGLEMOTOR = 1;
    public static final int SWERVE_LEFTFRONT_CANCODER = 1;

    public static final int SWERVE_LEFTREAR_DRIVEMOTOR = 3;
    public static final int SWERVE_LEFTREAR_ANGLEMOTOR = 4;
    public static final int SWERVE_LEFTREAR_CANCODER = 2;

    public static final int SWERVE_RIGHTFRONT_DRIVEMOTOR = 7;
    public static final int SWERVE_RIGHTFRONT_ANGLEMOTOR = 8;
    public static final int SWERVE_RIGHTFRONT_CANCODER = 4;
    
    public static final int SWERVE_RIGHTREAR_DRIVEMOTOR = 5;
    public static final int SWERVE_RIGHTREAR_ANGLEMOTOR = 6;
    public static final int SWERVE_RIGHTREAR_CANCODER = 3;

// need to change the ids below

    public static final int INTAKE_ROTATION_MOTOR_ID = 0;

    public static final int INTAKE_GRIPPER_SOLENOID_1_CHANNEL = 0;
    public static final int INTAKE_GRIPPER_SOLENOID_2_CHANNEL = 0;
}
