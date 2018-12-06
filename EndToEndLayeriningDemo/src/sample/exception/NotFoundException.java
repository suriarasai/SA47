package sample.exception;

/**
 * NotFoundException exception. This exception will be thrown from Dao object if
 * load, update or delete for one object fails to find the correct row.
 * 
 * NOTE: You will need only one instance of this class to use multiple DaoGen
 * generated objects.
 */

@SuppressWarnings("serial")
public class NotFoundException extends Exception {

	/**
	 * Constructor for NotFoundException. The input message is returned in
	 * toString() message.
	 */
	public NotFoundException(String msg) {
		super(msg);
	}

}
