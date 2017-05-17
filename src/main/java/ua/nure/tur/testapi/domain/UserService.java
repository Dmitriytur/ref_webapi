package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.sqldao.SqlUserDao;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.exeption.AddFailureException;
import ua.nure.tur.testapi.models.MessageHandler;
import ua.nure.tur.testapi.security.TokenAuthenticationService;

import java.util.Objects;


@Service
public class UserService {


    private SqlUserDao sqlUserDao  = new SqlUserDao();

    public User findUserByUsername(String username){
        return sqlUserDao.findUserByUserName(username);
    }

    public MessageHandler<User> getUserById(int id){
        return new MessageHandler<>(200, "OK", sqlUserDao.getItem(id));
    }

    public MessageHandler loginUser(User user){
        User realUser = findUserByUsername(user.getUsername());
        if (realUser != null && Objects.equals(user.getPassword(), realUser.getPassword())){
            String token = TokenAuthenticationService.getToken(realUser);
           return new MessageHandler<>(200, "Ok", token);
        }
        else{
            String token = TokenAuthenticationService.getToken(realUser);
            return new MessageHandler(400, "Wrong login or password");
        }
    }

    public MessageHandler registerUser(User user){
        MessageHandler result = new MessageHandler(200, "Ok");
        user.setRole("user");
        try {
            sqlUserDao.create(user);
        } catch (AddFailureException addFailureException) {
            addFailureException.printStackTrace();
            result.setStatus(500);
            result.setMessage("Server add failure");
        }
        return result;
    }
}
