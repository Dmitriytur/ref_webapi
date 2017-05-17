package ua.nure.tur.testapi.data.interfaces;

import ua.nure.tur.testapi.exeption.AddFailureException;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> getAllItems();

    T getItem(int id);

    void create(T item) throws AddFailureException;

    void update(T item);

    void delete(int id);
}
