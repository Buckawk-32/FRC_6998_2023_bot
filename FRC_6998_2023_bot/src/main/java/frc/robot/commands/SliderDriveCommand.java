package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SliderSubsystem;

public class SliderDriveCommand extends CommandBase {
    
    private SliderSubsystem sliderSubsystem;
    private DoubleSupplier SLIDER_LENGTH_SUP;

    public SliderDriveCommand(SliderSubsystem sliderSubsystem, DoubleSupplier SLIDER_LENGTH_SUP) {
        this.sliderSubsystem = sliderSubsystem;
        addRequirements(sliderSubsystem);

        this.SLIDER_LENGTH_SUP = SLIDER_LENGTH_SUP;
    }

    @Override
    public void execute() {
        double SLIDER_LENGTH_VAL = MathUtil.applyDeadband(SLIDER_LENGTH_SUP.getAsDouble(), Constants.SLIDER_DEADBAND);

        sliderSubsystem.Slider_Extend(SLIDER_LENGTH_VAL);
    }
    
}
