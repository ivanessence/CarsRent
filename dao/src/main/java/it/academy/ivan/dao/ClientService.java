package it.academy.ivan.dao;

import java.util.List;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;

public class ClientService {
    private InterfaceDAO interfaceDAO;
    private InterfaceDAO carsDAO;

    public ClientService() {
        interfaceDAO = new ClientDAOImpl();
        carsDAO = new DAOCars();
    }

    public void addClient(Client client) {
        interfaceDAO.add(client);
    }
    
    public void addCar(Cars car) {
        carsDAO.add(car);
    }

    public void deleteCar(Cars car) {
        carsDAO.delete(car);
    }

    public List<Client> getClients() {
        return interfaceDAO.getFromDb();
    }
}
