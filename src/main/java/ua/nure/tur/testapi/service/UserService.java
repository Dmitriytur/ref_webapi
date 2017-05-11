package ua.nure.tur.testapi.service;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.domain.UserRepository;
import ua.nure.tur.testapi.entity.User;


@Service
public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User findUserByUsername(String username){
        return userRepository.findUserByUserName(username);
    }

    public void addUser(User user){
        userRepository.Create(user);
    }
}
