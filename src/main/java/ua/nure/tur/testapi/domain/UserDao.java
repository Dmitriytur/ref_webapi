package ua.nure.tur.testapi.domain;

import ua.nure.tur.testapi.entity.User;

public interface UserDao extends Dao<User> {
    
    User findUserByUserName(String username);
}
