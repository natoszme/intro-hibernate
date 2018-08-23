package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Asignaciones")
public class Asignacion {

	@Id
	@GeneratedValue
	@Column(name = "asignacionId")
	private long id;
	
	@ElementCollection
	@CollectionTable(name = "Notas_Asignaciones", joinColumns = @JoinColumn(name = "asignacionId"))
	//y para que no sea null? => nullable = false en @Column
	@Column(name = "nota", nullable = false)
	private List<String> notas;	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tareaId", nullable = false)
	//y para que no sea null? => con el nullable = false en @JoinColumn
	private Tarea tarea;
	
	@SuppressWarnings("unused")
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
