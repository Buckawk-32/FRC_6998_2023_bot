package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robotmap;

public class ArmGripper extends SubsystemBase {
    
    public static DoubleSolenoid ARM_GIPPER;

    private static ArmGripper ArmGripper_instance = null;

    public ArmGripper() {
        ARM_GIPPER = new DoubleSolenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.ARM_GRIPPER_ENGAGE, Robotmap.ARM_GRIPPER_DISENGAGE);
    }

    public static ArmGripper ArmGipper_getInstance() {
        if (ArmGripper_instance == null)
        {
            ArmGripper_instance = new ArmGripper();
        }
        return ArmGripper_instance;
    }

    public static void ArmGripper_Extend() {
        ARM_GIPPER.set(DoubleSolenoid.Value.kForward);
    }

    public static void ArmGripper_Retract() {
        ARM_GIPPER.set(DoubleSolenoid.Value.kReverse);
    }

    public static boolean isArmGripper_Extended() {
        return ARM_GIPPER.get() == DoubleSolenoid.Value.kForward;
    }

    public static boolean isArmGripper_Retracted() {
        return ARM_GIPPER.get() == DoubleSolenoid.Value.kReverse;
    }
}
