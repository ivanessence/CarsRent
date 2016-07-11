package it.academy.ivan.command;

import java.util.List;

/**
 * Created by Ivan on 06.07.2016.
 */
public interface IService<T> {
    public void add(T t);
    public void delete(T t);
    List<T> getFromDb(Integer pg);
}
