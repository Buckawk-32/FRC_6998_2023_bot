package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;

public class SwerveDriveCommand extends CommandBase {
    
    private SwerveSubsystem swerveSubsystem;
    private DoubleSupplier translationSup;
    private DoubleSupplier strafeSup;
    private DoubleSupplier rotationSup;
    private BooleanSupplier robotCentricSup;

    public SwerveDriveCommand(SwerveSubsystem swerveSubsystem, DoubleSupplier translationSup, DoubleSupplier strafeSup, DoubleSupplier rotationSup, BooleanSupplier robotCentricSup) {
        this.swerveSubsystem = swerveSubsystem;
        addRequirements(swerveSubsystem);

        this.translationSup = translationSup;
        this.strafeSup = strafeSup;
        this.rotationSup = rotationSup;
        this.robotCentricSup = robotCentricSup;
    } 

    @Override
    public void execute() {
        double translationVal = MathUtil.applyDeadband(translationSup.getAsDouble(), Constants.SWERVE_DRIVE_JOYSTICK_DEADBAND);
        double strafeVal = MathUtil.applyDeadband(strafeSup.getAsDouble(), Constants.SWERVE_DRIVE_JOYSTICK_DEADBAND);
        double rotationVal = MathUtil.applyDeadband(rotationSup.getAsDouble(), Constants.SWERVE_DRIVE_JOYSTICK_DEADBAND);

        swerveSubsystem.drive(
            new Translation2d(translationVal, strafeVal).times(Constants.SWERVE_MAX_SPEED),
            rotationVal * Constants.SWERVE_MAX_ANGULAR_VELOCITY,
            !robotCentricSup.getAsBoolean(),
            true
        );
    }
}
