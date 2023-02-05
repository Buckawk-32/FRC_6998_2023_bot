package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robotmap;

public class IntakePivot extends SubsystemBase{
    private static DoubleSolenoid INTAKE_PIVOT_1;
    private static DoubleSolenoid INTAKE_PIVOT_2;

    private static IntakePivot IntakePivot_instance = null;

    private IntakePivot() {
        INTAKE_PIVOT_1 = new DoubleSolenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.INTAKE_PIVOT_1_ENGAGE, Robotmap.INTAKE_PIVOT_1_DISENGAGE);
        INTAKE_PIVOT_2 = new DoubleSolenoid(Robotmap.PNEUMATICS_MODULE_TYPE, Robotmap.INTAKE_PIVOT_2_ENGAGE, Robotmap.INTAKE_PIVOT_2_DISENGAGE);
    }

    public static IntakePivot getInstance() {
        if (IntakePivot_instance == null)
        {
            IntakePivot_instance = new IntakePivot();
        }
        return IntakePivot_instance;
    }

    public static void extendIntake() {
        INTAKE_PIVOT_1.set(DoubleSolenoid.Value.kForward);
        INTAKE_PIVOT_2.set(DoubleSolenoid.Value.kForward);
    }

    public static void retractIntake() {
        INTAKE_PIVOT_1.set(DoubleSolenoid.Value.kReverse);
        INTAKE_PIVOT_2.set(DoubleSolenoid.Value.kReverse);
    }

    public static boolean isIntakeExtended_PIVOT1() {
        return INTAKE_PIVOT_1.get() == DoubleSolenoid.Value.kForward;   
    }

    public static boolean isIntakeExtended_PIVOT2() {
        return INTAKE_PIVOT_2.get() == DoubleSolenoid.Value.kForward;
    }

    public static boolean isIntakeRetracted_PIVOT1() {
        return INTAKE_PIVOT_1.get() == DoubleSolenoid.Value.kReverse;
    }

    public static boolean isIntakeRetracted_PIVOT2() {
        return INTAKE_PIVOT_2.get() == DoubleSolenoid.Value.kReverse;
    }
}
