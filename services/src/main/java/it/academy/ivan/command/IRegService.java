package it.academy.ivan.command;

import it.academy.ivan.entity.Client;

/**
 * Created by Ivan on 06.07.2016.
 */
public interface IRegService extends IService<Client> {
    public void add(Client t);
}
