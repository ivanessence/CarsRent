package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;

import it.academy.ivan.managers.ConfigurationManager;

public class EmptyCommand implements ActionCommand {

	/* в случае ошибки или прямого обращения к контроллеру
	  * переадресация на страницу ввода логина */
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return null;
	}

	
	
}
