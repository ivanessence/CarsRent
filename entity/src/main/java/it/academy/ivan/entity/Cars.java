package it.academy.ivan.entity;

public class Cars {
	private int car_id;
	private String model;
	private String year;
	private String color;
	
	public Cars() {
		
	}

	public Cars(int car_id) {
		this.car_id = car_id;
	}

	public Cars(int car_id, String model, String year, String color) {
		this.car_id = car_id;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	public Cars(String model, String year, String color) {
		this.model = model;
		this.year = year;
		this.color = color;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
