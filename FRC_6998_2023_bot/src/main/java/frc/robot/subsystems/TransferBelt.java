package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class TransferBelt extends SubsystemBase {
    
    public static CANSparkMax TRANSFER_BELT_MOTOR_1;
    public static CANSparkMax TRANSFER_BELT_MOTOR_2;

    private TransferBelt() {
        TRANSFER_BELT_MOTOR_1 = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_1, MotorType.kBrushless);
        TRANSFER_BELT_MOTOR_2 = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_2, MotorType.kBrushless);
    }

    public static void TransferBelt_SetMotor() {
        TRANSFER_BELT_MOTOR_1.set(Constants.TRANSFER_MOTOR1_RPM);
        TRANSFER_BELT_MOTOR_2.set(Constants.TRANSFER_MOTOR2_RPM);
    }

    public static void TransferBelt_SetMotor_0() {
        TRANSFER_BELT_MOTOR_1.set(0);
        TRANSFER_BELT_MOTOR_2.set(0);
    }

    public static boolean isTransferBelt_running_1() {
        return TRANSFER_BELT_MOTOR_1.get() == Constants.TRANSFER_MOTOR1_RPM;
    }

    public static boolean isTransferBelt_running_2() {
        return TRANSFER_BELT_MOTOR_2.get() == Constants.TRANSFER_MOTOR2_RPM;
    }

    public static boolean isTransferBelt_NOTrunning_1() {
        return TRANSFER_BELT_MOTOR_1.get() == 0;
    }

    public static boolean isTransferBelt_NOTrunning_2() {
        return TRANSFER_BELT_MOTOR_2.get() == 0;
    }
}
