package sample.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import sample.exception.NotFoundException;
import sample.model.User;

public interface UserDao {

	/**
	 * createValueObject-method. This method is used when the Dao class needs to
	 * create new value object instance. The reason why this method exists is
	 * that sometimes the programmer may want to extend also the valueObject and
	 * then this method can be overrided to return extended valueObject. NOTE:
	 * If you extend the valueObject class, make sure to override the clone()
	 * method in it!
	 */
	public abstract User createValueObject();

	/**
	 * getObject-method. This will create and load valueObject contents from
	 * database using given Primary-Key as identifier. This method is just a
	 * convenience method for the real load-method which accepts the valueObject
	 * as a parameter. Returned valueObject will be created using the
	 * createValueObject() method.
	 */
	public abstract User getObject(Connection conn, String userId)
			throws NotFoundException, SQLException;

	/**
	 * load-method. This will load valueObject contents from database using
	 * Primary-Key as identifier. Upper layer should use this so that
	 * valueObject instance is created and only primary-key should be specified.
	 * Then call this method to complete other persistent information. This
	 * method will overwrite all other fields except primary-key and possible
	 * runtime variables. If load can not find matching row, NotFoundException
	 * will be thrown.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param valueObject
	 *            This parameter contains the class instance to be loaded.
	 *            Primary-key field must be set for this to work properly.
	 */
	public abstract void load(Connection conn, User valueObject)
			throws NotFoundException, SQLException;

	/**
	 * LoadAll-method. This will read all contents from database table and build
	 * a List containing valueObjects. Please note, that this method will
	 * consume huge amounts of resources if table has lot's of rows. This should
	 * only be used when target tables have only small amounts of data.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 */
	public abstract ArrayList<User> loadAll(Connection conn)
			throws SQLException;

	/**
	 * create-method. This will create new row in database according to supplied
	 * valueObject contents. Make sure that values for all NOT NULL columns are
	 * correctly specified. Also, if this table does not use automatic
	 * surrogate-keys the primary-key must be specified. After INSERT command
	 * this method will read the generated primary-key back to valueObject if
	 * automatic surrogate-keys were used.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param valueObject
	 *            This parameter contains the class instance to be created. If
	 *            automatic surrogate-keys are not used the Primary-key field
	 *            must be set for this to work properly.
	 */
	public abstract void create(Connection conn, User valueObject)
			throws SQLException;

	/**
	 * save-method. This method will save the current state of valueObject to
	 * database. Save can not be used to create new instances in database, so
	 * upper layer must make sure that the primary-key is correctly specified.
	 * Primary-key will indicate which instance is going to be updated in
	 * database. If save can not find matching row, NotFoundException will be
	 * thrown.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param valueObject
	 *            This parameter contains the class instance to be saved.
	 *            Primary-key field must be set for this to work properly.
	 */
	public abstract void save(Connection conn, User valueObject)
			throws NotFoundException, SQLException;

	/**
	 * delete-method. This method will remove the information from database as
	 * identified by by primary-key in supplied valueObject. Once valueObject
	 * has been deleted it can not be restored by calling save. Restoring can
	 * only be done using create method but if database is using automatic
	 * surrogate-keys, the resulting object will have different primary-key than
	 * what it was in the deleted object. If delete can not find matching row,
	 * NotFoundException will be thrown.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param valueObject
	 *            This parameter contains the class instance to be deleted.
	 *            Primary-key field must be set for this to work properly.
	 */
	public abstract void delete(Connection conn, User valueObject)
			throws NotFoundException, SQLException;

	/**
	 * deleteAll-method. This method will remove all information from the table
	 * that matches this Dao and ValueObject couple. This should be the most
	 * efficient way to clear table. Once deleteAll has been called, no
	 * valueObject that has been created before can be restored by calling save.
	 * Restoring can only be done using create method but if database is using
	 * automatic surrogate-keys, the resulting object will have different
	 * primary-key than what it was in the deleted object. (Note, the
	 * implementation of this method should be different with different DB
	 * backends.)
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 */
	public abstract void deleteAll(Connection conn) throws SQLException;

	/**
	 * countAll-method. This method will return the number of all rows from table
	 * that matches this Dao. The implementation will simply execute
	 * "select count(primarykey) from table". If table is empty, the return
	 * value is 0. This method should be used before calling loadAll, to make
	 * sure table has not too many rows.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 */
	public abstract int countAll(Connection conn) throws SQLException;

	/**
	 * searchMatching-Method. This method provides searching capability to get
	 * matching valueObjects from database. It works by searching all objects
	 * that match permanent instance variables of given object. Upper layer
	 * should use this by setting some parameters in valueObject and then call
	 * searchMatching. The result will be 0-N objects in a List, all matching
	 * those criteria you specified. Those instance-variables that have NULL
	 * values are excluded in search-criteria.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param valueObject
	 *            This parameter contains the class instance where search will
	 *            be based. Primary-key field should not be set.
	 */
	public abstract ArrayList<User> searchMatching(Connection conn,
			User valueObject) throws SQLException;

}