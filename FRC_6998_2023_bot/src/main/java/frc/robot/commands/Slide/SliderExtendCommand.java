package frc.robot.commands.Slide;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SliderSubsystem;

public class SliderExtendCommand extends CommandBase{
      
    private SliderSubsystem sliderSubsystem;
    private BooleanSupplier Slider_Button_up;
    private BooleanSupplier Slider_Button_down;
    private BooleanSupplier Slider_Button_down_ALL;

    public SliderExtendCommand(SliderSubsystem sliderSubsystem, BooleanSupplier Slider_Button_up, BooleanSupplier Slider_Button_down, BooleanSupplier Slider_Button_down_ALL) {
        this.sliderSubsystem = sliderSubsystem;
        addRequirements(sliderSubsystem);

        this.Slider_Button_up = Slider_Button_up;
        this.Slider_Button_down = Slider_Button_down;
        this.Slider_Button_down_ALL = Slider_Button_down_ALL;
    }

    /**
     * todo: Need to check the SLIDER_move() function, and testing, and need to check the lenght of Mid and High Node length
     * ? Idk wheter it will work
     */

    @Override
    public void execute() {
        boolean Start_Slider_Button_up = Slider_Button_up.getAsBoolean();
        boolean Start_Slider_Button_down = Slider_Button_down.getAsBoolean();
        boolean End_Slider = Slider_Button_down_ALL.getAsBoolean();

        if (Start_Slider_Button_down) {
            sliderSubsystem.SLIDER_move(Constants.SLIDER_MID_NODE_LENGTH);
        } else if (Start_Slider_Button_up) {
            sliderSubsystem.SLIDER_move(Constants.SLIDER_HIGH_NODE_LENGTH);
        } else if (End_Slider) {
            sliderSubsystem.SLIDER_move(0);
        }
    }
}
