package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class SliderSubsystem extends SubsystemBase {
    
    public static CANSparkMax SLIDER_MOTOR_LENGTH;

    public SliderSubsystem() {
        SLIDER_MOTOR_LENGTH = new CANSparkMax(Robotmap.MOTOR_SLIDER_LENGTH_ID, MotorType.kBrushless);

        // ---------------------------------------------------------------------

        SLIDER_MOTOR_LENGTH.restoreFactoryDefaults();
        SLIDER_MOTOR_LENGTH.setSmartCurrentLimit(Constants.SLIDER_MOTOR_LENGTH_CURRENTLIMIT);
        SLIDER_MOTOR_LENGTH.enableVoltageCompensation(Constants.SLIDER_MOTOR_LENGTH_VOLTAGE_COMPENSATION);
        
        SLIDER_MOTOR_LENGTH.setIdleMode(Constants.SLIDER_MOTOR_LENGTH_IDLEMODE);

        SLIDER_MOTOR_LENGTH.getPIDController().setP(Constants.SLIDER_MOTOR_LENGTH_KP);
        SLIDER_MOTOR_LENGTH.getPIDController().setI(Constants.SLIDER_MOTOR_LENGTH_KI);
        SLIDER_MOTOR_LENGTH.getPIDController().setD(Constants.SLIDER_MOTOR_LENGTH_KD);
        SLIDER_MOTOR_LENGTH.getPIDController().setFF(Constants.SLIDER_MOTOR_LENGTH_KF);

        // Need to change the conversion factor
        SLIDER_MOTOR_LENGTH.getEncoder().setPositionConversionFactor(0);
        SLIDER_MOTOR_LENGTH.getEncoder().setVelocityConversionFactor(0);
    }

    private static SliderSubsystem Slider_instance= null;

    public static SliderSubsystem Slider_GetInstance() {
        if (Slider_instance == null) 
        {
            Slider_instance = new SliderSubsystem();
        }
        return Slider_instance;
    }

    public static void Slider_Extend(double SLIDER_MOTOR_RPM) {
        SLIDER_MOTOR_LENGTH.getPIDController().setReference(SLIDER_MOTOR_RPM, ControlType.kSmartMotion);
    }

    public static void Slider_Retract(double SLIDER_MOTOR_RPM) {
        SLIDER_MOTOR_LENGTH.getPIDController().setReference(-SLIDER_MOTOR_RPM, ControlType.kSmartMotion);
    }

    public static boolean Slider_Running() {
        return SLIDER_MOTOR_LENGTH.get() != 0;
    }
}
