package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class TransferUpright extends SubsystemBase {

// I also need to figure out the conversion factor for the encoder

    public static CANSparkMax TRANSFER_UPRIGHT_MOTOR;
    public static DutyCycleEncoder TRANSFER_UPRIGHT_ENCODER;
    
    public static ColorSensorV3 TRANSFER_UPRIGHT_SENSOR;
    public static final ColorMatch MATCH_YELLOW_CONE = new ColorMatch();
    public static final Color DETECT_YELLOW_CONE = TRANSFER_UPRIGHT_SENSOR.getColor();
    public static final Color YELLOW_CONE = new Color(0.361, 0.524, 0.113);
    public static final ColorMatchResult COLOR_YELLOW_CONE = MATCH_YELLOW_CONE.matchClosestColor(DETECT_YELLOW_CONE);
    
    public TransferUpright() {
        TRANSFER_UPRIGHT_MOTOR = new CANSparkMax(Robotmap.TRANSFER_UPRIGHT_MOTOR, MotorType.kBrushless);
        TRANSFER_UPRIGHT_ENCODER = (DutyCycleEncoder) TRANSFER_UPRIGHT_MOTOR.getEncoder();
        TRANSFER_UPRIGHT_SENSOR = new ColorSensorV3(Port.kMXP);

        MATCH_YELLOW_CONE.addColorMatch(YELLOW_CONE);

        TRANSFER_UPRIGHT_MOTOR.restoreFactoryDefaults();

        TRANSFER_UPRIGHT_MOTOR.setSmartCurrentLimit(Constants.TRANSFER_UPRIGHT_MOTOR_CURRENTLIMIT);
        TRANSFER_UPRIGHT_MOTOR.setInverted(Constants.TRANSFER_UPRIGHT_MOTOR_INVERTED);
        TRANSFER_UPRIGHT_MOTOR.enableVoltageCompensation(Constants.TRANSFER_UPRIGHT_MOTOR_VOLTAGE_COMPENSATION);

        TRANSFER_UPRIGHT_MOTOR.getPIDController().setP(Constants.TRANSFER_UPRIGHT_MOTOR_KP);
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setI(Constants.TRANSFER_UPRIGHT_MOTOR_KI);
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setD(Constants.TRANSFER_UPRIGHT_MOTOR_KD);
        TRANSFER_UPRIGHT_MOTOR.getPIDController().setFF(Constants.TRANSFER_UPRIGHT_MOTOR_KF);
        TRANSFER_UPRIGHT_MOTOR.getEncoder().setPositionConversionFactor(1/100);
    }

    private static TransferUpright TransferM_Upright_Instance = null;

    public static TransferUpright TransferM_Upright_getInstance() {
        if (TransferM_Upright_Instance == null)
        {
            TransferM_Upright_Instance = new TransferUpright();   
        }
        return TransferM_Upright_Instance;
    }

    public static void Transfer_Upright_drive() {
        TRANSFER_UPRIGHT_ENCODER.
    }

    public static void Transfer_Upright_stop() {
        TRANSFER_UPRIGHT_MOTOR.set(0);
    }

    public static boolean is_Transfer_running() {
        return TRANSFER_UPRIGHT_MOTOR.get() != 0;
    }

    public static boolean is_Transfer_Not_running () {
        return TRANSFER_UPRIGHT_MOTOR.get() == 0;
    }
}
