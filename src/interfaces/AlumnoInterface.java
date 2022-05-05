package interfaces;

import java.util.ArrayList;

import entidades.AlumnoEntity;
import entidades.CursoEntity;

public interface AlumnoInterface {

	public ArrayList<AlumnoEntity> listarAlumnos();
	
	public int registrarAlumno(AlumnoEntity alumno);
	
	public int editarAlumno(AlumnoEntity alumno);
	
	public int eliminarAlumno(int idAlumno);
	
	public ArrayList<AlumnoEntity> buscarAlumnos(int idAlumno);
	
	public ArrayList<CursoEntity> cursosAlumnoMatriculado(int idAlumno);
	
	public ArrayList<AlumnoEntity> listarAlumnosMatriculaPendiente();
	
	public ArrayList<AlumnoEntity> listarAlumnosMatriculaVigente();
	
	public ArrayList<AlumnoEntity> listarAlumnosRetirados();
}
