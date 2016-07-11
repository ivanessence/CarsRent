package it.academy.ivan.controller;

import it.academy.ivan.command.*;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;
import it.academy.ivan.managers.MessageManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Ivan on 01.07.2016.
 */
@Controller
public class HomeController {
    @Autowired
    public IAddProduct add;
    @Autowired
    public IShowClients showclients;
    @Autowired
    public IShowCars showcars;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView model, @RequestParam(value = "error", required = false) String error) {
        model.setViewName("login");
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView reg(ModelAndView model) {
        model.setViewName("registration");
        return model;
    }

    @RequestMapping(value = "/gog", method = RequestMethod.GET)
    public String gog() {
        return "gog";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String re() {
        return "registration";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String admin() {
        return "main";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/goaddauto", method = RequestMethod.POST)
    public String addauto() {
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
        add.add(newCar);
        page = "addproduct";
        request.setAttribute("success", MessageManager.getProperty("message.product"));

        return page;

    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ModelAndView clients() {
        ModelAndView model = new ModelAndView("clients");
        List<Client> list = showclients.getFromDb(0);
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
        List<Cars> list = showcars.getFromDb(0);
        model.addObject("carsList", list);
        return model;
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public ModelAndView go1() {
        ModelAndView model = new ModelAndView("showcars");
        List<Cars> list = showcars.getFromDb(4);
        model.addObject("carsList", list);
        return model;
    }
    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public ModelAndView go2() {
        ModelAndView model = new ModelAndView("showcars");
        List<Cars> list = showcars.getFromDb(8);
        model.addObject("carsList", list);
        return model;
    }

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public ModelAndView go3() {
        ModelAndView model = new ModelAndView("showcars");
        List<Cars> list = showcars.getFromDb(12);
        model.addObject("carsList", list);
        return model;
    }

    @RequestMapping(value = "/4", method = RequestMethod.GET)
    public ModelAndView go4() {
        ModelAndView model = new ModelAndView("showcars");
        List<Cars> list = showcars.getFromDb(16);
        model.addObject("carsList", list);
        return model;
    }
}
