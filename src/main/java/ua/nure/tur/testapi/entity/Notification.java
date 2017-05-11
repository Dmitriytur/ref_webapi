package ua.nure.tur.testapi.entity;

import java.util.Date;

public class Notification {

    private int id;
    private int userId;
    private String message;
    private Date time;
    private boolean isRead;

    public  Notification() {}

    public Notification(int id, int userId, String message, Date time, boolean isRead) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.time = time;
        this.isRead = isRead;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
