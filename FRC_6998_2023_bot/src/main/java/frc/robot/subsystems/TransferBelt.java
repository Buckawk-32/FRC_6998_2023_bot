package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class TransferBelt extends SubsystemBase {
    
    public static CANSparkMax   TRANSFER_BELT_MOTOR_FRONT;
    public static CANSparkMax TRANSFER_BELT_MOTOR_BACK;

    private TransferBelt() {
        TRANSFER_BELT_MOTOR_FRONT = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_FRONT, MotorType.kBrushless);
        TRANSFER_BELT_MOTOR_BACK = new CANSparkMax(Robotmap.TRANSFER_BELT_MOTOR_BACK, MotorType.kBrushless);

    
    }

    public static void TransferBelt_SetMotor() {
    }

    public static void TransferBelt_SetMotor_0() {
        TRANSFER_BELT_MOTOR_FRONT.set(0);
        TRANSFER_BELT_MOTOR_BACK.set(0);
    }

    public static boolean isTransferBelt_running_1() {
        return  TRANSFER_BELT_MOTOR_FRONT.get() == Constants.TRANSFER_MOTOR1_RPM;
    }

    public static boolean isTransferBelt_running_2() {
        return TRANSFER_BELT_MOTOR_BACK.get() == Constants.TRANSFER_MOTOR2_RPM;
    }

    public static boolean isTransferBelt_NOTrunning_1() {
        return  TRANSFER_BELT_MOTOR_FRONT.get() == 0;
    }

    public static boolean isTransferBelt_NOTrunning_2() {
        return TRANSFER_BELT_MOTOR_BACK.get() == 0;
    }

    
}
