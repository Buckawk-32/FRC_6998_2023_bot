package frc.robot.subsystems;

import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class IntakeMotor extends SubsystemBase {
     
    public static CANSparkMax INTAKE_MOTOR_RIGHT;
    public static CANSparkMax INTAKE_MOTOR_LEFT;
    public boolean INTAKE_MOTOR_REVERSE = false;

    public IntakeMotor() {
        INTAKE_MOTOR_LEFT = new CANSparkMax(Robotmap.INTAKE_MOTOR_LEFT, MotorType.kBrushless);
        INTAKE_MOTOR_RIGHT = new CANSparkMax(Robotmap.INTAKE_MOTOR_RIGHT, MotorType.kBrushless);
        
        INTAKE_MOTOR_LEFT.setIdleMode(IdleMode.kBrake);
        INTAKE_MOTOR_RIGHT.setIdleMode(IdleMode.kBrake);

        INTAKE_MOTOR_LEFT.setSmartCurrentLimit(Constants.INTAKE_MOTOR_CURRENTLIMIT);
        INTAKE_MOTOR_LEFT.setInverted(Constants.INTAKE_LEFT_MOTOR_INVERTED);
        INTAKE_MOTOR_LEFT.enableVoltageCompensation(Constants.INTAKE_VOLTAGE_COMPENSATION);
        INTAKE_MOTOR_LEFT.getPIDController().setP(Constants.INTAKE_MOTOR_KP);
        INTAKE_MOTOR_LEFT.getPIDController().setI(Constants.INTAKE_MOTOR_KI);
        INTAKE_MOTOR_LEFT.getPIDController().setD(Constants.INTAKE_MOTOR_KD);

        INTAKE_MOTOR_RIGHT.enableVoltageCompensation(Constants.INTAKE_MOTOR_CURRENTLIMIT)
        INTAKE_MOTOR_RIGHT.setSmartCurrentLimit(Constants.INTAKE_MOTOR_CURRENTLIMIT);
        INTAKE_MOTOR_RIGHT.getPIDController().setP(Constants.INTAKE_MOTOR_KP);
        INTAKE_MOTOR_RIGHT.getPIDController().setI(Constants.INTAKE_MOTOR_KI);
        INTAKE_MOTOR_RIGHT.getPIDController().setD(Constants.INTAKE_MOTOR_KD);
        INTAKE_MOTOR_RIGHT.getPIDController().setFF(Constants.INTAKE_MOTOR_KF);
        INTAKE_MOTOR_RIGHT.getEncoder().setVelocityConversionFactor(1/15);
        INTAKE_MOTOR_RIGHT.setInverted(Constants.INTAKE_RIGHT_MOTOR_INVERTED);
    }

    private static IntakeMotor IntakeMotors_instance = null;
    
    public static IntakeMotor IntakeM_getInstance() {
        if (IntakeMotors_instance == null)
        {
            IntakeMotors_instance = new IntakeMotor();
        }
        return IntakeMotors_instance;
    }

    public static void IntakeSpeed_Motor(double INTAKE_MOTOR_RPM) {
        INTAKE_MOTOR_LEFT.set(INTAKE_MOTOR_RPM);
        INTAKE_MOTOR_RIGHT.set(INTAKE_MOTOR_RPM);
    }
}
