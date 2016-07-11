package it.academy.ivan.command;

import it.academy.ivan.dao.AbstractDao;
import it.academy.ivan.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan on 08.07.2016.
 */
@Service
public class ShowClients implements IShowClients<Client>{

    public AbstractDao dao;

    @Autowired
    public ShowClients(AbstractDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> getFromDb(Integer pg) {

        return dao.getFromDb();
    }
}
