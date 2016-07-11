package it.academy.ivan.command;

import it.academy.ivan.entity.Cars;

import java.util.List;

/**
 * Created by Ivan on 11.07.2016.
 */
public interface IShowCars<T> extends IService<Cars> {

    @Override
    public List<Cars> getFromDb(Integer pg);

}
