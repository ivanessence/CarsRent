package it.academy.ivan.controller;

import it.academy.ivan.command.IDeleteService;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.managers.MessageManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivan on 06.07.2016.
 */
@Controller
public class DeleteController {
    @Autowired
    public IDeleteService del;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteauto(ModelAndView model, HttpServletRequest request) {
        SessionFactory sessionFactory = null;
        String page = null;
        String id;
        int idString;
        id = request.getParameter("id");
        idString = Integer.valueOf(id);
        Cars newCar = new Cars(idString);
        del.delete(newCar);
        page = "addproduct";
        request.setAttribute("success", MessageManager.getProperty("message.delete"));
        return page;

    }
}
