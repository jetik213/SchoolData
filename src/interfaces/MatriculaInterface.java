package interfaces;

import java.util.ArrayList;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.DocenteEntity;
import entidades.MatriculaEntity;

public interface MatriculaInterface {

	public ArrayList<MatriculaEntity> listarMatricula();
	
	public int registrarMatricula(MatriculaEntity matricula);
	
	public int editarMatricula(MatriculaEntity matricula);
	
	public int eliminarMatricula(int idMatricula);
	
	public String nombreAlumno(int idAlumno);
	
	public String nombreCurso(int idCurso);
	
	public String nombreDocente(int idDocente);
	
	public Boolean verificarMatricula(int idAlumno, int idCurso);
	
	public ArrayList<AlumnoEntity> consultaAlumnoMatricula(int idMatricula);
	
	public ArrayList<DocenteEntity> consultaDocenteMatricula(int idMatricula);
	
	public ArrayList<CursoEntity> consultaCursoMatricula(int idMatricula);
	
}
