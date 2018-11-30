package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Staff;

public interface StaffDAO {
	
	public ArrayList<Staff> findAllSatt() throws ClassNotFoundException, SQLException;
	public int insertStaff(Staff s) throws ClassNotFoundException, SQLException;
	public int updateStaff(Staff s) throws ClassNotFoundException, SQLException;
	public int deleteStaff(Staff s) throws ClassNotFoundException, SQLException;
	

}
