package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		ArrayList<Student> result = (ArrayList<Student>) query.getResultList();
		return result;

	}

	@Override
	public Student findByID(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public int removeStudent(int id) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		Query q2 = em.createQuery("FROM Student s WHERE s.id = :id").setParameter("id", id);
		Student s = (Student) q2.getSingleResult();
		em.remove(s); // delete entity
		em.getTransaction().commit();
		return 0;
	}

}
