package onetomanybi;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.PersistanceManager;

public class TestEDMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = PersistanceManager.INSTANCE.getEntityManager();
		System.out.println("Print ALL");
		Query query = em.createQuery("FROM EmployeeOM2 e where e.depart.did=1");
		
	}

}
