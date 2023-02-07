package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Robotmap {
    public static final String SWERVE_CANBUS_TYPE = "rio";
    public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.REVPH;

    public static final int SWERVE_LEFTFRONT_DRIVEMOTOR = 1;
    public static final int SWERVE_LEFTFRONT_ANGLEMOTOR = 2;
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

    public static final int INTAKE_PIVOT_1_ENGAGE = 0;
    public static final int INTAKE_PIVOT_1_DISENGAGE = 1;
    public static final int INTAKE_PIVOT_2_ENGAGE = 2;
    public static final int INTAKE_PIVOT_2_DISENGAGE = 3;
    public static final int INTAKE_MOTOR_RIGHT = 9;
    public static final int INTAKE_MOTOR_LEFT = 10;

    public static final int TRANSFER_BELT_MOTOR_FRONT = 11;
    public static final int TRANSFER_BELT_MOTOR_BACK = 12;
    public static final int TRANSFER_ELE_ENGAGE = 4;
    public static final int TRANSFER_ELE_DISENGAGE = 5;

    public static final int TRANSFER_UPRIGHT_MOTOR = 13;

    public static final int ARM_JOINT_MOTOR_1 = 14;
    public static final int ARM_JOINT_MOTOR_2 = 15;
    public static final int ARM_GRIPPER_ENGAGE = 6;
    public static final int ARM_GRIPPER_DISENGAGE = 7;
}
