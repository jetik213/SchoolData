package entidades;


public class AlumnoEntity extends PersonaEntity{
	
	private int edad;
	//int id, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, int edad,String celular, int estado
	public AlumnoEntity(int id, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, int edad,
			String celular, int estado) {
		super(id, nombres, apellidoPaterno, apellidoMaterno, dni, celular, estado);
		this.edad = edad;
	}
	
	public AlumnoEntity(String nombres, String apellidoPaterno, String apellidoMaterno, String dni, int edad,
			String celular) {
		super(nombres, apellidoPaterno, apellidoMaterno, dni, celular);
		this.edad = edad;
	}
	
	public AlumnoEntity(String nombres, String apellidoPaterno, String apellidoMaterno) {
		super(nombres, apellidoPaterno, apellidoMaterno);
	}
	
	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	

}
