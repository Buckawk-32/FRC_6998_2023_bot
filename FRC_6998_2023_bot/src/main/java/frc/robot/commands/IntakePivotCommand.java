package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakePivotCommand extends CommandBase {
    
    private IntakeSubsystem intakeSubsystem;
    private DoubleSupplier INTAKE_DOWN_SUP;
    private DoubleSupplier INTAKE_UP_SUP;
    private BooleanSupplier INTAKE_DRIVE_CONE;
    private BooleanSupplier INTAKE_RELEASE_CONE;
    private BooleanSupplier INTAKE_DRIVE_BOX;
    private DoubleSupplier INTAKE_POS_SUP;

    public IntakePivotCommand(IntakeSubsystem intakeSubsystem, DoubleSupplier INTAKE_DOWN_SUP, DoubleSupplier INTAKE_UP_SUP, BooleanSupplier INTAKE_DRIVE_CONE, BooleanSupplier INTAKE_RELEASE_CONE, BooleanSupplier INTAKE_DRIVE_BOX, DoubleSupplier INTAKE_POS_SUP) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);

        this.INTAKE_DOWN_SUP = INTAKE_DOWN_SUP;
        this.INTAKE_UP_SUP = INTAKE_UP_SUP;
        this.INTAKE_DRIVE_CONE = INTAKE_DRIVE_CONE;
        this.INTAKE_RELEASE_CONE = INTAKE_RELEASE_CONE;
        this.INTAKE_DRIVE_BOX = INTAKE_DRIVE_BOX;
        this.INTAKE_POS_SUP = INTAKE_POS_SUP;
    }

    // might need to set deadband
    @Override
    public void execute() {

        // --------------------------------------------------------------------
        
        boolean INTAKE_DRIVE_CONE_TRUE = INTAKE_DRIVE_CONE.getAsBoolean();

        if (INTAKE_DRIVE_CONE_TRUE == true) {
            intakeSubsystem.Intake_Cone_Hold(Constants.INTAKE_MOTOR_CONE_RPM);
        } else if (INTAKE_DRIVE_CONE_TRUE == false) {
            intakeSubsystem.Intake_Cone_Stop();
        }

        boolean INTAKE_RELEASE_CONE_TRUE = INTAKE_RELEASE_CONE.getAsBoolean();

        if (INTAKE_RELEASE_CONE_TRUE == true) {
            intakeSubsystem.Intake_Cone_Release(-Constants.INTAKE_MOTOR_CONE_RPM);
        } else if (INTAKE_DRIVE_CONE_TRUE == true) {
            intakeSubsystem.Intake_Cone_Release(0);
        }

        // --------------------------------------------------------------------
        
        boolean INTAKE_DRIVE_BOX_TRUE = INTAKE_DRIVE_BOX.getAsBoolean();

        if (INTAKE_DRIVE_BOX_TRUE == true) {
            intakeSubsystem.Intake_Box_Shoot(Constants.INTAKE_MOTOR_BOX_RPM);
        }

        // --------------------------------------------------------------------

        double INTAKE_ROT_DOWN = INTAKE_DOWN_SUP.getAsDouble();

        intakeSubsystem.Intake_Rotate_Down(INTAKE_ROT_DOWN);

        double INTAKE_ROT_UP = INTAKE_UP_SUP.getAsDouble();

        intakeSubsystem.Intake_Rotate_Up(INTAKE_ROT_UP);

        // --------------------------------------------------------------------

        double INTAKE_POS = MathUtil.applyDeadband(INTAKE_POS_SUP.getAsDouble(), Constants.INTAKE_POS_DEADBAND);

        intakeSubsystem.Intake_Position_Drive(INTAKE_POS);
    }
    
}
