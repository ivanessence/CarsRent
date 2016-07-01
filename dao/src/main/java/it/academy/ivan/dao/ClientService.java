package it.academy.ivan.dao;

import java.util.List;


import it.academy.ivan.entity.Client;

public class ClientService<T> {
    private InterfaceDAO interfaceDAO;
    private InterfaceDAO carsDAO;

    public ClientService() {
        interfaceDAO = new ClientDAOImpl();
        carsDAO = new DAOCars();
    }


    public List<Client> getClients() {
        return interfaceDAO.getFromDb();
    }
}
