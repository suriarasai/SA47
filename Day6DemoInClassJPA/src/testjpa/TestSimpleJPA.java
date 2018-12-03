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
		System.out.println("Print ALL");
		Query query = em.createQuery("FROM Employee e");
		ArrayList<Employee> result = (ArrayList<Employee>) query.getResultList();
		for (Employee current : result)
			System.out.println(current.toString());
		System.out.println("Print id = 3");
		Query query1 = em.createQuery("FROM Employee e where e.id=3");
		ArrayList<Employee> result1 = (ArrayList<Employee>) query1.getResultList();
		for (Employee current : result1)
			System.out.println(current.toString());
		System.out.println("Print Named Query ");
		ArrayList<Employee> result2 = (ArrayList<Employee>) em.createNamedQuery("Employee.searchAll").setParameter("empName", "D%")
				.getResultList();
		for (Employee current : result2)
			System.out.println(current.toString());
	}

}
