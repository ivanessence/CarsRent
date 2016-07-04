package it.academy.ivan.controller;

import it.academy.ivan.dao.EventDao;
import it.academy.ivan.entity.Client;
import it.academy.ivan.logger.PaymentSystemLogger;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivan on 03.07.2016.
 */
@Controller

public class RegController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(ModelAndView model, HttpServletRequest request) {
        String fio;
        String passport;
        String login;
        String password;
        String page = null;
        fio = request.getParameter("fio");
        passport = request.getParameter("passport");
        login = request.getParameter("login");
        password = request.getParameter("password");
        if (fio == "" || passport == "" || login == "" || password == "") {
            page = ConfigurationManager.getProperty("path.page.registration");
            request.setAttribute("emptyf", MessageManager.getProperty("message.emptyfields"));
        } else {
            try {
                Client newClient = new Client(fio, passport, login, password, 1, 0);
                EventDao ev = new EventDao();
                ev.create(newClient);

                page = ConfigurationManager.getProperty("path.page.registration");
                request.setAttribute("success", MessageManager.getProperty("message.success"));

            } catch (NumberFormatException e) {
                PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        return "registration";

    }
}
