package ua.nure.tur.testapi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.interfaces.PermissionDao;
import ua.nure.tur.testapi.data.interfaces.UserDao;
import ua.nure.tur.testapi.data.sqldao.SqlPermissionDao;
import ua.nure.tur.testapi.data.sqldao.SqlUserDao;
import ua.nure.tur.testapi.entities.Permission;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.models.MessageHandler;
import ua.nure.tur.testapi.models.PermissionView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private UserDao userDao = new SqlUserDao();

    private PermissionDao permissionDao = new SqlPermissionDao();

    public MessageHandler<Collection<PermissionView>> getPermissionsTo(int userId){
        Collection<Permission> permissions = permissionDao.getAllItems().stream().filter(p -> p.getUserTo() == userId).collect(Collectors.toList());
        Collection<User> users = userDao.getAllItems();
        Map<Integer, String> userMap = new HashMap<>();
        for (User user:users
             ) {
            userMap.put(user.getId(), user.getUsername());
        }
        Collection<PermissionView> permissionViews = permissions
                .stream()
                .map(p -> new PermissionView(p.getUserFrom(), p.isLocation(), p.isBiometry(),userMap.get(p.getUserFrom()) ) )
                .collect(Collectors.toList());
        return new MessageHandler<Collection<PermissionView>>(200, "OK", permissionViews);
    }

}
