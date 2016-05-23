package it.academy.ivan.command;

import it.academy.ivan.dao.ClientService;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivan on 22.05.2016.
 */
public class DeleteProduct implements ActionCommand {

    private static String id;
    private static int idString;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        id = request.getParameter("id");
        idString = Integer.valueOf(id);
        addProduct();

        page = ConfigurationManager.getProperty("path.page.admin.add");
        request.setAttribute("success", MessageManager.getProperty("message.delete"));
        return page;
    }

    private void addProduct() {

        Cars newCar = new Cars(idString);
        ClientService clientService = new ClientService();
        clientService.deleteCar(newCar);


    }
}
