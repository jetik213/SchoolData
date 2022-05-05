package interfaces;

import java.util.ArrayList;

import entidades.CursoEntity;
import entidades.DocenteEntity;

public interface CursoInterface {
	
	public ArrayList<CursoEntity> listarCursos();
	
	public int registrarCurso(CursoEntity curso);
	
	public int editarCurso(CursoEntity curso);
	
	public int eliminarCurso(int idCurso);
	
	public ArrayList<CursoEntity> buscarCursos(int idCurso);
	
	public ArrayList<DocenteEntity> docenteCurso(int idCurso);
}
