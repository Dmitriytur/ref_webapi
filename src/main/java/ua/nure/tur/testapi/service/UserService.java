package ua.nure.tur.testapi.service;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.domain.UserDao;
import ua.nure.tur.testapi.entity.User;

import java.util.Objects;


@Service
public class UserService {

    private UserDao userDao = new UserDao();

    public User findUserByLogin(String login){
        return userDao.findUserByLogin(login);
    }
}
