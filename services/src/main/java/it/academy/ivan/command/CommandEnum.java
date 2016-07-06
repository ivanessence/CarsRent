package it.academy.ivan.command;

public enum CommandEnum {


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
