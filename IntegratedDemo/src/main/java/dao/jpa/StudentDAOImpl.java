package dao.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.StudentDAO;
import model.Student;
import util.PersistenceManager;

public class StudentDAOImpl implements StudentDAO {

	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	public StudentDAOImpl(Student s1) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Student> findAll() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query query = em.createQuery("FROM Student");
		ArrayList<Student> result = (ArrayList<Student>)query.getResultList();
		return result;
        
	}

	@Override
	public Student findByNRIC(String nric) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Student s = em.find(Student.class, nric);
		em.close();
 	    return s;
	}

	@Override
	public int createStudent(Student s) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		return 0;
	}

	@Override
	public int updateStudent(Student s) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		em.close();
		return 0;	
		
	}

	@Override
	public int removeStudent(String nric) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		Student s = em.find(Student.class, nric);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
		return 0;
	}

}
