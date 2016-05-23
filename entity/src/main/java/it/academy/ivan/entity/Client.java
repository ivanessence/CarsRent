package it.academy.ivan.entity;

public class Client {

	private int client_id;
	private String fio;
	private String passport;
	private String login;
	private String password;
	private int role;
	private int del_status;

	public Client() {
		
	}
	
	public Client(int client_id, String fio, String passport, String login, String password, int role, int del_status) {
		this.client_id = client_id;
		this.fio = fio;
		this.passport = passport;
		this.login = login;
		this.password = password;
		this.role = role;
		this.del_status = del_status;
	}
	
	public Client(String fio, String passport, String login, String password, int role, int del_status) {
		this.fio = fio;
		this.passport = passport;
		this.login = login;
		this.password = password;
		this.role = role;
		this.del_status = del_status;
	}
	
	public Client(int client_id) {
		this.client_id = client_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getDel_status() {
		return del_status;
	}

	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", fio=" + fio + ", passport=" + passport + ", login=" + login
				+ ", password=" + password + ", role=" + role + ", del_status=" + del_status + "]";
	}
	
	
	
}