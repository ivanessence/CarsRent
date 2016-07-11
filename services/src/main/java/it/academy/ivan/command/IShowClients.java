package it.academy.ivan.command;


import it.academy.ivan.entity.Client;

import java.util.List;

/**
 * Created by Ivan on 08.07.2016.
 */
public interface IShowClients<C> extends IService<Client>{
    @Override
    List<Client> getFromDb(Integer pg);
}
