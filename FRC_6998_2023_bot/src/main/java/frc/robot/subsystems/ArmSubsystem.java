package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class ArmSubsystem extends SubsystemBase {
    
    public static CANSparkMax ARM_JOINT_MOTOR_1;
    public static CANSparkMax ARM_JOINT_MOTOR_2;

    public final AbsoluteEncoder ARM_JOINT_ENCODER_1;
    public final AbsoluteEncoder ARM_JOINT_ENCODER_2;

    public ArmSubsystem() {
        ARM_JOINT_MOTOR_1 = new CANSparkMax(Robotmap.ARM_JOINT_MOTOR_1, MotorType.kBrushless);
        ARM_JOINT_MOTOR_2 = new CANSparkMax(Robotmap.ARM_JOINT_MOTOR_2, MotorType.kBrushless);

        ARM_JOINT_MOTOR_1.setIdleMode(IdleMode.kBrake);
        ARM_JOINT_MOTOR_2.setIdleMode(IdleMode.kBrake);
        
        ARM_JOINT_MOTOR_1.getPIDController().setP(Constants.ARM_JOINT_1_KP);

        ARM_JOINT_MOTOR_2.getPIDController().setP(Constants.ARM_JOINT_2_KP);
    }

    private static ArmSubsystem ArmMotors_instance = null;

    public static ArmSubsystem ArmM_getInstance() {
        if (ArmMotors_instance == null) {
            ArmMotors_instance = new ArmSubsystem();
        }
        return ArmMotors_instance;
    }

    


}
