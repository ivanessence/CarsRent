package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.academy.ivan.dao.ClientDAOImpl;
import it.academy.ivan.dao.ClientType;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;

public class LoginCommand implements ActionCommand {

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ClientDAOImpl us = new ClientDAOImpl();

		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		if (us.isAuthorized(login, pass)) {
			request.setAttribute("user", login);
			HttpSession session = request.getSession(true);
			ClientType userType = us.checkAccessLevel(login);
			// определение пути к main.jsp
			
			
			if ((userType).equals(ClientType.ADMINISTRATOR)) {
				session.setAttribute("userType", userType);
				session.setAttribute("user", login);
				page = ConfigurationManager.getProperty("path.page.main");

			}
			else if ((userType).equals(ClientType.USER)) {
				session.setAttribute("userType", userType);
				session.setAttribute("user", login);
				page = ConfigurationManager.getProperty("path.page.user");
				
			} }  else {
				request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
				request.getSession().setAttribute("userType", ClientType.GUEST);
				page = ConfigurationManager.getProperty("path.page.login");
			}
		
		return page;
	}

}
