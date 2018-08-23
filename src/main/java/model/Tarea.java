package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tareas")
public class Tarea {
	
	@Id
	@GeneratedValue
	@Column(name = "tareaId")
	private long id;
	
	@Column(nullable = false)
	private Date fechaLimiteDeEntrega;
	
	@Column(nullable = false)
	private String enunciado;
	
	//lo necesita hibernate para instanciarla
	@SuppressWarnings("unused")
	private Tarea() {}
	
	public Tarea(Date fechaLimiteDeEntrega, String enunciado) {
		super();
		this.fechaLimiteDeEntrega = fechaLimiteDeEntrega;
		this.enunciado = enunciado;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Date getFechaLimiteDeEntrega() {
		return fechaLimiteDeEntrega;
	}

	public void setFechaLimiteDeEntrega(Date fechaLimiteDeEntrega) {
		this.fechaLimiteDeEntrega = fechaLimiteDeEntrega;
	}

}
