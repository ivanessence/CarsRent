package it.academy.ivan.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.academy.ivan.dao.ClientDAOImpl;
import it.academy.ivan.entity.Client;
import it.academy.ivan.dao.ClientType;
import it.academy.ivan.managers.ConfigurationManager;

public class GoBackCommandForAdmin implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		ClientDAOImpl allUsers = new ClientDAOImpl();
		HttpSession session = request.getSession();
		ClientType userType = (ClientType)session.getAttribute("userType");
		if((userType).equals(ClientType.ADMINISTRATOR)){
			
			page = ConfigurationManager.getProperty("path.page.main");
		}
		else{
			page = ConfigurationManager.getProperty("path.page.index");
			session.invalidate();
			System.out.println("ss");
		}
		return page;
	}

}
