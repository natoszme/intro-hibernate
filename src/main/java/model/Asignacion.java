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
	@CollectionTable(name = "Notas_Asignaciones")
	//TODO revisar nombres columnas
	//y para que no sea null?
	private List<String> notas;	
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tareaId")
	//y para que no sea null?
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
