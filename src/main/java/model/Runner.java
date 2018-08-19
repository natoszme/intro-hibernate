package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Runner {
	public static void main(String[] args) {

		EntityManager em = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		Tarea unaTarea = em.find(Tarea.class, new Long(1));
		
		System.out.println(unaTarea.getEnunciado());
		
	}
}
