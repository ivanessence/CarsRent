package it.academy.ivan.dao;

/**
 * Created by Ivan on 15.06.2016.
 */
public class EventDao <T> extends AbstractDao<T> {

    public void create(T o) {
        super.saveOrUpdate(o);
    }
    public void delete(T o) {
        super.delete(o);
    }

}
