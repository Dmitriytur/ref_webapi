package ua.nure.tur.testapi.data.interfaces;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> GetAllItems();

    T GetItem(int id);

    void Create(T item);

    void Update(T item);

    void Delete(int id);
}
