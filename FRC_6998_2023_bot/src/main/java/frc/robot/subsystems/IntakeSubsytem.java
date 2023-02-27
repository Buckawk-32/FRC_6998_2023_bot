package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robotmap;

public class IntakeSubsytem extends SubsystemBase{
    
    public static CANSparkMax INTAKE_ROTATION_MOTOR;

    public static Solenoid INTAKE_GRIPPER_SOLENOID_1;
    public static Solenoid INTAKE_GRIPPER_SOLENOID_2;

    public static RelativeEncoder INTAKE_ROTATION_ENCODER;
    
    /**
     * todo: Change the conversion factor, and test the PID
     */

    
    public IntakeSubsytem() {
        INTAKE_ROTATION_MOTOR = new CANSparkMax(Robotmap.INTAKE_ROTATION_MOTOR_ID, MotorType.kBrushless);

        INTAKE_ROTATION_ENCODER = INTAKE_ROTATION_MOTOR.getEncoder();

        INTAKE_GRIPPER_SOLENOID_1 = new Solenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.INTAKE_GRIPPER_SOLENOID_1_CHANNEL);
        INTAKE_GRIPPER_SOLENOID_2 = new Solenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.INTAKE_GRIPPER_SOLENOID_2_CHANNEL);

        // --------------------------------------------------------------------

        INTAKE_ROTATION_MOTOR.restoreFactoryDefaults();
        INTAKE_ROTATION_MOTOR.setSmartCurrentLimit(Constants.INTAKE_ROTATION_MOTOR_CURRENTLIMIT);
        INTAKE_ROTATION_MOTOR.enableVoltageCompensation(Constants.INTAKE_ROTATION_MOTOR_VOLTAGE_COMPENSATION);

        INTAKE_ROTATION_MOTOR.setIdleMode(Constants.INTAKE_ROTATION_MOTOR_IDLEMODE);

        INTAKE_ROTATION_MOTOR.getPIDController().setP(Constants.INTAKE_ROTATION_MOTOR_KP);
        INTAKE_ROTATION_MOTOR.getPIDController().setI(Constants.INTAKE_ROTATION_MOTOR_KI);
        INTAKE_ROTATION_MOTOR.getPIDController().setD(Constants.INTAKE_ROTATION_MOTOR_KD);
        INTAKE_ROTATION_MOTOR.getPIDController().setFF(Constants.INTAKE_ROTATION_MOTOR_KF);

        INTAKE_ROTATION_ENCODER.setPositionConversionFactor(0);
        INTAKE_ROTATION_ENCODER.setVelocityConversionFactor(0);

        // --------------------------------------------------------------------
    }

    public void INTAKE_GRIPPER_GRAB() {
        INTAKE_GRIPPER_SOLENOID_1.set(true);
        INTAKE_GRIPPER_SOLENOID_2.set(true);
    }

    public void INTAKE_GRIPPER_RELEASE() {
        INTAKE_GRIPPER_SOLENOID_1.set(false);
        INTAKE_GRIPPER_SOLENOID_2.set(false);
    }

    public void INTAKE_ROTATE(double deg) {
        INTAKE_ROTATION_MOTOR.getPIDController().setReference(deg, ControlType.kSmartMotion);
    }
}
