package it.academy.ivan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.entity.Client;
import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DAOCars implements InterfaceDAO<Cars> {

	public static final String SQL_QUERY_ADD_CAR = "INSERT INTO cars (model,year,color) VALUES (?,?,?)";
	public static final String SQL_QUERY_DELETE_CAR = "DELETE FROM cars WHERE car_id=";
	public static final String GET_ALL_CARS = "SELECT model, year, color FROM cars";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/carsrent";
	private static final String DBLOGIN = "root";
	private static final String DBPASSWORD = "root";
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	protected Transaction trans;


	public DAOCars() {

	}

	@Override
	public void add(Cars car) {

		Session sess = HibernateSessionManager.getSessionFactory().openSession();
		trans = sess.beginTransaction();
		sess.saveOrUpdate(car);
		sess.update(car);
		trans.commit();
	}

	@Override
	public List<Cars> getFromDb() {
		List<Cars> list = new ArrayList<Cars>();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CARS);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
			Cars car = new Cars();
				car.setModel(result.getString("model"));
				car.setYear(result.getString("year"));
				car.setColor(result.getString("color"));
				list.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public void delete(Cars car) {
		try {

			preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_CAR + car.getCar_id());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL exception occurred during add client");
			e.printStackTrace();
		}
	}


}
