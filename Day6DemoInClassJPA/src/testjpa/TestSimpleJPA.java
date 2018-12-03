package testjpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import simple.Employee;
import util.PersistanceManager;

public class TestSimpleJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = PersistanceManager.INSTANCE.getEntityManager();
		Query query = em.createQuery("FROM Employee e");
		ArrayList<Employee> result = (ArrayList<Employee>)query.getResultList();
        for(Employee current: result)
        	System.out.println(current.toString());
	}

}
