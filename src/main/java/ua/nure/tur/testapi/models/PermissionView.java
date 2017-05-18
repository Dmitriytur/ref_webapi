package ua.nure.tur.testapi.models;

public class PermissionView {

    private int userId;

    private boolean location;

    private boolean biometry;

    private String username;

    public PermissionView() {}

    public PermissionView(int userId, boolean location, boolean biometry, String username) {
        this.userId = userId;
        this.location = location;
        this.biometry = biometry;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public boolean isBiometry() {
        return biometry;
    }

    public void setBiometry(boolean biometry) {
        this.biometry = biometry;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

