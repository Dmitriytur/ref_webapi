package ua.nure.tur.testapi.models;


public class UserStateView {

    private double x;
    private double y;
    private double temperature;
    private int breathing;
    private int hearth;
    private boolean locationPermitted;
    private boolean biometryPermitted;

    public UserStateView() {}

    public UserStateView(double x, double y, double temperature, int breathing, int hearth, boolean locationPermitted, boolean biometryPermitted) {
        this.x = x;
        this.y = y;
        this.temperature = temperature;
        this.breathing = breathing;
        this.hearth = hearth;
        this.locationPermitted = locationPermitted;
        this.biometryPermitted = biometryPermitted;
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

    public boolean isLocationPermitted() {
        return locationPermitted;
    }

    public void setLocationPermitted(boolean locationPermitted) {
        this.locationPermitted = locationPermitted;
    }

    public boolean isBiometryPermitted() {
        return biometryPermitted;
    }

    public void setBiometryPermitted(boolean biometryPermitted) {
        this.biometryPermitted = biometryPermitted;
    }
}
