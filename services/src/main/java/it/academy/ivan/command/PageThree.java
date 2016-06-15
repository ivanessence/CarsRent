package it.academy.ivan.command;

import it.academy.ivan.dao.ClientType;
import it.academy.ivan.dao.DAOCars;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Ivan on 15.06.2016.
 */
public class PageThree implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        DAOCars cars = new DAOCars();
        HttpSession session = request.getSession();
        ClientType userType = (ClientType)session.getAttribute("userType");
        if((userType).equals(ClientType.USER)){
            List<Cars> list = cars.getFromDbs(8);
            session.setAttribute("carsList", list);

            page = ConfigurationManager.getProperty("path.page.user.cars");
        }
        else{
            page = ConfigurationManager.getProperty("path.page.index");
            session.invalidate();
            System.out.println("ss");
        }
        return page;
    }
}
