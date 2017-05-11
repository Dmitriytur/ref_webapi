package ua.nure.tur.testapi.entity;

public class Permission {

    private int id;
    private int userFrom;
    private int userTo;
    private boolean location;
    private boolean biometry;
    private boolean photo;

    public Permission() {}

    public Permission(int id, int userFrom, int userTo,
                      boolean location, boolean biometry, boolean photo) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.location = location;
        this.biometry = biometry;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }

    public int getUserTo() {
        return userTo;
    }

    public void setUserTo(int userTo) {
        this.userTo = userTo;
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

    public boolean isPhoto() {
        return photo;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }
}
