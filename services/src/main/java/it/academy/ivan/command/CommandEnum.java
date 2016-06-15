package it.academy.ivan.command;

public enum CommandEnum {

	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new GoToRegistrationPageCommand();
		}
	},
	CREATE {
		{
			this.command = new RegistrationCommand();
		}
	},
	CLIENTS {
		{
			this.command = new GoToShowClientsCommand();
		}
	},
	BACKADMIN {
		{
			this.command = new GoBackCommandForAdmin();
		}
	},
	ADDPRODUCT {
		{
			this.command = new AddProduct();
		}
	},
	GOTOADDPRODUCT {
		{
			this.command = new GoToAddProduct();
		}
	},
	GOCARS {
		{
			this.command = new GoToShowCars();
		}
	},
	BACKUSER {
		{
			this.command = new GoBackCommandForUser();
		}
	},
	GOINDEX {
		{
			this.command = new GoIndex();
		}
	},
	DELETEPRODUCT {
		{
			this.command = new DeleteProduct();
		}
	},
	P1 {
		{
			this.command = new PageOne();
		}
	},
	P2 {
		{
			this.command = new PageTwo();
		}
	},
	P3 {
		{
			this.command = new PageThree();
		}
	},
	P4 {
		{
			this.command = new PageFour();
		}
	};
	
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
