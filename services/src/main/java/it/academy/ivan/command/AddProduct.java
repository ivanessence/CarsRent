package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;

import it.academy.ivan.dao.ClientService;
import it.academy.ivan.entity.Cars;
import it.academy.ivan.managers.ConfigurationManager;
import it.academy.ivan.managers.MessageManager;

public class AddProduct implements ActionCommand {

	private static String model;
	private static String color;
	private static String year;

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		model = request.getParameter("model");
		year = request.getParameter("year");
		color = request.getParameter("color");
		try {
			addProduct(model, year, color);
			page = ConfigurationManager.getProperty("path.page.admin.add");
			request.setAttribute("success", MessageManager.getProperty("message.product"));

		}catch (NumberFormatException e) {

		}

		return page;
	}
	public void addProduct(String model, String year, String color){
		Cars newCar = new Cars(model, year, color);
		ClientService clientService = new ClientService();
		clientService.addCar(newCar);

	}
}
