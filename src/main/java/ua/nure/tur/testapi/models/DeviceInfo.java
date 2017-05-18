package ua.nure.tur.testapi.models;

public class DeviceInfo {

    private  String deviceKey;

    private double x;
    private double y;
    private double temperature;
    private int breathing;
    private int hearth;

    public DeviceInfo() {}

    public DeviceInfo(String deviceKey, double x, double y, double temperature, int breathing, int hearth) {
        this.deviceKey = deviceKey;
        this.x = x;
        this.y = y;
        this.temperature = temperature;
        this.breathing = breathing;
        this.hearth = hearth;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getBreathing() {
        return breathing;
    }

    public void setBreathing(int breathing) {
        this.breathing = breathing;
    }

    public int getHearth() {
        return hearth;
    }

    public void setHearth(int hearth) {
        this.hearth = hearth;
    }
}
