//package it.academy.ivan.controller;
//
//import it.academy.ivan.dao.ClientDAOImpl;
//import it.academy.ivan.dao.ClientType;
//import it.academy.ivan.managers.MessageManager;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * Created by Ivan on 03.07.2016.
// */
//@Controller
//
//public class LoginController {
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String logIn(ModelAndView model, HttpServletRequest request) {
//        String page = null;
//        ClientDAOImpl us = new ClientDAOImpl();
//        // извлечение из запроса логина и пароля
//        String login = request.getParameter("login");
//        String pass = request.getParameter("password");
//        // проверка логина и пароля
//        if (us.isAuthorized(login, pass)) {
//            request.setAttribute("user", login);
//            HttpSession session = request.getSession(true);
//            ClientType userType = us.checkAccessLevel(login);
//            // определение пути к main.jsp
//            if ((userType).equals(ClientType.ADMINISTRATOR)) {
//                session.setAttribute("userType", userType);
//                session.setAttribute("user", login);
//                page = "main";
//
//            } else if ((userType).equals(ClientType.USER)) {
//                session.setAttribute("userType", userType);
//                session.setAttribute("user", login);
//                page = "user";
//
//            }
//        } else {
//            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//            request.getSession().setAttribute("userType", ClientType.GUEST);
//            page = "login";
//        }
//
//        return page;
//    }
//
//}
