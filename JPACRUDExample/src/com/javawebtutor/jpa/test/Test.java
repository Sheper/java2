package com.javawebtutor.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.javawebtutor.jpa.pojo.Employee;

public class Test {
	public static void main(String[] args) {
		 
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPACRUD");
 
		/* Create  Entity */
		Employee employee = new Employee();
		employee.setFirstname("Mukesh");
		employee.setLastname("Kumar");
		employee.setEmail("m@gmail.com");
		employee.setEmpId(12);
 
		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
 
		/* Persist entity */
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
 
		/* Retrieve entity */
		employee = em.find(Employee.class, 12);
		System.out.println(employee);
 
		/* Update entity */
		em.getTransaction().begin();
		employee.setFirstname("Ravi");
		System.out.println("Update Employee Name is  :- " + employee);
		em.getTransaction().commit();
 
		/* Remove entity */
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();
 
		/* Check whether enittiy is removed or not */
		employee = em.find(Employee.class, 12);
		System.out.println("Employee after removal :- " + employee);
 
	}
}

