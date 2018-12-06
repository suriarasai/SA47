package sample.model;

import java.io.Serializable;

/**
 * User Value Object. This class is value object representing database table
 * USER This class is intented to be used together with associated Dao object.
 */
@SuppressWarnings("serial")
public class User implements Cloneable, Serializable {

	/**
	 * Persistent Instance variables. This data is directly mapped to the
	 * columns of database table.
	 */
	private Long userId;
	private String name;
	private String password;
	private String role;
	private Long mgrId;

	/**
	 * Constructors. DaoGen generates two constructors by default. The first one
	 * takes no arguments and provides the most simple way to create object
	 * instance. The another one takes one argument, which is the primary key of
	 * the corresponding table.
	 */

	public User() {

	}

	public User(Long userIdIn) {
		this.userId = userIdIn;
	}

	/**
	 * Get- and Set-methods for persistent variables. The default behaviour does
	 * not make any checks against malformed data, so these might require some
	 * manual additions.
	 */

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userIdIn) {
		this.userId = userIdIn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String passwordIn) {
		this.password = passwordIn;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String roleIn) {
		this.role = roleIn;
	}

	public Long getMgrId() {
		return this.mgrId;
	}

	public void setMgrId(Long mgrIdIn) {
		this.mgrId = mgrIdIn;
	}

	/**
	 * setAll allows to set all persistent variables in one method call. This is
	 * useful, when all data is available and it is needed to set the initial
	 * state of this object. Note that this method will directly modify instance
	 * variales, without going trough the individual set-methods.
	 */

	public void setAll(Long userIdIn, String nameIn, String passwordIn,
			String roleIn, Long mgrIdIn) {
		this.userId = userIdIn;
		this.name = nameIn;
		this.password = passwordIn;
		this.role = roleIn;
		this.mgrId = mgrIdIn;
	}

	/**
	 * hasEqualMapping-method will compare two User instances and return true if
	 * they contain same values in all persistent instance variables. If
	 * hasEqualMapping returns true, it does not mean the objects are the same
	 * instance. However it does mean that in that moment, they are mapped to
	 * the same row in database.
	 */
	public boolean hasEqualMapping(User valueObject) {

		if (this.userId == null) {
			if (valueObject.getUserId() != null)
				return (false);
		} else if (!this.userId.equals(valueObject.getUserId())) {
			return (false);
		}
		if (this.name == null) {
			if (valueObject.getName() != null)
				return (false);
		} else if (!this.name.equals(valueObject.getName())) {
			return (false);
		}
		if (this.password == null) {
			if (valueObject.getPassword() != null)
				return (false);
		} else if (!this.password.equals(valueObject.getPassword())) {
			return (false);
		}
		if (this.role == null) {
			if (valueObject.getRole() != null)
				return (false);
		} else if (!this.role.equals(valueObject.getRole())) {
			return (false);
		}
		if (this.mgrId == null) {
			if (valueObject.getMgrId() != null)
				return (false);
		} else if (!this.mgrId.equals(valueObject.getMgrId())) {
			return (false);
		}

		return true;
	}

	/**
	 * toString will return String object representing the state of this
	 * valueObject. This is useful during application development, and possibly
	 * when application is writing object states in textlog.
	 */
	public String toString() {
		StringBuffer out = new StringBuffer(" ");
		out.append("\nclass User, mapping to table USER\n");
		out.append("Persistent attributes: \n");
		out.append("userId = " + this.userId + "\n");
		out.append("name = " + this.name + "\n");
		out.append("password = " + this.password + "\n");
		out.append("role = " + this.role + "\n");
		out.append("mgrId = " + this.mgrId + "\n");
		return out.toString();
	}

	/**
	 * Clone will return identical deep copy of this valueObject. Note, that
	 * this method is different than the clone() which is defined in
	 * java.lang.Object. Here, the retuned cloned object will also have all its
	 * attributes cloned.
	 */
	public Object clone() {
		User cloned = new User();

		if (this.userId != null)
			cloned.setUserId(new Long(this.userId));
		if (this.name != null)
			cloned.setName(new String(this.name));
		if (this.password != null)
			cloned.setPassword(new String(this.password));
		if (this.role != null)
			cloned.setRole(new String(this.role));
		if (this.mgrId != null)
			cloned.setMgrId(new Long(this.mgrId));
		return cloned;
	}

}
