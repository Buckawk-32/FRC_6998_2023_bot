package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class ArmSubsystem extends SubsystemBase {
    
    public static CANSparkMax ARM_JOINT_MOTOR_1;
    public static CANSparkMax ARM_JOINT_MOTOR_2;

    public final AbsoluteEncoder ARM_JOINT_ENCODER_1;
    public final AbsoluteEncoder ARM_JOINT_ENCODER_2;

    public static ArmFeedforward ARM_JOINT_1_FF = new ArmFeedforward(Constants.ARM_JOINT_1_KS, Constants.ARM_JOINT_1_KG, Constants.ARM_JOINT_1_KV, Constants.ARM_JOINT_1_KA);
    public static ArmFeedforward ARM_JOINT_2_FF = new ArmFeedforward(Constants.ARM_JOINT_1_KS, Constants.ARM_JOINT_2_KG, Constants.ARM_JOINT_2_KV, Constants.ARM_JOINT_2_KA);
    
    public ArmSubsystem() {
        ARM_JOINT_MOTOR_1 = new CANSparkMax(Robotmap.ARM_JOINT_MOTOR_1, MotorType.kBrushless);
        ARM_JOINT_MOTOR_2 = new CANSparkMax(Robotmap.ARM_JOINT_MOTOR_2, MotorType.kBrushless);

        ARM_JOINT_ENCODER_1 = ARM_JOINT_MOTOR_1.getAbsoluteEncoder(Type.kDutyCycle);
        ARM_JOINT_ENCODER_2 = ARM_JOINT_MOTOR_2.getAbsoluteEncoder(Type.kDutyCycle);

        ARM_JOINT_MOTOR_1.restoreFactoryDefaults();
        ARM_JOINT_MOTOR_2.restoreFactoryDefaults();

        ARM_JOINT_MOTOR_1.setIdleMode(IdleMode.kBrake);
        ARM_JOINT_MOTOR_2.setIdleMode(IdleMode.kBrake);
        
        ARM_JOINT_MOTOR_1.getPIDController().setP(Constants.ARM_JOINT_1_KP);
        ARM_JOINT_MOTOR_1.getPIDController().setI(Constants.ARM_JOINT_1_KI);
        ARM_JOINT_MOTOR_1.getPIDController().setD(Constants.ARM_JOINT_1_KD);

        ARM_JOINT_MOTOR_2.getPIDController().setP(Constants.ARM_JOINT_2_KP);
        ARM_JOINT_MOTOR_2.getPIDController().setI(Constants.ARM_JOINT_2_KI);
        ARM_JOINT_MOTOR_2.getPIDController().setD(Constants.ARM_JOINT_2_KD);

        ARM_JOINT_MOTOR_1.set(0);
        ARM_JOINT_MOTOR_2.set(0);
    }

    private static ArmSubsystem ArmMotors_instance = null;

    public static ArmSubsystem ArmM_getInstance() {
        if (ArmMotors_instance == null) {
            ArmMotors_instance = new ArmSubsystem();
        }
        return ArmMotors_instance;
    }

    public static void Drive_Arm_Motor_1() {
        ARM_JOINT_MOTOR_1.getPIDController().setReference(Constants.ARM_JOINT_1_RPM, ControlType.kSmartMotion, 0, ARM_JOINT_1_FF.calculate(Constants.ARM_JOINT_1_POSRADIANS_SETPOINT, Constants.ARM_JOINT_1_VELRADIANS_PERSEC_SETPOINT, Constants.ARM_JOINT_1_ACCEL_PERSEC_SQUARED_SETPOINT));
    }

    public static void Drive_Arm_Motor_2() {
        ARM_JOINT_MOTOR_2.getPIDController().setReference(Constants.ARM_JOINT_2_RPM, ControlType.kSmartMotion, 0, ARM_JOINT_2_FF.calculate(Constants.ARM_JOINT_2_POSRADIANS_SETPOINT, Constants.ARM_JOINT_2_VELRADIANS_PERSEC_SETPOINT, Constants.ARM_JOINT_2_ACCEL_PERSEC_SQUARED_SETPOINT));
    }

    public static void Stop_Arm_Motor_1() {
        ARM_JOINT_MOTOR_1.set(0);
    }

    public static void Stop_Arm_Motor_2() {
        ARM_JOINT_MOTOR_2.set(0);
    }

    public static boolean is_Joint1_running() {
        return ARM_JOINT_MOTOR_1.get() != 0;
    }

    public static boolean is_Joint2_running() {
        return ARM_JOINT_MOTOR_2.get() != 0;
    }
}
