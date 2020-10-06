package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * this subsystem creates the main functions for the limelight
 */
public class LimelightSubsystem extends SubsystemBase {

    public static NetworkTableInstance table = null;

    public LimelightSubsystem() {
        table = NetworkTableInstance.getDefault();
    }

    public static enum LightMode {
        eOn, eOff, eBlink
    }

    public static enum CameraMode {
        eVision, eDriver
    }

    public void limelightIsOn(boolean isLightOn) {
        if (isLightOn)
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
        else
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    }

    public void cameraMode(boolean isVisionProcessor) {
        if (isVisionProcessor)
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
        else
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);

    }


    /**
     * Gets whether a target is detected by the Limelight.
     *
     * @return true if a target is detected, false otherwise.
     */
    public static boolean isTarget() {
        return getValue("tv").getDouble(0) == 1;
    }

    /**
     * Horizontal offset from crosshair to target (-27 degrees to 27 degrees).
     *
     * @return tx as reported by the Limelight.
     */
    public static double getTx() {
        System.out.println("tx is... " + getValue("tx").getDouble(0.00));
        return getValue("tx").getDouble(0.00);
    }

    /**
     * Vertical offset from crosshair to target (-20.5 degrees to 20.5 degrees).
     *
     * @return ty as reported by the Limelight.
     */
    public static double getTy() {
        System.out.println("ty is... " + getValue("ty").getDouble(0.00));
        return getValue("ty").getDouble(0.00);
    }

    /**
     * Area that the detected target takes up in total camera FOV (0% to 100%).
     *
     * @return Area of target.
     */
    public static double getTa() {
        return getValue("ta").getDouble(0.00);
    }

    /**
     * Gets target skew or rotation (-90 degrees to 0 degrees).
     *
     * @return Target skew.
     */
    public static double getTs() {
        return getValue("ts").getDouble(0.00);
    }

    /**
     * Gets target latency (ms).
     *
     * @return Target latency.
     */
    public static double getTl() {
        return getValue("tl").getDouble(0.00);
    }

    /**
     * Sets LED mode of Limelight.
     *
     * @param mode Light mode for Limelight.
     */
    public static void setLedMode(LightMode mode) {
        getValue("ledMode").setNumber(mode.ordinal());
    }

    /**
     * Sets camera mode for Limelight.
     *
     * @param mode Camera mode for Limelight.
     */
    public static void setCameraMode(CameraMode mode) {
        getValue("camMode").setNumber(mode.ordinal());
    }

    /**
     * Sets pipeline number (0-9 value).
     *
     * @param number Pipeline number (0-9).
     */
    public static void setPipeline(int number) {
        getValue("pipeline").setNumber(number);
    }

    /**
     * Helper method to get an entry from the Limelight NetworkTable.
     *
     * @param key Key for entry.
     * @return NetworkTableEntry of given entry.
     */
    private static NetworkTableEntry getValue(String key) {
        if (table == null) {
            table = NetworkTableInstance.getDefault();
        }
        System.out.println("key: " + key +";" + table.getTable("limelight").getEntry(key));
        return table.getTable("limelight").getEntry(key);
    }
}
