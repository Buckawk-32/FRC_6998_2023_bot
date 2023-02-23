package frc.robot.commands.Drive;

import java.util.function.BooleanSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;

public class AutoBalanceCommand extends CommandBase {
    
    private SwerveSubsystem swerveSubsystem;

    private final PIDController AutoBalancePID;

    BooleanSupplier StartAutoBalance;

    BooleanSupplier ESTOP;

    private AHRS navx;

    private double currentAngle;

    private double CorrectPitch;

    public AutoBalanceCommand(SwerveSubsystem swerveSubsystem, double kp, double ki, double kd, BooleanSupplier StartAutoBalance, AHRS navx, BooleanSupplier ESTOP) {
        this.swerveSubsystem = swerveSubsystem;
        addRequirements(swerveSubsystem);

        AutoBalancePID = new PIDController(kp, ki, kd);
        this.StartAutoBalance = StartAutoBalance;
        this.ESTOP = ESTOP;
    }

    @Override
    public void initialize() {
        swerveSubsystem.StopMotors();
        AutoBalancePID.setSetpoint(0);
        navx.reset();
    }

    @Override
    public void execute()
    {
        boolean GetStartAutoBalance = StartAutoBalance.getAsBoolean();
        boolean ESTOP_Start = ESTOP.getAsBoolean();

        if (GetStartAutoBalance == true) {
            currentAngle = navx.getPitch();
            
            CorrectPitch = AutoBalancePID.calculate(currentAngle, Constants.BALANCE_DEG_GOAL);

            swerveSubsystem.drive(new Translation2d(CorrectPitch, 0), 0, true, true);
        } else if (ESTOP_Start == true) {
            swerveSubsystem.StopMotors();
        }
    }

    @Override
    public boolean isFinished() {
        return AutoBalancePID.atSetpoint();
    }
 }
