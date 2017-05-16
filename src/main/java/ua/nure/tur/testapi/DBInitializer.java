package ua.nure.tur.testapi;

import ua.nure.tur.testapi.data.sqldao.*;
import ua.nure.tur.testapi.entity.Permission;
import ua.nure.tur.testapi.entity.State;

import java.util.Collection;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DBInitializer {

    private static SqlCameraDao cameraDao = new SqlCameraDao();

    private static SqlNotificationDao notificationDao = new SqlNotificationDao();

    private static  SqlPermissionDao permissionDao = new SqlPermissionDao();

    private static SqlPhotoDao photoDao = new SqlPhotoDao();

    private static SqlStateDao stateDao = new SqlStateDao();

    private  static SqlUserDao userDao = new SqlUserDao();

    public static void Initialize(){

        State state = stateDao.getItem(21);
        System.out.println(state.getTime());
        System.out.println(new Date());

    }

    public static void main(String[] args) {
        Initialize();
    }

}
