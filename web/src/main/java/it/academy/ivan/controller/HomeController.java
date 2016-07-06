package it.academy.ivan.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import it.academy.ivan.command.IAddProduct;
import it.academy.ivan.command.IDeleteService;
import it.academy.ivan.command.IRegService;
import it.academy.ivan.command.IService;
import it.academy.ivan.dao.*;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;
import it.academy.ivan.logger.PaymentSystemLogger;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    public IAddProduct serv;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView model, @RequestParam(value = "error", required = false) String error) {
        model.setViewName("login");
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String reg(ModelAndView model) {
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String re(ModelAndView model) {
        return "registration";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String admin(ModelAndView model) {
        return "main";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelAndView model) {
        return "user";
    }

    @RequestMapping(value = "/goaddauto", method = RequestMethod.POST)
    public String addauto(ModelAndView model) {
        return "addproduct";
    }



    @RequestMapping(value = "/addcar", method = RequestMethod.POST)
    public String addcar(HttpServletRequest request) {
        SessionFactory sessionFactory = null;
        String model;
        String color;
        String year;
        String page = null;
        model = request.getParameter("model");
        year = request.getParameter("year");
        color = request.getParameter("color");

        Cars newCar = new Cars(model, year, color);
        serv.add(newCar);
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
