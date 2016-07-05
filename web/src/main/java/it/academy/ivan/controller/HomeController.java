package it.academy.ivan.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import it.academy.ivan.dao.*;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;
import it.academy.ivan.logger.PaymentSystemLogger;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Ivan on 01.07.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelAndView model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String reg(ModelAndView model) {
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String re(ModelAndView model) {
        return "registration";
    }

    @RequestMapping(value = "/goaddauto", method = RequestMethod.POST)
    public String addauto(ModelAndView model) {
        return "addproduct";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteauto(ModelAndView model, HttpServletRequest request) {
        String page = null;
        String id;
        int idString;
        id = request.getParameter("id");
        idString = Integer.valueOf(id);
        Cars newCar = new Cars(idString);
        AbstractDao dao = new AbstractDao();
        dao.delete(newCar);

        page = "addproduct";
        request.setAttribute("success", MessageManager.getProperty("message.delete"));
        return page;

    }

    @RequestMapping(value = "/addcar", method = RequestMethod.POST)
    public String addcar(HttpServletRequest request) {
        String model;
        String color;
        String year;
        String page = null;
        model = request.getParameter("model");
        year = request.getParameter("year");
        color = request.getParameter("color");

        Cars newCar = new Cars(model, year, color);
        EventDao ev = new EventDao();
        ev.create(newCar);
        page = "addproduct";
        request.setAttribute("success", MessageManager.getProperty("message.product"));

        return page;

    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ModelAndView clients() {
        ModelAndView model = new ModelAndView("clients");
        ClientDAOImpl allUsers = new ClientDAOImpl();
        List<Client> list = allUsers.getFromDb();
        model.addObject("lists", list);
        return model;
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String goLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/gobackuser", method = RequestMethod.POST)
    public String goBackUser() {
        return "user";
    }

    @RequestMapping(value = "/gobackadmin", method = RequestMethod.POST)
    public String goBackAdmin() {
        return "main";
    }

    @RequestMapping(value = "/goshowauto", method = RequestMethod.POST)
    public ModelAndView goShowAuto() {
        ModelAndView model = new ModelAndView("showcars");
        DAOCars cars = new DAOCars();
        List<Cars> list = cars.getFromDbs(0);
        model.addObject("carsList", list);
        return model;
    }

}
