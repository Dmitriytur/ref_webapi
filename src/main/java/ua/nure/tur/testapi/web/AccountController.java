package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.entity.User;
import ua.nure.tur.testapi.service.UserService;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(@RequestBody User user){
        userService.addUser(user);
    }
}
