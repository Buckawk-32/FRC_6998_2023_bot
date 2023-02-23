package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.util.SwerveTypeConstants;
import frc.robot.Constants;
import frc.robot.Robotmap;
import frc.robot.SwerveModule;

public class SwerveSubsystem extends SubsystemBase {
    
    public SwerveDriveOdometry sDriveOdometry;
    public SwerveModule[] mSwerveModules;
    public AHRS navX;

    public SwerveSubsystem() {
        navX = new AHRS(SerialPort.Port.kMXP);
        navX.reset();

        mSwerveModules = new SwerveModule[] {
            new SwerveModule(
                0, SwerveTypeConstants.SDSMK4I_L1(),
                Robotmap.SWERVE_LEFTFRONT_DRIVEMOTOR,Robotmap.SWERVE_LEFTFRONT_ANGLEMOTOR,Robotmap.SWERVE_LEFTFRONT_CANCODER,
                Constants.SWERVE_LEFTFRONT_OFFSET),

            new SwerveModule(
                1, SwerveTypeConstants.SDSMK4I_L1(),
                Robotmap.SWERVE_LEFTREAR_DRIVEMOTOR,Robotmap.SWERVE_LEFTREAR_ANGLEMOTOR,Robotmap.SWERVE_LEFTREAR_CANCODER,
                Constants.SWERVE_LEFTREAR_OFFSET),
            new SwerveModule(
                2, SwerveTypeConstants.SDSMK4I_L1(),
                Robotmap.SWERVE_RIGHTFRONT_DRIVEMOTOR,Robotmap.SWERVE_RIGHTFRONT_ANGLEMOTOR,Robotmap.SWERVE_RIGHTFRONT_CANCODER,
                Constants.SWERVE_RIGHTFRONT_OFFSET),
            new SwerveModule(
                3, SwerveTypeConstants.SDSMK4I_L1(),
                Robotmap.SWERVE_RIGHTREAR_DRIVEMOTOR,Robotmap.SWERVE_RIGHTREAR_ANGLEMOTOR,Robotmap.SWERVE_RIGHTREAR_CANCODER,
                Constants.SWERVE_RIGHTREAR_OFFSET)
        };
        
        Timer.delay(1.0);
        resetModulesToAbsolute();

        sDriveOdometry = new SwerveDriveOdometry(Constants.S_DRIVE_KINEMATICS, getYaw(), getModulePositions());
    }

    public void drive(Translation2d translation, double rotation, boolean fieldRelative, boolean isOpenLoop) {
        SwerveModuleState[] swerveModuleStates = 
            Constants.S_DRIVE_KINEMATICS.toSwerveModuleStates(
                fieldRelative ? ChassisSpeeds.fromFieldRelativeSpeeds(
                    translation.getX(),
                    translation.getY(),
                    rotation,
                    getYaw()
                )
                : new ChassisSpeeds(
                    translation.getX(),
                    translation.getY(),
                    rotation)
            );
        SwerveDriveKinematics.desaturateWheelSpeeds(swerveModuleStates, Constants.SWERVE_MAX_SPEED);

        for(SwerveModule mod : mSwerveModules) {
            mod.setDesiredState(swerveModuleStates[mod.moduleNumber], isOpenLoop);
        }
    }

    public void setModuleStates(SwerveModuleState[] desiredStates) {
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, Constants.SWERVE_MAX_SPEED);

        for(SwerveModule mod : mSwerveModules) { 
            mod.setDesiredState(desiredStates[mod.moduleNumber], false);
        }
    }

    public Pose2d getPose() {
        return sDriveOdometry.getPoseMeters();
    }

    public void resetOdometry (Pose2d pose) {
        sDriveOdometry.resetPosition(getYaw(), getModulePositions(), pose);
    }

    public SwerveModuleState [] getModuleStates() {
        SwerveModuleState[] states = new SwerveModuleState[4];
        for (SwerveModule mod : mSwerveModules) {
            states[mod.moduleNumber] = mod.getState();
        }
        return states;
    }

    public SwerveModulePosition[] getModulePositions() {
        SwerveModulePosition[] positions = new SwerveModulePosition[4];
        for (SwerveModule mod : mSwerveModules) {
            positions[mod.moduleNumber] = mod.getPosition();
        }
        return positions;
    }

    public void zeroGyro() {
        navX.reset();
    }

    public Rotation2d getYaw() {
        return (Constants.NAVX_INVERTED) ? Rotation2d.fromDegrees(360 - navX.getYaw()) : Rotation2d.fromDegrees(navX.getYaw());
    }

    public void StopMotors() {
        
    }

    public void resetModulesToAbsolute() {
        for(SwerveModule mod : mSwerveModules) {
            mod.resetToAbsolute();
        }
    }

    @Override
    public void periodic() {
        sDriveOdometry.update(getYaw(), getModulePositions());

        for(SwerveModule mod : mSwerveModules) {
            SmartDashboard.putNumber("Mod" + mod.moduleNumber + "Cancoder", mod.getCANCoder().getDegrees());
            SmartDashboard.putNumber("Mod" + mod.moduleNumber + "Integrated", mod.getPosition().angle.getDegrees());
            SmartDashboard.putNumber("Mod" + mod.moduleNumber + "Velocity", mod.getState().speedMetersPerSecond);
        }
    }
}
