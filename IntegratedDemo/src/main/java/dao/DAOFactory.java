package dao;

public class DAOFactory {
	
	public static StudentDAO getStudentDAO() {
			return new dao.jpa.StudentDAOImpl();
	
	}

}
