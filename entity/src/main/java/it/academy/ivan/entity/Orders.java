package it.academy.ivan.entity;

public class Orders {

	private int order_id;
	private int client_id;
	private int car_id;
	private int rent_time;
	private int price;
	private int repair_cost;

	public Orders(int order_id, int client_id, int car_id, int rent_time, int price, int repair_cost) {
		this.order_id = order_id;
		this.client_id = client_id;
		this.car_id = car_id;
		this.rent_time = rent_time;
		this.price = price;
		this.repair_cost = repair_cost;
	}
	
	public Orders(int client_id, int car_id, int rent_time, int price, int repair_cost) {
		this.client_id = client_id;
		this.car_id = car_id;
		this.rent_time = rent_time;
		this.price = price;
		this.repair_cost = repair_cost;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getRent_time() {
		return rent_time;
	}

	public void setRent_time(int rent_time) {
		this.rent_time = rent_time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRepair_cost() {
		return repair_cost;
	}

	public void setRepair_cost(int repair_cost) {
		this.repair_cost = repair_cost;
	}
}
