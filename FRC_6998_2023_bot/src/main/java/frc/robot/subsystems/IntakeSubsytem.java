package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Robotmap;

public class IntakeSubsytem extends SubsystemBase{
    
    public static CANSparkMax INTAKE_ROTATION_MOTOR;

    public static DoubleSolenoid INTAKE_GRIPPER_SOLENOID_1;
    public static DoubleSolenoid INTAKE_GRIPPER_SOLENOID_2;

    public IntakeSubsytem() {
        INTAKE_ROTATION_MOTOR = new CANSparkMax(Robotmap.INTAKE_ROTATION_MOTOR_ID, MotorType.kBrushless);

        INTAKE_GRIPPER_SOLENOID_1 = new DoubleSolenoid(Robotmap.PNEUMATICS_MODULE_TYPE, 0, 0)
    }
}
