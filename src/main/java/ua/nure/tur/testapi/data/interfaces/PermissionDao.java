package ua.nure.tur.testapi.data.interfaces;

import ua.nure.tur.testapi.entities.Permission;

public interface PermissionDao extends Dao<Permission> {

    Permission getByFromAndToId(int idFrom, int idTo);
}
