package it.academy.ivan.command;

import it.academy.ivan.dao.AbstractDao;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan on 06.07.2016.
 */
@Service
public class DeleteService implements IDeleteService{
    public AbstractDao dao;

    @Autowired
    public DeleteService(AbstractDao dao) {
        this.dao = dao;
    }


    @Override
    public void add(Cars cars) {

    }

    @Override
    public void delete(Cars t) {
        dao.delete(t);
    }
}