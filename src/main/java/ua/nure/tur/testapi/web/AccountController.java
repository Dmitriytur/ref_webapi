package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.domain.UserService;
import ua.nure.tur.testapi.models.MessageHandler;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public MessageHandler register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/getProfile", method = RequestMethod.GET)
    public User profile(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = (int) auth.getPrincipal();
        return userService.getUserById(id);
    }

}
