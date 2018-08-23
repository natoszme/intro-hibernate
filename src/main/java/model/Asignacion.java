package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Transient;

@Entity
public class Asignacion {

	@Id
	@GeneratedValue
	private long id;
	
	//lo comento porque sino no se persiste la nota
	//@Transient
	@ElementCollection
	//como se cambia el nombre de la columna 'Asignacion_id'?
	//y para que no sea null?
	@MapKeyColumn(name = "AsignacionId")
	private List<String> notas;	
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tareaId")
	//y para que no sea null?
	private Tarea tarea;
	
	private Asignacion() {}
	
	public Asignacion(Tarea tarea, List<String> notas) {
		this.tarea = tarea;
		this.notas = notas;
	}

	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
