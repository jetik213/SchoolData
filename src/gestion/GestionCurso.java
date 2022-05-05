package gestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.CallableStatement;

import entidades.CursoEntity;
import entidades.DocenteEntity;
import interfaces.CursoInterface;
import util.MySQLConexion;

public class GestionCurso implements CursoInterface{

	@Override
	public ArrayList<CursoEntity> listarCursos() {

		ArrayList<CursoEntity> listaCursos = new ArrayList<CursoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_listCurso}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				CursoEntity cursoEntity = 
						new CursoEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getInt(5),
								rs.getInt(6)
								);
				listaCursos.add(cursoEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listaCursos;
	}

	@Override
	public int registrarCurso(CursoEntity curso) {

		int resultado = 0;
		
		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_registrarCurso(?,?,?,?)}";
			csmt = cn.prepareCall(mysql);	
			csmt.setString(1, curso.getCurNombre());
			csmt.setInt(2, curso.getCurCiclo());
			csmt.setInt(3, curso.getCurCreditos());
			csmt.setInt(4, curso.getCurHoras());
			
			resultado = csmt.executeUpdate(); //devuelve 1 si la insercción fue correcta
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//liberar los recursos que hemos utilizado
			try {
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return resultado; 
	}

	@Override
	public int editarCurso(CursoEntity curso) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_actualizarCurso(?,?,?,?,?,?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, curso.getCurId());
			csmt.setString(2, curso.getCurNombre());
			csmt.setInt(3, curso.getCurCiclo());
			csmt.setInt(4, curso.getCurCreditos());
			csmt.setInt(5, curso.getCurHoras());
			csmt.setInt(6, curso.getCurEstado());
			
			
			resultado = csmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//liberar los recursos que hemos utilizado
			try {
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public int eliminarCurso(int idCurso) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_eliminarCurso(?)";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idCurso);
			
			resultado = csmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//liberar los recursos que hemos utilizado
			try {
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public ArrayList<CursoEntity> buscarCursos(int idCurso) {

		ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaCurso(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idCurso);
			rs = csmt.executeQuery();

			while (rs.next()) {
				CursoEntity cursoEntity = new CursoEntity();
				cursoEntity.setCurId(rs.getInt(1));
				cursoEntity.setCurNombre(rs.getString(2));
				cursoEntity.setCurCiclo(rs.getInt(3));
				cursoEntity.setCurCreditos(rs.getInt(4));
				cursoEntity.setCurHoras(rs.getInt(5));
				listaCurso.add(cursoEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listaCurso;
	}

	@Override
	public ArrayList<DocenteEntity> docenteCurso(int idCurso) {

		ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaDocenteCurso(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idCurso);
			rs = csmt.executeQuery();

			while (rs.next()) {
				DocenteEntity docenteEntity = new DocenteEntity(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getString(8),
						1
						);
				listaDocente.add(docenteEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listaDocente;
	}
	

}
