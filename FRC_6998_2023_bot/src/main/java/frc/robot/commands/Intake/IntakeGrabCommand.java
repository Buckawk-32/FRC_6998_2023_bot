package frc.robot.commands.Intake;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsytem;

public class IntakeGrabCommand extends CommandBase{
    
    private IntakeSubsytem intakeSubsytem;
    private BooleanSupplier INTAKE_START_GRAB;
    private BooleanSupplier INTAKE_END_GRAB;

    public IntakeGrabCommand(IntakeSubsytem intakeSubsytem, BooleanSupplier INTAKE_START_GRAB, BooleanSupplier INTAKE_END_GRAB) {
        this.intakeSubsytem = intakeSubsytem;
        addRequirements(intakeSubsytem);

        this.INTAKE_START_GRAB = INTAKE_START_GRAB;
        this.INTAKE_END_GRAB = INTAKE_END_GRAB;
    }

    @Override
    public void execute() {
        boolean INTAKE_START_GRAB_BUTTON = INTAKE_START_GRAB.getAsBoolean();
        boolean INTAKE_END_GRAB_BUTTON = INTAKE_END_GRAB.getAsBoolean();

        if (INTAKE_START_GRAB_BUTTON == true) {
            intakeSubsytem.INTAKE_GRIPPER_GRAB();
        } else if (INTAKE_END_GRAB_BUTTON == true) {
            intakeSubsytem.INTAKE_GRIPPER_RELEASE();
        }
    }
}
