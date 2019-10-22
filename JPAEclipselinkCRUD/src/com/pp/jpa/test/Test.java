package com.pp.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import com.pp.jpa.pojo.Usuario;
 

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create EntityManagerFactory */
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("JPACRUD");
  
        /* Create  Entity */
        Usuario employee = new Usuario();
        employee.setNombre("Eclipselink");
        employee.setPassword("Eclipselink");
        employee.setEmail("@Eclipselink");
        employee.setSexo("tecnologia");
        employee.setPais("mundial");
  
        /* Create EntityManager */
        EntityManager em = emf.createEntityManager();
  
        /* Persist entity */
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
  
        /* Retrieve entity */
        employee = em.find(Usuario.class, 29);
        System.out.println(employee);
  
        /* Update entity */
        em.getTransaction().begin();
        employee.setNombre("Update Eclipselink");
        employee.setPassword("Update Eclipselink");
        employee.setEmail("Update @Eclipselink");
        employee.setSexo("Update tecnologia");
        employee.setPais("Update mundial");
        System.out.println("Update Employee Name is  :- " + employee);
        em.getTransaction().commit();
  
        /* Remove entity */
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
  
        /* Check whether enittiy is removed or not */
        employee = em.find(Usuario.class, 28);
        System.out.println("Employee after removal :- " + employee);
	}

}
