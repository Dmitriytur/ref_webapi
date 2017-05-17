package ua.nure.tur.testapi.data.interfaces;

import ua.nure.tur.testapi.exeption.AddFailureExeption;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> getAllItems();

    T getItem(int id);

    void create(T item) throws AddFailureExeption;

    void update(T item);

    void delete(int id);
}
