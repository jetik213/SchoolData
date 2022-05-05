package interfaces;

import java.util.ArrayList;

import entidades.CursoEntity;
import entidades.DocenteEntity;

public interface DocenteInterface {

	public ArrayList<DocenteEntity> listarDocentes();
	
	public int registrarDocente(DocenteEntity docente);
	
	public int editarDocente(DocenteEntity docente);
	
	public int eliminarDocente(int idDocente);
	
	public ArrayList<DocenteEntity> buscarDocentes(int idDocente);
	
	public ArrayList<CursoEntity> cursosDocente(int idDocente);
	
	public ArrayList<DocenteEntity> listarDocentesConHorarios();
}
