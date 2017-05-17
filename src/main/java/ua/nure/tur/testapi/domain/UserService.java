package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.sqldao.SqlUserDao;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.exeption.AddFailureExeption;
import ua.nure.tur.testapi.models.MessageHandler;


@Service
public class UserService {


    private SqlUserDao sqlUserDao  = new SqlUserDao();

    public User findUserByUsername(String username){

        return sqlUserDao.findUserByUserName(username);
    }

    public User getUserById(int id){
        return sqlUserDao.getItem(id);
    }

    public MessageHandler registerUser(User user){
        MessageHandler result = new MessageHandler(200, "Ok", "");
        user.setRole("user");
        try {
            sqlUserDao.create(user);
        } catch (AddFailureExeption addFailureExeption) {
            addFailureExeption.printStackTrace();
            result.setStatus(500);
            result.setMessage("Server add failure");
        }
        return result;
    }
}
