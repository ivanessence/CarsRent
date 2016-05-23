package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import it.academy.ivan.dao.ClientType;
import it.academy.ivan.managers.ConfigurationManager;

public class GoBackCommandForUser implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		HttpSession session = request.getSession();
		ClientType userType = (ClientType)session.getAttribute("userType");
		if((userType).equals(ClientType.USER)){
			
			page = ConfigurationManager.getProperty("path.page.user");
			
		}
		else{
			page = ConfigurationManager.getProperty("path.page.index");
			session.invalidate();
			System.out.println("ss");
		}
		return page;
	
	}

}
