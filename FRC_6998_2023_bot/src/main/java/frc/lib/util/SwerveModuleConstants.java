package frc.lib.util;

import edu.wpi.first.math.geometry.Rotation2d;

public class SwerveModuleConstants {
    public final int driveMotorID;
    public final int angleMotorID;
    public final int CANcoderID;
    public final Rotation2d angleOffset;

    public SwerveModuleConstants(int driveMotorID, int angleMotorID, int CANcoderID, Rotation2d angleOffset) {
        this.driveMotorID = driveMotorID;
        this.angleMotorID = angleMotorID;
        this.CANcoderID = CANcoderID;
        this.angleOffset = angleOffset;
    }
}
