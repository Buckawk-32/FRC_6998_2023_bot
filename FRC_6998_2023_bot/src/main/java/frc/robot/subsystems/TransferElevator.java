package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robotmap;

public class TransferElevator extends SubsystemBase {
    
    public static DoubleSolenoid TRANSFER_ELE;
    
    private TransferElevator() {
        TRANSFER_ELE = new DoubleSolenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.TRANSFER_ELE_ENGAGE, Robotmap.TRANSFER_ELE_DISENGAGE);
    }

    public static void extendEle() {
        TRANSFER_ELE.set(DoubleSolenoid.Value.kForward);
    }

    public static void retractEle() {
        TRANSFER_ELE.set(DoubleSolenoid.Value.kReverse);
    }

    public static boolean isEleExtended() {
        return TRANSFER_ELE.get() == DoubleSolenoid.Value.kForward;
    }

    public static boolean isEleRetracted() {
        return TRANSFER_ELE.get() == DoubleSolenoid.Value.kReverse;
    }
}
