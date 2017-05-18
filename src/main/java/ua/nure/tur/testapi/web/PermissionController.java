package ua.nure.tur.testapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.tur.testapi.domain.PermissionService;
import ua.nure.tur.testapi.models.MessageHandler;
import ua.nure.tur.testapi.models.PermissionView;

import java.util.Collection;

@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "permissions/to", method = RequestMethod.GET)
    public MessageHandler<Collection<PermissionView>> get(Authentication auth){
        int id = (int )auth.getPrincipal();
        return permissionService.getPermissionsTo(id);
    }

}
