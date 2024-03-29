package frc.lib.util;

import edu.wpi.first.math.util.Units;

public class SwerveTypeConstants {
    public final double wheelDiameter;
    public final double wheelCircumference;
    public final double angleGearRatio;
    public final double driveGearRatio;
    public final double angleKP;
    public final double angleKI;
    public final double angleKD;
    public final double angleKF;
    public final boolean driveMotorInvert;
    public final boolean angleMotorInvert;
    public final boolean CANCOderInvert;

    public SwerveTypeConstants(double wheelDiameter, double angleGearRatio, double driveGearRatio, double angleKP, double angleKI, double angleKD, double angleKF, boolean driveMotorInvert, boolean angleMotorInvert, boolean CANCOderInvert) {
        this.wheelDiameter = wheelDiameter;
        this.wheelCircumference = wheelDiameter * Math.PI;
        this.angleGearRatio = angleGearRatio;
        this.driveGearRatio = driveGearRatio;
        this.angleKP = angleKP;
        this.angleKI = angleKI;
        this.angleKD = angleKD;
        this.angleKF = angleKF;
        this.driveMotorInvert = driveMotorInvert;
        this.angleMotorInvert =angleMotorInvert;
        this.CANCOderInvert = CANCOderInvert;
    }

    public static SwerveTypeConstants SDSMK4_L1() {
        double wheelDiameter = Units.inchesToMeters(4.0);

        double angleGearRatio = SWERVE_ANGLEGEAR_RATIOS_MK4;
        double driveGearRatio = SWERVE_MK4_DRVIEGEAR_RATIOS_L1;

        double angleKP = 0.2;
        double angleKI = 0.0;
        double angleKD = 0.0;
        double angleKF = 0.0;

        boolean driveMotorInvert = false;
        boolean angleMotorInvert = false;
        boolean CANCOderInvert = false;
        return new SwerveTypeConstants(
            wheelDiameter, angleGearRatio, driveGearRatio, 
            angleKP, angleKI, angleKD, angleKF, 
            driveMotorInvert, angleMotorInvert, CANCOderInvert);
    }

    public static SwerveTypeConstants SDSMK4_L2() {
        double wheelDiameter = Units.inchesToMeters(4.0);

        double angleGearRatio = SWERVE_ANGLEGEAR_RATIOS_MK4;
        double driveGearRatio = SWERVE_MK4_DRVIEGEAR_RATIOS_L2;

        double angleKP = 0.2;
        double angleKI = 0.0;
        double angleKD = 0.0;
        double angleKF = 0.0;

        boolean driveMotorInvert = false;
        boolean angleMotorInvert = false;
        boolean CANCOderInvert = false;
        return new SwerveTypeConstants(
            wheelDiameter, angleGearRatio, driveGearRatio,
            angleKP, angleKI, angleKD, angleKF,
            driveMotorInvert, angleMotorInvert, CANCOderInvert);
    }

    public static SwerveTypeConstants SDSMK4I_L1() {
        double wheelDiameter = Units.inchesToMeters(4.0);

        double angleGearRatio = SWERVE_ANGLEGEAR_RATIOS_MK4I;
        double driveGearRatio = SWERVE_MK4_DRVIEGEAR_RATIOS_L1;

        double angleKP = 0.3;
        double angleKI = 0.0;
        double angleKD = 0.0;
        double angleKF = 0.0;

        boolean driveMotorInvert = false;
        boolean angleMotorInvert = true;
        boolean CANCOderInvert = false;
        return new SwerveTypeConstants(
            wheelDiameter, angleGearRatio, driveGearRatio, 
            angleKP, angleKI, angleKD, angleKF, 
            driveMotorInvert, angleMotorInvert, CANCOderInvert);
    }

    public static SwerveTypeConstants SDSMK4I_L2() {
        double wheelDiameter = Units.inchesToMeters(4.0);

        double angleGearRatio = SWERVE_ANGLEGEAR_RATIOS_MK4I;
        double driveGearRatio = SWERVE_MK4_DRVIEGEAR_RATIOS_L2;

        double angleKP = 0.3;
        double angleKI = 0.0;
        double angleKD = 0.0;
        double angleKF = 0.0;

        boolean driveMotorInvert = false;
        boolean angleMotorInvert = true;
        boolean CANCOderInvert = false;
        return new SwerveTypeConstants(
            wheelDiameter, angleGearRatio, driveGearRatio,
            angleKP, angleKI, angleKD, angleKF,
            driveMotorInvert, angleMotorInvert, CANCOderInvert);
    }

    private static final double SWERVE_MK4_DRVIEGEAR_RATIOS_L1 = (8.14 / 1.0);
    private static final double SWERVE_MK4_DRVIEGEAR_RATIOS_L2 = (6.75 / 1.0);
    private static final double SWERVE_ANGLEGEAR_RATIOS_MK4 = (12.8 / 1.0);
    private static final double SWERVE_ANGLEGEAR_RATIOS_MK4I = ((150.0 / 7.0) / 1.0);

}
