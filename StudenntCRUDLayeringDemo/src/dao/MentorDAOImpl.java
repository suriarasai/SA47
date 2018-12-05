package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Mentor;
import util.PersistenceManager;

public class MentorDAOImpl implements MentorDAO {

	public MentorDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Mentor> findAll() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query query = em.createQuery("FROM Mentor");
		ArrayList<Mentor> result = (ArrayList<Mentor>) query.getResultList();
		return result;
	}

	@Override
	public Mentor findByID(int id) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query query = em.createQuery("FROM Mentor m WHERE m.id = :id").setParameter("id", id);
		Mentor result = (Mentor) query.getSingleResult();
		return result;
	}

	@Override
	public int createStudent(Mentor m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudent(Mentor m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeStudent(int m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
