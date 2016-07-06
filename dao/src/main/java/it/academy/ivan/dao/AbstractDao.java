package it.academy.ivan.dao;

/**
 * Created by Ivan on 15.06.2016.
 */
public interface AbstractDao<T> {

    public T saveOrUpdate(T obj);
    public void delete(T car);

}

