package frc.robot.commands.Intake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsytem;

public class IntakeRotateCommand extends CommandBase{
    
    private IntakeSubsytem intakeSubsytem;
    private DoubleSupplier intake_Rotate;

    public IntakeRotateCommand(IntakeSubsytem intakeSubsytem, DoubleSupplier intake_Rotate) {
        this.intakeSubsytem = intakeSubsytem;
        addRequirements(intakeSubsytem);

        this.intake_Rotate= intake_Rotate;
    }

    @Override
    public void execute() {
        double intake_Rotate_control = MathUtil.applyDeadband(intake_Rotate.getAsDouble(), Constants.INTAKE_JOYSTICK_DEADBAND);

        intakeSubsytem.INTAKE_ROTATE(intake_Rotate_control);
    }
}
