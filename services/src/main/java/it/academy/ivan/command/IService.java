package it.academy.ivan.command;

/**
 * Created by Ivan on 06.07.2016.
 */
public interface IService<T> {
    public void add(T t);
    public void delete(T t);
}
