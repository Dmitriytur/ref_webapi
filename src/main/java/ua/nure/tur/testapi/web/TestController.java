package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.data.interfaces.StateDao;
import ua.nure.tur.testapi.data.interfaces.UserDao;
import ua.nure.tur.testapi.entity.State;
import ua.nure.tur.testapi.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    private StateDao stateDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Collection<State> test(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString();
        User user = userDao.findUserByUserName(username);
        return stateDao.getAllItems().stream().filter(s -> s.getUserId() == user.getId()).collect(Collectors.toList());
    }
}
