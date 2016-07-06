package it.academy.ivan.command;

import it.academy.ivan.entity.Cars;

/**
 * Created by Ivan on 06.07.2016.
 */
public interface IDeleteService extends IService<Cars> {
    public void delete(Cars t);
}
