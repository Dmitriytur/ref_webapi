package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.domain.UserService;
import ua.nure.tur.testapi.models.MessageHandler;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public MessageHandler login(@RequestBody User user){
        return userService.loginUser(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public MessageHandler register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public MessageHandler<User> profile(Authentication auth){
        int id = (int )auth.getPrincipal();
        return userService.getUserById(id);
    }

}
