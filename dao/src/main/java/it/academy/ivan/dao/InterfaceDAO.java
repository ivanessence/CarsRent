package it.academy.ivan.dao;

import java.util.List;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;

public interface InterfaceDAO<T> {

	void add(T object);
    List<T> getFromDb();
    void delete(T object);
    
}
