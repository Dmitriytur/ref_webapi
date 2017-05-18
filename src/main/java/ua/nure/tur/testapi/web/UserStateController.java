package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.domain.UserStateService;
import ua.nure.tur.testapi.entities.State;
import ua.nure.tur.testapi.models.MessageHandler;
import ua.nure.tur.testapi.models.UserStateView;

import java.util.Stack;

@RestController
public class UserStateController {
    @Autowired
    private UserStateService userStateService;


    @RequestMapping(value = "userinfo/{targetId}", method = RequestMethod.GET)
    public MessageHandler<UserStateView> getRecent(@PathVariable("targetId") String targetId, Authentication auth){
        UserStateView view = userStateService.getUserState(Integer.parseInt(targetId),(int) auth.getPrincipal());
       return new MessageHandler<>(200, "ok", view);
    }
}
