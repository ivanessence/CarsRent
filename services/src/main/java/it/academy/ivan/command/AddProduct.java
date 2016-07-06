package it.academy.ivan.command;

import it.academy.ivan.dao.AbstractDao;
import it.academy.ivan.entity.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan on 06.07.2016.
 */
@Service
public class AddProduct implements IAddProduct {

    public AbstractDao dao;

    @Autowired
    public AddProduct(AbstractDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Cars t) {
        dao.saveOrUpdate(t);
    }

    @Override
    public void delete(Cars cars) {

    }
}
