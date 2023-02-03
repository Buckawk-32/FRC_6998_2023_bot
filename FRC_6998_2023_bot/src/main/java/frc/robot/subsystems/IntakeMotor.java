package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robotmap;

public class IntakeMotor extends SubsystemBase {
    
    public static CANSparkMax INTAKE_MOTOR_1;
    public static CANSparkMax INTAKE_MOTOR_2;
    public boolean INTAKE_MOTOR_REVERSE = false;

    public IntakeMotor() {
        INTAKE_MOTOR_1 = new CANSparkMax(Robotmap.INTAKE_MOTOR_1, MotorType.kBrushless);
        INTAKE_MOTOR_2 = new CANSparkMax(Robotmap.INTAKE_MOTOR_2, MotorType.kBrushless);
        
        INTAKE_MOTOR_1.setIdleMode(IdleMode.kBrake);
        INTAKE_MOTOR_2.setIdleMode(IdleMode.kBrake);

        INTAKE_MOTOR_1.setSmartCurrentLimit(25);
        INTAKE_MOTOR_1.setControlFramePeriodMs(20);
        INTAKE_MOTOR_1.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
        INTAKE_MOTOR_1.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
        INTAKE_MOTOR_1.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
        INTAKE_MOTOR_1.setInverted(INTAKE_MOTOR_REVERSE);

        INTAKE_MOTOR_2.setSmartCurrentLimit(25);
        INTAKE_MOTOR_2.setControlFramePeriodMs(20);
        INTAKE_MOTOR_2.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 500);
        INTAKE_MOTOR_2.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 500);
        INTAKE_MOTOR_2.setPeriodicFramePeriod(PeriodicFrame.kStatus2, 500);
        INTAKE_MOTOR_2.setInverted(INTAKE_MOTOR_REVERSE);
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
        INTAKE_MOTOR_1.set(INTAKE_MOTOR_RPM);
        INTAKE_MOTOR_2.set(INTAKE_MOTOR_RPM);
    }
}
