package ua.nure.tur.testapi.domain;

import org.springframework.stereotype.Service;
import ua.nure.tur.testapi.data.interfaces.StateDao;
import ua.nure.tur.testapi.data.interfaces.UserDao;
import ua.nure.tur.testapi.data.sqldao.SqlStateDao;
import ua.nure.tur.testapi.data.sqldao.SqlUserDao;
import ua.nure.tur.testapi.entities.State;
import ua.nure.tur.testapi.entities.User;
import ua.nure.tur.testapi.exeption.AddFailureException;
import ua.nure.tur.testapi.models.DeviceInfo;

import java.util.Date;

@Service
public class DeviceService {

    private UserDao userDao = new SqlUserDao();

    private StateDao stateDao = new SqlStateDao();
    public void acceptData(DeviceInfo info){

        User user = userDao.getUserByDeviceKey(info.getDeviceKey());
        try {
            stateDao.create(new State(0, user.getId(), info.getX(), info.getY(), info.getTemperature(), info.getBreathing(), info.getHearth(), new Date()));
        } catch (AddFailureException e) {
            e.printStackTrace();
        }
    }
}
