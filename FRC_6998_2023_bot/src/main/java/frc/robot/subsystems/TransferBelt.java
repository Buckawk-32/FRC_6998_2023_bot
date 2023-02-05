package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class TransferBelt extends SubsystemBase {
    
    public static CANSparkMax TRANSFER_BELT_MOTOR_FRONT;
    public static CANSparkMax TRANSFER_BELT_MOTOR_BACK;

    private TransferBelt() {
        TRANSFER_BELT_MOTOR_FRONT = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_FRONT, MotorType.kBrushless);
        TRANSFER_BELT_MOTOR_BACK = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_BACK, MotorType.kBrushless);

        TRANSFER_BELT_MOTOR_FRONT.restoreFactoryDefaults();
        TRANSFER_BELT_MOTOR_FRONT.setSmartCurrentLimit(Constants.TRANSFER_BELT_FRONT_MOTOR_CURRENTLIMIT);
        TRANSFER_BELT_MOTOR_FRONT.setInverted(Constants.TRANSFER_BELT_FRONT_MOTOR_INVERTED);
        TRANSFER_BELT_MOTOR_FRONT.enableVoltageCompensation(Constants.TRANSFER_BELT_FRONT_MOTOR_VOLTAGE_COMPENSATION);

        TRANSFER_BELT_MOTOR_FRONT.getPIDController().setP(Constants.TRANSFER_BELT_FRONT_MOTOR_KP);
        TRANSFER_BELT_MOTOR_FRONT.getPIDController().setI(Constants.TRANSFER_BELT_FRONT_MOTOR_KI);
        TRANSFER_BELT_MOTOR_FRONT.getPIDController().setD(Constants.TRANSFER_BELT_FRONT_MOTOR_KD);
        TRANSFER_BELT_MOTOR_FRONT.getPIDController().setFF(Constants.TRANSFER_BELT_FRONT_MOTOR_KF);
        
        TRANSFER_BELT_MOTOR_FRONT.getEncoder().setVelocityConversionFactor(1/15);
    
        TRANSFER_BELT_MOTOR_BACK.restoreFactoryDefaults();
        TRANSFER_BELT_MOTOR_BACK.setSmartCurrentLimit(Constants.TRANSFER_BELT_BACK_MOTOR_CURRENTLIMIT);
        TRANSFER_BELT_MOTOR_BACK.setInverted(Constants.TRANSFER_BELT_BACK_MOTOR_INVERTED);
        TRANSFER_BELT_MOTOR_BACK.enableVoltageCompensation(Constants.TRANSFER_BELT_BACK_MOTOR_VOLTAGE_COMPENSATION);

        TRANSFER_BELT_MOTOR_BACK.getPIDController().setP(Constants.TRANSFER_BELT_BACK_MOTOR_KP);
        TRANSFER_BELT_MOTOR_BACK.getPIDController().setI(Constants.TRANSFER_BELT_BACK_MOTOR_KI);
        TRANSFER_BELT_MOTOR_BACK.getPIDController().setD(Constants.TRANSFER_BELT_BACK_MOTOR_KD);
        TRANSFER_BELT_MOTOR_BACK.getPIDController().setFF(Constants.TRANSFER_BELT_BACK_MOTOR_KF);

        TRANSFER_BELT_MOTOR_BACK.getEncoder().setVelocityConversionFactor(1/15);
    }

    public static void TransferBelt_SetMotor() {
        TRANSFER_BELT_MOTOR_FRONT.getPIDController().setReference(Constants.TRANSFER_BELT_MOTOR_FRONT_RPM, ControlType.kVelocity);
        TRANSFER_BELT_MOTOR_BACK.getPIDController().setReference(Constants.TRANSFER_BELT_MOTOR_BACK_RPM, ControlType.kVelocity);
    }

    public static void TransferBelt_SetMotor_0() {
        TRANSFER_BELT_MOTOR_FRONT.set(0);
        TRANSFER_BELT_MOTOR_BACK.set(0);
    }

    public static boolean isTransferBelt_running_FRONT() {
        return  TRANSFER_BELT_MOTOR_FRONT.get() == Constants.TRANSFER_BELT_MOTOR_FRONT_RPM;
    }

    public static boolean isTransferBelt_running_BACK() {
        return TRANSFER_BELT_MOTOR_BACK.get() == Constants.TRANSFER_BELT_MOTOR_BACK_RPM;
    }

    public static boolean isTransferBelt_NOTrunning_FRONT() {
        return  TRANSFER_BELT_MOTOR_FRONT.get() == 0;
    }

    public static boolean isTransferBelt_NOTrunning_BACK() {
        return TRANSFER_BELT_MOTOR_BACK.get() == 0;
    }
}
