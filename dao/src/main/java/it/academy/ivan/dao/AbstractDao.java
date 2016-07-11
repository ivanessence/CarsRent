package it.academy.ivan.dao;

import java.util.List;

/**
 * Created by Ivan on 15.06.2016.
 */
public interface AbstractDao<T> {

    public T saveOrUpdate(T obj);
    public void delete(T car);
    List<T> getFromDb();
    List<T> show(Integer pg);

}

