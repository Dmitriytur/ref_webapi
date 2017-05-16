package ua.nure.tur.testapi.data.interfaces;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> getAllItems();

    T getItem(int id);

    void create(T item);

    void update(T item);

    void delete(int id);
}
