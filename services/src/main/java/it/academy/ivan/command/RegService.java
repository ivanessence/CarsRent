package it.academy.ivan.command;

import it.academy.ivan.dao.AbstractDao;
import it.academy.ivan.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan on 06.07.2016.
 */
@Service
public class RegService implements IRegService {
public AbstractDao dao;

    @Autowired
    public RegService(AbstractDao dao) {
        this.dao = dao;
    }
    @Override
    public void add(Client t) {
        dao.saveOrUpdate(t);
    }

    @Override
    public void delete(Client client) {

    }
}
