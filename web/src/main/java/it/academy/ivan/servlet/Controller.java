package it.academy.ivan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.academy.ivan.command.ActionCommand;
import it.academy.ivan.command.ActionFactory;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = null;
		// определение команды, пришедшей из JSP
		ActionFactory user = new ActionFactory();
		ActionCommand command = user.defineCommand(request);
		 /*
	     * вызов реализованного метода execute() и передача параметров
	     * классу-обработчику конкретной команды
	     */
	    page = command.execute(request);
	    // метод возвращает страницу ответа
	    // page = null; // поэксперементировать!
	    if (page != null) {
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
	        // вызов страницы ответа на запрос
	        dispatcher.forward(request, response);
	      } else {
	        // установка страницы c cообщением об ошибке
	        page = ConfigurationManager.getProperty("path.page.index");
	        request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
	        response.sendRedirect(request.getContextPath() + page);
	      }
	}
}
