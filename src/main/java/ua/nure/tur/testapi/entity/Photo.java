package ua.nure.tur.testapi.entity;

public class Photo {

    private int id;
    private int userId;
    private int cameraId;
    private String photo;

    public Photo() {}

    public Photo(int id, int userId, int cameraId, String photo) {
        this.id = id;
        this.userId = userId;
        this.cameraId = cameraId;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
