package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;

import it.academy.ivan.managers.ConfigurationManager;

public class GoIndex implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
