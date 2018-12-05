package dao;

import java.util.ArrayList;

import model.Mentor;

public interface MentorDAO {

	public ArrayList<Mentor> findAll();

	public Mentor findByID(int id);

	public int createStudent(Mentor m);

	public int updateStudent(Mentor m);

	public int removeStudent(int m);

}
