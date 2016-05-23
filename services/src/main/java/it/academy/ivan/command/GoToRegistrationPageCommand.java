package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;

import it.academy.ivan.managers.ConfigurationManager;

public class GoToRegistrationPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.registration");
		return page;
	}

}
