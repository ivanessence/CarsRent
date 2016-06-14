package it.academy.ivan.dao;

import java.util.List;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;

public class ClientService <T> {
    private InterfaceDAO interfaceDAO;
    private InterfaceDAO carsDAO;

    public ClientService() {
        interfaceDAO = new ClientDAOImpl();
        carsDAO = new DAOCars();
    }

    public void addClient(T client) {
        interfaceDAO.add(client);
    }

    public void addCar(T car) {
        carsDAO.add(car);
    }

    public void deleteCar(T car) {
        carsDAO.delete(car);
    }

    public List<Client> getClients() {
        return interfaceDAO.getFromDb();
    }
}
