package interfaces;

import java.util.ArrayList;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.RetiroEntity;

public interface RetiroInterface {
	
	public ArrayList<RetiroEntity> listarRetiro();
	
	public int registrarRetiro(RetiroEntity retiro);
	
	public int editarRetiro(RetiroEntity retiro);
	
	public int eliminarRetiro(int idRetiro);
	
	public String nombreAlumno(int idAlumno);
	
	public String nombreCurso(int idCurso);
	
	public ArrayList<AlumnoEntity> consultaAlumnoMatricula(int idMatricula);
	
	public ArrayList<CursoEntity> consultaCursoMatricula(int idMatricula);

}
