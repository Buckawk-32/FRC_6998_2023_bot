package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robotmap;

public class IntakeMotor extends SubsystemBase {
    
    public static CANSparkMax INTAKE_MOTOR;
    public boolean INTAKE_MOTOR_REVERSE = false;

    public IntakeMotor() {
        INTAKE_MOTOR = new CANSparkMax(Robotmap.INTAKE_MOTOR, MotorType.kBrushless);
        
        INTAKE_MOTOR.setIdleMode(IdleMode.kBrake);

        INTAKE_MOTOR.setSmartCurrentLimit(25);
        INTAKE_MOTOR.setControlFramePeriodMs(20);
        INTAKE_MOTOR.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
        INTAKE_MOTOR.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
        INTAKE_MOTOR.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
        INTAKE_MOTOR.setInverted(INTAKE_MOTOR_REVERSE);
    }

    private static IntakeMotor IntakeMotors_instance = null;
    
    public static IntakeMotor getInstance() {
        if (IntakeMotors_instance == null)
        {
            IntakeMotors_instance = new IntakeMotor();
        }
        return IntakeMotors_instance;
    }

    public static void IntakeSpeed_Motor(double INTAKE_MOTOR_RPM)
    {
        IntakeMotor.INTAKE_MOTOR.set(INTAKE_MOTOR_RPM);
    }
}
