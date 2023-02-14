package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class IntakeSubsystem extends SubsystemBase {
    
    public static CANSparkMax INTAKE_MOTOR_CONE;
    public static CANSparkMax INTAKE_MOTOR_BOX;

    public static CANSparkMax INTAKE_MOTOR_ROTATION_1;
    public static CANSparkMax INTAKE_MOTOR_ROTATION_2;

    public static CANSparkMax INTAKE_MOTOR_POSITION;

    public IntakeSubsystem() {
        INTAKE_MOTOR_CONE = new CANSparkMax(Robotmap.MOTOR_INTAKE_CONE_ID, MotorType.kBrushless);
        INTAKE_MOTOR_BOX = new CANSparkMax(Robotmap.MOTOR_INTAKE_BOX_ID, MotorType.kBrushless);

        INTAKE_MOTOR_ROTATION_1 = new CANSparkMax(Robotmap.MOTOR_INTAKE_ROTATION_1_ID, MotorType.kBrushless);
        INTAKE_MOTOR_ROTATION_2 = new CANSparkMax(Robotmap.MOTOR_INTAKE_ROTATION_2_ID, MotorType.kBrushless);

        INTAKE_MOTOR_POSITION = new CANSparkMax(Robotmap.MOTOR_INTAKE_POSITION_ID,MotorType.kBrushless);

        // ---------------------------------------------------------------------

        INTAKE_MOTOR_CONE.restoreFactoryDefaults();
        INTAKE_MOTOR_CONE.setSmartCurrentLimit(Constants.INTAKE_MOTOR_CONE_CURRENTLIMIT);
        INTAKE_MOTOR_CONE.enableVoltageCompensation(Constants.INTAKE_MOTOR_CONE_VOLTAGE_COMPENSATION);
        INTAKE_MOTOR_CONE.setInverted(Constants.INTAKE_MOTOR_CONE_INVERTED);

        INTAKE_MOTOR_CONE.setIdleMode(Constants.INTAKE_MOTOR_CONE_IDLEMODE);

        INTAKE_MOTOR_CONE.getPIDController().setP(Constants.INTAKE_MOTOR_CONE_KP);
        INTAKE_MOTOR_CONE.getPIDController().setI(Constants.INTAKE_MOTOR_CONE_KI);
        INTAKE_MOTOR_CONE.getPIDController().setD(Constants.INTAKE_MOTOR_CONE_KD);
        INTAKE_MOTOR_CONE.getPIDController().setFF(Constants.INTAKE_MOTOR_CONE_KF);

        // Need to the change the conversion factor
        INTAKE_MOTOR_CONE.getEncoder().setPositionConversionFactor(0);
        INTAKE_MOTOR_CONE.getEncoder().setVelocityConversionFactor(0);

        // ---------------------------------------------------------------------

        INTAKE_MOTOR_BOX.restoreFactoryDefaults();
        INTAKE_MOTOR_BOX.setSmartCurrentLimit(Constants.INTAKE_MOTOR_BOX_CURRENTLIMIT);
        INTAKE_MOTOR_BOX.enableVoltageCompensation(Constants.INTAKE_MOTOR_BOX_VOLTAGE_COMPENSATION);
        INTAKE_MOTOR_BOX.setInverted(Constants.INTAKE_MOTOR_BOX_INVERTED);

        INTAKE_MOTOR_BOX.setIdleMode(Constants.INTAKE_MOTOR_BOX_IDLEMODE);

        INTAKE_MOTOR_BOX.getPIDController().setP(Constants.INTAKE_MOTOR_BOX_KP);
        INTAKE_MOTOR_BOX.getPIDController().setI(Constants.INTAKE_MOTOR_BOX_KI);
        INTAKE_MOTOR_BOX.getPIDController().setD(Constants.INTAKE_MOTOR_BOX_KD);
        INTAKE_MOTOR_BOX.getPIDController().setFF(Constants.INTAKE_MOTOR_BOX_KF);

        // Need to change the conversion factor
        INTAKE_MOTOR_BOX.getEncoder().setPositionConversionFactor(0);
        INTAKE_MOTOR_BOX.getEncoder().setVelocityConversionFactor(0);

        // ---------------------------------------------------------------------

        INTAKE_MOTOR_ROTATION_1.restoreFactoryDefaults();
        INTAKE_MOTOR_ROTATION_1.setSmartCurrentLimit(Constants.INTAKE_MOTOR_ROTATION_1_CURRENTLIMIT);
        INTAKE_MOTOR_ROTATION_1.enableVoltageCompensation(Constants.INTAKE_MOTOR_ROTATION_1_VOLTAGE_COMPENSATION);

        INTAKE_MOTOR_ROTATION_1.setIdleMode(Constants.INTAKE_MOTOR_ROTATION_IDLEMODE);

        INTAKE_MOTOR_ROTATION_1.getPIDController().setP(Constants.INTAKE_MOTOR_ROTATION_1_KP);
        INTAKE_MOTOR_ROTATION_1.getPIDController().setI(Constants.INTAKE_MOTOR_ROTATION_1_KI);
        INTAKE_MOTOR_ROTATION_1.getPIDController().setD(Constants.INTAKE_MOTOR_ROTATION_1_KD);
        INTAKE_MOTOR_ROTATION_1.getPIDController().setFF(Constants.INTAKE_MOTOR_ROTATION_1_KF);

        // Need to change the conversion factor
        INTAKE_MOTOR_ROTATION_1.getEncoder().setPositionConversionFactor(0);
        INTAKE_MOTOR_ROTATION_1.getEncoder().setVelocityConversionFactor(0);

        // ---------------------------------------------------------------------

        INTAKE_MOTOR_ROTATION_2.restoreFactoryDefaults();
        INTAKE_MOTOR_ROTATION_2.setSmartCurrentLimit(Constants.INTAKE_MOTOR_ROTATION_2_CURRENTLIMIT);
        INTAKE_MOTOR_ROTATION_2.enableVoltageCompensation(Constants.INTAKE_MOTOR_ROTATION_2_VOLTAGE_COMPENSATION);

        INTAKE_MOTOR_ROTATION_2.setIdleMode(Constants.INTAKE_MOTOR_ROTATION_IDLEMODE);

        INTAKE_MOTOR_ROTATION_2.getPIDController().setP(Constants.INTAKE_MOTOR_ROTATION_2_KP);
        INTAKE_MOTOR_ROTATION_2.getPIDController().setI(Constants.INTAKE_MOTOR_ROTATION_2_KI);
        INTAKE_MOTOR_ROTATION_2.getPIDController().setD(Constants.INTAKE_MOTOR_ROTATION_2_KD);
        INTAKE_MOTOR_ROTATION_2.getPIDController().setFF(Constants.INTAKE_MOTOR_ROTATION_2_KF);

        // Need to change the conversion factor
        INTAKE_MOTOR_ROTATION_2.getEncoder().setPositionConversionFactor(0);
        INTAKE_MOTOR_ROTATION_2.getEncoder().setVelocityConversionFactor(0);
    
        // ---------------------------------------------------------------------

        INTAKE_MOTOR_POSITION.restoreFactoryDefaults();
        INTAKE_MOTOR_POSITION.setSmartCurrentLimit(Constants.INTAKE_MOTOR_POSITION_CURRENTLIMIT);
        INTAKE_MOTOR_POSITION.enableVoltageCompensation(Constants.INTAKE_MOTOR_POSITION_VOLTAGE_COMPENSATION);

        INTAKE_MOTOR_POSITION.setIdleMode(Constants.INTAKE_MOTOR_POSITION_IDLEMODE);

        INTAKE_MOTOR_POSITION.getPIDController().setP(Constants.INTAKE_MOTOR_POSITION_KP);
        INTAKE_MOTOR_POSITION.getPIDController().setI(Constants.INTAKE_MOTOR_POSITION_KI);
        INTAKE_MOTOR_POSITION.getPIDController().setD(Constants.INTAKE_MOTOR_POSITION_KD);
        INTAKE_MOTOR_POSITION.getPIDController().setFF(Constants.INTAKE_MOTOR_POSITION_KF);

        // Need to change the conversion factor
        INTAKE_MOTOR_POSITION.getEncoder().setPositionConversionFactor(0);
        INTAKE_MOTOR_POSITION.getEncoder().setVelocityConversionFactor(0);

        // ---------------------------------------------------------------------

        INTAKE_MOTOR_ROTATION_1.follow(INTAKE_MOTOR_ROTATION_2);
    }

    private static IntakeSubsystem Intake_instance = null;

    public static IntakeSubsystem Intake_GetInstance() {
        if (Intake_instance == null)
        {
            Intake_instance = new IntakeSubsystem();
        }
        return Intake_instance;
    }

    // Might need to add feedforward and better SetRef()

    public static void Intake_Cone_Hold(double INTAKE_MOTOR_CONE_RPM) {
        INTAKE_MOTOR_CONE.getPIDController().setReference(INTAKE_MOTOR_CONE_RPM, ControlType.kVelocity);        
    }

    public static void Intake_Cone_Release(double INTAKE_MOTOR_CONE_RPM) {
        INTAKE_MOTOR_CONE.getPIDController().setReference(-INTAKE_MOTOR_CONE_RPM, ControlType.kVelocity);
    }

    public static void Intake_Cone_Stop() {
        INTAKE_MOTOR_CONE.set(0);
    }

    public static boolean Intake_Cone_Running() {
        return INTAKE_MOTOR_CONE.get() != 0;
    }

    public static void Intake_Box_Shoot(double INTAKE_MOTOR_BOX_RPM) {
        INTAKE_MOTOR_BOX.getPIDController().setReference(INTAKE_MOTOR_BOX_RPM, ControlType.kVelocity);
    }

    public static void Intake_Box_Keep() {
        INTAKE_MOTOR_BOX.set(0);
    }

    public static boolean Intake_Box_Running() {
        return INTAKE_MOTOR_BOX.get() != 0;
    }

    public static void Intake_Rotate_Up(double INTAKE_MOTOR_ROTATION_RPM) {
        INTAKE_MOTOR_ROTATION_2.getPIDController().setReference(INTAKE_MOTOR_ROTATION_RPM, ControlType.kSmartMotion);
    }

    public static void Intake_Rotate_Down(double INTAKE_MOTOR_ROTATION_RPM) {
        INTAKE_MOTOR_ROTATION_2.getPIDController().setReference(-INTAKE_MOTOR_ROTATION_RPM, ControlType.kSmartMotion);
    }

    public static void Intake_Rotate_Stop() {
        INTAKE_MOTOR_ROTATION_2.set(0);
    }
    
    public static boolean Intake_Rotate_Running() {
        return INTAKE_MOTOR_ROTATION_2.get() != 0;
    }
    
    public static void Intake_Position_Up(double INTAKE_MOTOR_POSITION_RPM) {
        INTAKE_MOTOR_POSITION.getPIDController().setReference(INTAKE_MOTOR_POSITION_RPM, ControlType.kSmartMotion);
    }

    public static void Intake_Position_Down(double INTAKE_MOTOR_POSITION_RPM) {
        INTAKE_MOTOR_POSITION.getPIDController().setReference(-INTAKE_MOTOR_POSITION_RPM, ControlType.kSmartMotion);
    }
    
    public static boolean Intake_Position_Running() {
        return INTAKE_MOTOR_POSITION.get() != 0;
    }
}
