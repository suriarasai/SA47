package sample.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sample.exception.NotFoundException;
import sample.model.User;

/**
 * User Data Access Object (DAO). This class contains all database handling that
 * is needed to permanently store and retrieve User object instances.
 */
public class UserDaoImpl implements UserDao {
	/* (non-Javadoc)
	 * @see dao.UserDao#createValueObject()
	 */
	@Override
	public User createValueObject() {
		return new User();
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#getObject(java.sql.Connection, java.lang.String)
	 */
	@Override
	public User getObject(Connection conn, String userId)
			throws NotFoundException, SQLException {

		User valueObject = createValueObject();
		valueObject.setUserId(Long.getLong(userId));
		load(conn, valueObject);
		return valueObject;
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#load(java.sql.Connection, model.User)
	 */
	@Override
	public void load(Connection conn, User valueObject)
			throws NotFoundException, SQLException {

		if (valueObject.getUserId() == null) {
			// System.out.println("Can not select without Primary-Key!");
			throw new NotFoundException("Can not select without Primary-Key!");
		}

		String sql = "SELECT * FROM USER WHERE (userid = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, valueObject.getUserId());

			singleQuery(conn, stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#loadAll(java.sql.Connection)
	 */
	@Override
	public ArrayList<User> loadAll(Connection conn) throws SQLException {

		String sql = "SELECT * FROM USER ORDER BY userid ASC ";
		ArrayList<User> searchResults = listQuery(conn, conn.prepareStatement(sql));

		return searchResults;
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#create(java.sql.Connection, model.User)
	 */
	@Override
	public synchronized void create(Connection conn, User valueObject)
			throws SQLException {

		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO USER ( name, password, role, "
					+ "mgrid) VALUES (?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, valueObject.getName());
			stmt.setString(2, valueObject.getPassword());
			stmt.setString(3, valueObject.getRole());
			stmt.setLong(4, valueObject.getMgrId());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

		/**
		 * The following query will read the automatically generated primary key
		 * back to valueObject. This must be done to make things consistent for
		 * upper layer processing logic.
		 */
		sql = "SELECT last_insert_id()";

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setUserId(new Long(result.getLong(1)));

			} else {
				// System.out.println("Unable to find primary-key for created object!");
				throw new SQLException(
						"Unable to find primary-key for created object!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

	}

	/* (non-Javadoc)
	 * @see dao.UserDao#save(java.sql.Connection, model.User)
	 */
	@Override
	public void save(Connection conn, User valueObject)
			throws NotFoundException, SQLException {

		String sql = "UPDATE USER SET name = ?, password = ?, role = ?, "
				+ "mgrid = ? WHERE (userid = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getName());
			stmt.setString(2, valueObject.getPassword());
			stmt.setString(3, valueObject.getRole());
			stmt.setLong(4, valueObject.getMgrId());

			stmt.setLong(5, valueObject.getUserId());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be saved! (PrimaryKey not found)");
				throw new NotFoundException(
						"Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
				throw new SQLException(
						"PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#delete(java.sql.Connection, model.User)
	 */
	@Override
	public void delete(Connection conn, User valueObject)
			throws NotFoundException, SQLException {

		if (valueObject.getUserId() == null) {
			// System.out.println("Can not delete without Primary-Key!");
			throw new NotFoundException("Can not delete without Primary-Key!");
		}

		String sql = "DELETE FROM USER WHERE (userid = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, valueObject.getUserId());

			int rowcount = databaseUpdate(conn, stmt);
			if (rowcount == 0) {
				// System.out.println("Object could not be deleted (PrimaryKey not found)");
				throw new NotFoundException(
						"Object could not be deleted! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
				throw new SQLException(
						"PrimaryKey Error when updating DB! (Many objects were deleted!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#deleteAll(java.sql.Connection)
	 */
	@Override
	public void deleteAll(Connection conn) throws SQLException {

		String sql = "DELETE FROM USER";
		PreparedStatement stmt = null;
		int rowcount = 0;
		try {
			stmt = conn.prepareStatement(sql);
			rowcount = databaseUpdate(conn, stmt);
		} finally {
			System.out.println("Rows Affected"+rowcount);
			if (stmt != null)
				stmt.close();
		}
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#countAll(java.sql.Connection)
	 */
	@Override
	public int countAll(Connection conn) throws SQLException {

		String sql = "SELECT count(*) FROM USER";
		PreparedStatement stmt = null;
		ResultSet result = null;
		int allRows = 0;

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next())
				allRows = result.getInt(1);
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
		return allRows;
	}

	/* (non-Javadoc)
	 * @see dao.UserDao#searchMatching(java.sql.Connection, model.User)
	 */
	@Override
	public ArrayList<User> searchMatching(Connection conn, User valueObject)
			throws SQLException {

		ArrayList<User> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM USER WHERE 1=1 ");

		if (valueObject.getUserId() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND userid LIKE '").append(valueObject.getUserId())
					.append("%' ");
		}

		if (valueObject.getName() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND name LIKE '").append(valueObject.getName())
					.append("%' ");
		}

		if (valueObject.getPassword() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND password LIKE '").append(valueObject.getPassword())
					.append("%' ");
		}

		if (valueObject.getRole() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND role LIKE '").append(valueObject.getRole())
					.append("%' ");
		}

		if (valueObject.getMgrId() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND mgrid LIKE '").append(valueObject.getMgrId())
					.append("%' ");
		}

		sql.append("ORDER BY userid ASC ");

		// Prevent accidential full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<User>();
		else
			searchResults = listQuery(conn,
					conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	/**
	 * databaseUpdate-method. This method is a helper method for internal use.
	 * It will execute all database handling that will change the information in
	 * tables. SELECT queries will not be executed here however. The return
	 * value indicates how many rows were affected. This method will also make
	 * sure that if cache is used, it will reset when data changes.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
	 */
	protected int databaseUpdate(Connection conn, PreparedStatement stmt)
			throws SQLException {

		int result = stmt.executeUpdate();

		return result;
	}

	/**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return only one row. The
	 * resultset will be converted to valueObject. If no rows were found,
	 * NotFoundException will be thrown.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
	 * @param valueObject
	 *            Class-instance where resulting data will be stored.
	 */
	protected void singleQuery(Connection conn, PreparedStatement stmt,
			User valueObject) throws NotFoundException, SQLException {

		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setUserId(result.getLong("userid"));
				valueObject.setName(result.getString("name"));
				valueObject.setPassword(result.getString("password"));
				valueObject.setRole(result.getString("role"));
				valueObject.setMgrId(result.getLong("mgrid"));

			} else {
				// System.out.println("User Object Not Found!");
				throw new NotFoundException("User Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}

	/**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return multiple rows. The
	 * resultset will be converted to the List of valueObjects. If no rows were
	 * found, an empty List will be returned.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
	 */
	protected ArrayList<User> listQuery(Connection conn, PreparedStatement stmt)
			throws SQLException {

		ArrayList<User> searchResults = new ArrayList<User>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				User temp = createValueObject();

				temp.setUserId(result.getLong("userid"));
				temp.setName(result.getString("name"));
				temp.setPassword(result.getString("password"));
				temp.setRole(result.getString("role"));
				temp.setMgrId(result.getLong("mgrid"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return  searchResults;
	}

}
