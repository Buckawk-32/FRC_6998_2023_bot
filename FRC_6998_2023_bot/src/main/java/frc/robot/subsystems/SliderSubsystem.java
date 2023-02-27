package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class SliderSubsystem extends SubsystemBase {
    
    public static CANSparkMax SLIDER_LENTGH_MOTOR_1;
    public static CANSparkMax SLIDER_LENTGH_MOTOR_2;

    public static RelativeEncoder SLIDER_LENGTH_ENCODER_1;
    public static RelativeEncoder SLIDER_LENGTH_ENCODER_2;

    /**
     * todo: Change the Conversion factor, and test for PID
     **/

    public SliderSubsystem() {
        SLIDER_LENTGH_MOTOR_1 = new CANSparkMax(Robotmap.SLIDER_LENTGH_MOTOR_1_ID, MotorType.kBrushless);
        SLIDER_LENTGH_MOTOR_2 = new CANSparkMax(Robotmap.SLIDER_LENTGH_MOTOR_2_ID, MotorType.kBrushless);

        SLIDER_LENGTH_ENCODER_1 = SLIDER_LENTGH_MOTOR_1.getEncoder();
        SLIDER_LENGTH_ENCODER_2 = SLIDER_LENTGH_MOTOR_2.getEncoder();

        // --------------------------------------------------------------------

        SLIDER_LENTGH_MOTOR_1.restoreFactoryDefaults();
        SLIDER_LENTGH_MOTOR_1.setSmartCurrentLimit(Constants.SLIDER_LENTGH_MOTOR_CURRENTLIMIT);
        SLIDER_LENTGH_MOTOR_1.enableVoltageCompensation(Constants.SLIDER_LENTGH_MOTOR_VOLTAGE_COMPENSATION);

        SLIDER_LENTGH_MOTOR_1.setIdleMode(Constants.SLIDER_LENGTH_IDLEMODE);

        SLIDER_LENTGH_MOTOR_1.getPIDController().setP(Constants.SLIDER_LENGTH_KP);
        SLIDER_LENTGH_MOTOR_1.getPIDController().setI(Constants.SLIDER_LENGTH_KI);
        SLIDER_LENTGH_MOTOR_1.getPIDController().setD(Constants.SLIDER_LENGTH_KD);
        SLIDER_LENTGH_MOTOR_1.getPIDController().setFF(Constants.SLIDER_LENGTH_KF);

        SLIDER_LENGTH_ENCODER_1.setPosition(0);
        SLIDER_LENGTH_ENCODER_2.setPosition(0);
        
        SLIDER_LENGTH_ENCODER_1.setPositionConversionFactor(0);
        SLIDER_LENGTH_ENCODER_2.setPositionConversionFactor(0);
        SLIDER_LENGTH_ENCODER_1.setVelocityConversionFactor(0);
        SLIDER_LENGTH_ENCODER_2.setVelocityConversionFactor(0);

        SLIDER_LENTGH_MOTOR_2.follow(SLIDER_LENTGH_MOTOR_1);
    }

    public void SLIDER_move(double length) {
        SLIDER_LENTGH_MOTOR_1.getPIDController().setReference(length, ControlType.kPosition);
    }
}
