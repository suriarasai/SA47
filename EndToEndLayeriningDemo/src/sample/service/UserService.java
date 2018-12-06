package sample.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import sample.dao.DaoFactory;
import sample.dao.UserDao;
import sample.exception.NotFoundException;
import sample.model.User;

public class UserService {
	private UserDao udao;
	private Connection conn;

	public UserService() throws NotFoundException {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "password");
			this.udao = DaoFactory.getUserDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Driver Fault");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("SQL Fault");
		}
	}

	public boolean authenticate(User u) throws NotFoundException {
		try {
			ArrayList<User> list = this.udao.searchMatching(this.conn, u);
			if (list.size() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<User> findUsers() throws NotFoundException {
		try {
			return (this.udao.loadAll(this.conn));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void createUser(User u) throws NotFoundException {
		try {
			this.udao.create(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void updateUser(User u) throws NotFoundException {
		try {
			this.udao.save(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}

	public void deleteUser(Long uid) throws NotFoundException {
		try {
			User u = new User();
			u.setUserId(uid);
			this.udao.load(this.conn, u);
			this.udao.delete(this.conn, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NotFoundException("Error in load all");
		}
	}
}
