package frc.lib.math;

public class Conversions {
    public static double CANCondertoDegrees(double positionCounts, double gearRatio) {
        return positionCounts * (360.0 / (gearRatio * 4096.0));
    }

    public static double degreesToCANCoder (double degrees, double gearRatio) {
        return degrees / (360.0 / (gearRatio * 4096.0));
    }

    public static double falconToDegrees (double positionCounts, double gearRatio) {
        return positionCounts * (360.0 / (gearRatio * 2048.0));
    }

    public static double degreesToFalcon(double degrees, double gearRatio) {
        return degrees / (360.0 / (gearRatio * 2048.0));
    }

    public static double falconToRPM (double velocityCounts, double gearRatio) {
        double motorRPM = velocityCounts * (600.0 / 2048.0);
        double mechRPM = motorRPM / gearRatio; 
        return mechRPM;
    }

    public static double RPMToFalcon(double RPM, double gearRatio) {
        double motorRPM = RPM * gearRatio;
        double sensorCounts = motorRPM * (2048.0 / 600.0);
        return sensorCounts;
    }

    public static double falconToMPS (double velocityCounts, double circumference, double gearRatio) {
        double wheelRPM = falconToRPM(velocityCounts, gearRatio);
        double wheelMPS = (wheelRPM * circumference) / 60;
        return wheelMPS;
    }

    public static double MPSToFalcon (double velocity, double circumference, double gearRatio) {
        double wheelRPM = ((velocity * 60) / circumference);
        double wheelVelocity = RPMToFalcon(wheelRPM, gearRatio);
        return wheelVelocity;
    }

    public static double falconToMeters (double positionCounts, double circumference, double gearRatio) {
        return positionCounts * (circumference / (gearRatio * 2048.0));
    }

    public static double MetersToFalcon (double meters, double circumference, double gearRatio) {
        return meters / (circumference / (gearRatio * 2048.0));
    }
}
