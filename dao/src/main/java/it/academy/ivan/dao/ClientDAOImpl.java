package it.academy.ivan.dao;



import it.academy.ivan.entity.Client;
import it.academy.ivan.logger.PaymentSystemLogger;
import it.academy.ivan.dao.ClientType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements InterfaceDAO<Client> {

	public static final String SQL_QUERY_ADD_CLIENT = "INSERT INTO clients (fio,passport,login,password) VALUES (?,?,?,?)";
	public static final String SQL_QUERY_GET_CLIENTS = "SELECT * FROM clients";
	public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM clients WHERE login = ? AND password = ?";
	public static final String CHECK_ACCESS_LEVEL = "SELECT role FROM clients WHERE login = ?";
	public static final String GET_ALL_CLIENTS = "SELECT fio, passport FROM clients";

	private final static String USER_LOGIN = "user";
	private final static String USER_PASS = "123";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/carsrent";
	private static final String DBLOGIN = "root";
	private static final String DBPASSWORD = "root";
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;

	public ClientDAOImpl() {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DBURL, DBLOGIN, DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
		}
	}

	public void add(Client client) { //регистрация

		try {

			preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_CLIENT);
			preparedStatement.setString(1, client.getFio());
			preparedStatement.setString(2, client.getPassport());
			preparedStatement.setString(3, client.getLogin());
			preparedStatement.setString(4, client.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL exception occurred during add client");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL exception occurred during add client");
				e.printStackTrace();
			}
		}
	}

	public static int checkAdminLogin(String enterLogin, String enterPass) {

		return 1;
	}

	public static boolean checkUserLogin(String enterLogin, String enterPass) {
		return USER_LOGIN.equals(enterLogin) && USER_PASS.equals(enterPass);
	}

	public static boolean isAuthorized(String login, String password) {
		boolean isLogIn = false;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(CHECK_AUTHORIZATION);

			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				isLogIn = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isLogIn;
	}

	public static ClientType checkAccessLevel(String login) {
		ClientType userType = null;

		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(CHECK_ACCESS_LEVEL);

			statement.setString(1, login);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (0 == result.getInt("role")) {
					userType = ClientType.USER;
				} else {
					userType = ClientType.ADMINISTRATOR;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userType;
	}

	public List<Client> getFromDb() {
		List<Client> list = new ArrayList<Client>();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CLIENTS);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Client user = new Client();
				user.setFio(result.getString("fio"));
				user.setPassport(result.getString("passport"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public void delete(Client object) {

	}


}
