package model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OneToMany;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Runner {
	public static void main(String[] args) {

		EntityManager em = PerThreadEntityManagers.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(new Tarea(new Date(), "Probando probando, probando mi amor por ti"));
		
		Tarea unaTarea = em.find(Tarea.class, new Long(1));
		
		System.out.println(unaTarea.getEnunciado());
		
		Asignacion unaAsignacion = new Asignacion(new Tarea(new Date(), "enunciado de prueba!!!"), Arrays.asList("bien", "muybien"));
		//como hariamos para que la asignacion deba ser de un alumno? (sino, su existencia no tiene sentido)
		em.persist(unaAsignacion);
		
		Alumno juan = new Alumno("1000000", "juan", "perezj@j.com", "juanpe", "perez", null);
		
		//hay un problema si se quiere usar asignarTarea, debe existir previamente la asignacion en la bd (cosa que nunca va a pasar porque se crea una new Asignacion())
		//juan.setAsignaciones(Arrays.asList(unaAsignacion));
		
		//ese problema se soluciona con @OneToMany(cascade = CascadeType.PERSIST) (y tambien funciona con .ALL)
		//pero el atributo cascade no esta en la tabla de annotations que pasaron...
		Asignacion asignacionJuan = juan.asignarTarea(unaTarea);
		
		//la tabla asignacion_notas no tiene PK...
		asignacionJuan.setNotas(Arrays.asList("mal"));
		
		//como se tiran queries? por ej.: si quiero obtener alguna asignacion de juan
		
		em.persist(juan);
		
		juan.setSecretCode("abasfa");
		
		try{
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}
}
