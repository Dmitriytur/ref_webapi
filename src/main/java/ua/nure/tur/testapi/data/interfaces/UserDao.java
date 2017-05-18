package ua.nure.tur.testapi.data.interfaces;

import ua.nure.tur.testapi.entities.User;

import javax.jws.soap.SOAPBinding;

public interface UserDao extends Dao<User> {

    User findUserByUserName(String username);

    User getUserByDeviceKey(String deviceKey);
}
