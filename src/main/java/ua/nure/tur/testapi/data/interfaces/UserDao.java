package ua.nure.tur.testapi.data.interfaces;

import ua.nure.tur.testapi.entities.User;

public interface UserDao extends Dao<User> {

    User findUserByUserName(String username);
}
