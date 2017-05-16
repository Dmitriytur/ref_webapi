package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.tur.testapi.entity.User;
import ua.nure.tur.testapi.domain.UserService;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody User user){
        userService.addUser(user);
        return "Ok";
    }
}
