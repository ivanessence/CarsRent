package it.academy.ivan.command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import it.academy.ivan.dao.ClientService;

import it.academy.ivan.entity.Client;
import it.academy.ivan.logger.PaymentSystemLogger;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;

public class RegistrationCommand implements ActionCommand{

	private static String fio;
	private static String passport;
	private static String login;
	private static String password;

	
	public RegistrationCommand() {
		
	}
	
	@Override
	public String execute(HttpServletRequest request) {
		
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
				registrate();
				page = ConfigurationManager.getProperty("path.page.registration");
				request.setAttribute("success", MessageManager.getProperty("message.success"));

			} catch (NumberFormatException e) {
				PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
				page = ConfigurationManager.getProperty("path.page.login");
			}
		}
		return page;
	}

	private void registrate(){
		
		Client newClient = new Client(fio,passport, login, password, 1, 0);
		ClientService clientService = new ClientService();
		clientService.addClient(newClient);
		
	}
}
