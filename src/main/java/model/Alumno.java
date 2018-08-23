package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue
	@Column(name = "alumnoId")
	private long id;
	
	@Column(nullable = false)
	private String legajo;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;	
	
	private String secretCode;
	private String email;
	private String githubUser;
	
	@OneToMany(cascade = CascadeType.ALL)
	//arg mappedBy: como se usa?
	
	//falta que la FK alumnoId no sea nullable => nullable = false en @JoinColumn
	//el @JoinColumn evita crear la tabla alumno_asignacion!
	@JoinColumn(name = "alumnoId", nullable = false)
	private List<Asignacion> asignaciones = new ArrayList<>();
	//como hariamos para que la asignacion deba ser de un alumno? (sino, su existencia no tiene sentido) => con la FK en not nullable!
	
	@SuppressWarnings("unused")
	private Alumno() {}
	
	public Alumno(String legajo, String nombre, String email, String githubUser, String apellido, String secretCode) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.email = email;
		this.githubUser = githubUser;
		this.apellido = apellido;
		this.secretCode = secretCode;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	
	public Asignacion asignarTarea(Tarea tarea) {
		Asignacion asignacion = new Asignacion(tarea, Arrays.asList());
		this.asignaciones.add(asignacion);
		return asignacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
	
	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
