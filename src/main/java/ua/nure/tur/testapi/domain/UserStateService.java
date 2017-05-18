package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.interfaces.PermissionDao;
import ua.nure.tur.testapi.data.interfaces.StateDao;
import ua.nure.tur.testapi.data.sqldao.SqlPermissionDao;
import ua.nure.tur.testapi.data.sqldao.SqlStateDao;
import ua.nure.tur.testapi.entities.Permission;
import ua.nure.tur.testapi.entities.State;
import ua.nure.tur.testapi.models.UserStateView;

@Service
public class UserStateService {

    StateDao stateDao = new SqlStateDao();

    PermissionDao permissionDao = new SqlPermissionDao();

    public UserStateView getUserState(int targetId, int userId){
        UserStateView view = new UserStateView();
        Permission permission = permissionDao.getByFromAndToId(targetId,userId );
        if (permission == null){
            view.setLocationPermitted(false);
            view.setBiometryPermitted(false);
            return view;
        }
        view.setLocationPermitted(permission.isLocation());
        view.setBiometryPermitted(permission.isBiometry());

        State state = stateDao.getLastState(targetId);
        if (permission.isLocation()){
            view.setX(state.getX());
            view.setY(state.getY());
        }
        if (permission.isBiometry()){
            view.setTemperature(state.getTemperature());
            view.setBreathing(state.getBreathing());
            view.setHearth(state.getHearth());
        }
        return view;

    }
}
