package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.sqldao.SqlUserDao;
import ua.nure.tur.testapi.entity.User;


@Service
public class UserService {

    private SqlUserDao sqlUserRepository = new SqlUserDao();

    public User findUserByUsername(String username){
        return sqlUserRepository.findUserByUserName(username);
    }

    public void addUser(User user){
        sqlUserRepository.Create(user);
    }
}
