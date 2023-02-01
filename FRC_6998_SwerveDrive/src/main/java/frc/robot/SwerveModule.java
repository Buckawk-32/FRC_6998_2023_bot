package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.SensorTimeBase;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.lib.math.Conversions;
import frc.lib.util.CTREModuleState;
import frc.lib.util.SwerveTypeConstants;

public class SwerveModule {
    public int moduleNumber;
    private SwerveTypeConstants swerveTypeConstants;
    private Rotation2d angleOffSet;
    private Rotation2d lastAngle;

    private TalonFX mAngleMotor;
    private TalonFX mDriveMotor;
    private CANCoder angleEncoder;

    SimpleMotorFeedforward feedforward = 
        new SimpleMotorFeedforward(Constants.SWERVE_DRIVE_KS, Constants.SWERVE_DRIVE_KV, Constants.SWERVE_DRIVE_KA);
    
    public SwerveModule(int moduleNumber, SwerveTypeConstants swerveTypeConstants, int driveMotorID, int angleMotorID, int CANcoderID, Rotation2d angleOffSet) {
        this.swerveTypeConstants = swerveTypeConstants;
        this.moduleNumber = moduleNumber;
        this.angleOffSet = angleOffSet;

        angleEncoder = new CANCoder(CANcoderID, Robotmap.SWERVE_CANBUS_TYPE);
        configAngleEncoder();

        mAngleMotor = new TalonFX(angleMotorID, Robotmap.SWERVE_CANBUS_TYPE);
        configAngleMotor();

        mDriveMotor = new TalonFX(driveMotorID, Robotmap.SWERVE_CANBUS_TYPE);
        configDriveMotor();

        lastAngle = getState().angle;
    }

    public void setDesiredState(SwerveModuleState desiredState, boolean isOpenLoop) {
        desiredState = CTREModuleState.optimiize(desiredState, getState().angle);
        setAngle(desiredState);
        setSpeed(desiredState, isOpenLoop);
    }

    private void setSpeed (SwerveModuleState desiredState, boolean isOpenLoop) {
        if (isOpenLoop) {
            double percentOutput = desiredState.speedMetersPerSecond / Constants.SWERVE_MAX_SPEED;
            mDriveMotor.set(ControlMode.PercentOutput, percentOutput);
        }
        else {
            double velocity = Conversions.MPSToFalcon(desiredState.speedMetersPerSecond, Constants.SWERVE_WHEEL_CIRCUNFERENCE, swerveTypeConstants.driveGearRatio);
            mDriveMotor.set(ControlMode.Velocity, velocity, DemandType.ArbitraryFeedForward, feedforward.calculate(desiredState.speedMetersPerSecond));
        }
    }

    private void setAngle (SwerveModuleState desiredState) {
        Rotation2d angle = (Math.abs(desiredState.speedMetersPerSecond) <= (Constants.SWERVE_MAX_SPEED * 0.01)) ? lastAngle : desiredState.angle;

        mAngleMotor.set(ControlMode.Position, Conversions.degreesToFalcon(angle.getDegrees(), swerveTypeConstants.angleGearRatio));
        lastAngle = angle;
    }

    private Rotation2d getAngle() {
        return Rotation2d.fromDegrees(Conversions.falconToDegrees(mAngleMotor.getSelectedSensorPosition(), swerveTypeConstants.angleGearRatio));
    }

    public Rotation2d getCANCoder() {
        return Rotation2d.fromDegrees(angleEncoder.getAbsolutePosition());
    }

    public void resetToAbsolute () {
        double absolutePosition = Conversions.degreesToFalcon(getCANCoder().getDegrees() - angleOffSet.getDegrees(), swerveTypeConstants.angleGearRatio);
        mAngleMotor.setSelectedSensorPosition(absolutePosition);
    } 

    private void configAngleEncoder () {
        CANCoderConfiguration CANcoderconfig = new CANCoderConfiguration();
        CANcoderconfig.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
        CANcoderconfig.sensorDirection = swerveTypeConstants.CANCOderInvert;
        CANcoderconfig.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;
        CANcoderconfig.sensorTimeBase = SensorTimeBase.PerSecond;
        
        angleEncoder.configFactoryDefault();
        angleEncoder.configAllSettings(CANcoderconfig);
    }

    private void configAngleMotor () {
        TalonFXConfiguration mAngleMConfig = new TalonFXConfiguration();
        mAngleMConfig.slot0.kP = swerveTypeConstants.angleKP;
        mAngleMConfig.slot0.kI = swerveTypeConstants.angleKI;
        mAngleMConfig.slot0.kD = swerveTypeConstants.angleKD;
        mAngleMConfig.slot0.kF = swerveTypeConstants.angleKF;
        mAngleMConfig.supplyCurrLimit = new SupplyCurrentLimitConfiguration(
            Constants.SWERVE_ANGLE_CURRENT_LIMIT_ENABLE,
            Constants.SWERVE_ANGLE_CONTINUOUS_CURRENT_LIMIT,
            Constants.SWERVE_ANGLE_PEAK_CURRENT_LIMIT,
            Constants.SWERVE_ANGLE_PEAK_CURRENT_DURATION);
        
        mAngleMotor.configFactoryDefault();
        mAngleMotor.configAllSettings(mAngleMConfig);
        mAngleMotor.setInverted(swerveTypeConstants.angleMotorInvert);
        mAngleMotor.setNeutralMode(Constants.ANGLE_NEUTRAL_MODE);
        resetToAbsolute();
    }

    private void configDriveMotor () {
        TalonFXConfiguration mDriveMotorConfig = new TalonFXConfiguration();
        mDriveMotorConfig.slot0.kP = Constants.SWERVE_DRIVE_MOTOR_KP;
        mDriveMotorConfig.slot0.kI = Constants.SWERVE_DRIVE_MOTOR_KI;
        mDriveMotorConfig.slot0.kD = Constants.SWERVE_DRIVE_MOTOR_KD;
        mDriveMotorConfig.slot0.kF = Constants.SWERVE_DRIVE_MOTOR_KF;
        mDriveMotorConfig.supplyCurrLimit = new SupplyCurrentLimitConfiguration(
            Constants.SWERVE_DRIVE_CURRENT_LIMIT_ENABLE,
            Constants.SWERVE_DRIVE_CONTINUOUS_CURRENT_LIMIT,
            Constants.SWERVE_DRIVE_PEAK_CURRENT_LIMIT,
            Constants.SWERVE_DRIVE_PEAK_CURRENT_DURATION);
        mDriveMotorConfig.openloopRamp = Constants.SWERVE_DRIVE_MOTOR_OPENLOOPRAMP;
        mDriveMotorConfig.closedloopRamp = Constants.SWERVE_DRIVE_MOTOR_CLOSELOOPRAMP;

        mDriveMotor.configFactoryDefault();
        mDriveMotor.configAllSettings(mDriveMotorConfig);
        mDriveMotor.setInverted(swerveTypeConstants.driveMotorInvert);
        mDriveMotor.setNeutralMode(Constants.DRIVE_NEUTRAL_MODE);
        mDriveMotor.setSelectedSensorPosition(0);
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(
            Conversions.falconToMPS(mDriveMotor.getSelectedSensorPosition(), swerveTypeConstants.wheelCircumference, swerveTypeConstants.driveGearRatio),
            getAngle());
    }

    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(
            Conversions.falconToMeters(mDriveMotor.getSelectedSensorPosition(), swerveTypeConstants.driveGearRatio, moduleNumber),
            getAngle()
        );
    }
}
