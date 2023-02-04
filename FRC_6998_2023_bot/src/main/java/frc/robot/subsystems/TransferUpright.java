package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class TransferUpright extends SubsystemBase {

    public static CANSparkMax TRANSFER_UPRIGHT_MOTOR;
    public boolean TRANSFER_UPRIGHT_MOTOR_REVERSE = false;
    public static AbsoluteEncoder TRANSFER_UPRIGHT_ENCODER;

    public TransferUpright() {
        TRANSFER_UPRIGHT_MOTOR = new CANSparkMax(Robotmap.TRANSFER_UPRIGHT_MOTOR, MotorType.kBrushless);

        TRANSFER_UPRIGHT_MOTOR.setIdleMode(IdleMode.kBrake);

        TRANSFER_UPRIGHT_MOTOR.setSmartCurrentLimit(25);
        TRANSFER_UPRIGHT_MOTOR.setInverted(TRANSFER_UPRIGHT_MOTOR_REVERSE);

        TRANSFER_UPRIGHT_MOTOR.getPIDController().setP(Constants.TRANSFER_UPRIGHT_MOTOR_KP);
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setI(Constants.TRANSFER_UPRIGHT_MOTOR_KI);
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setD(Constants.TRANSFER_UPRIGHT_MOTOR_KD);
    }
    
    private static TransferUpright TransferM_Upright_Instance = null;

    public static TransferUpright TransferM_Upright_getInstance() {
        if (TransferM_Upright_Instance == null)
        {
            TransferM_Upright_Instance = new TransferUpright();   
        }
        return TransferM_Upright_Instance;
    }

    public static void Transfer_Motor_drive_for() {
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setReference(1, ControlType.kSmartMotion);
    }

    public static void Transfer_Motor_drive_rev() {
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setReference(-1, ControlType.kSmartMotion);
    }

    public static void Transfer_Motor_stop() {
        TRANSFER_UPRIGHT_MOTOR.set(0);
    }

    public static boolean is_Transfer_running() {
        return TRANSFER_UPRIGHT_MOTOR.get() != 0;
    }

    public static boolean is_Transfer_Not_running () {
        return TRANSFER_UPRIGHT_MOTOR.get() == 0;
    }


}
