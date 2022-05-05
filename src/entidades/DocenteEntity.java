package entidades;

import java.util.Date;

public class DocenteEntity extends PersonaEntity {
	
	private Date fechaIngreso;
	private String especialidad;
	
	
	
	public DocenteEntity(String nombres, String apellidoPaterno, String apellidoMaterno, String dni, Date fechaIngreso , String celular, String especialidad) {
		super(nombres, apellidoPaterno, apellidoMaterno, dni, celular);
		this.fechaIngreso = fechaIngreso;
		this.especialidad = especialidad;
	}

	public DocenteEntity(int id, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, Date fechaIngreso,
			String celular, String especialidad, int estado) {
		super(id, nombres, apellidoPaterno, apellidoMaterno, dni, celular, estado);
		this.fechaIngreso = fechaIngreso;
		this.especialidad = especialidad;
	}
	
	public DocenteEntity(String nombres, String apellidoPaterno, String apellidoMaterno) {
		super(nombres, apellidoPaterno, apellidoMaterno);
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
