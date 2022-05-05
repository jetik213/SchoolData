package gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.RetiroEntity;
import interfaces.RetiroInterface;
import util.MySQLConexion;

public class GestionRetiro implements RetiroInterface{

	@Override
	public ArrayList<RetiroEntity> listarRetiro() {

		ArrayList<RetiroEntity> listaRetiros = new ArrayList<RetiroEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_listRetiro}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				RetiroEntity alumnoEntity = 
						new RetiroEntity(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDate(5),
								rs.getInt(6)
								);
				listaRetiros.add(alumnoEntity);
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
		
		return listaRetiros;
	}

	@Override
	public int registrarRetiro(RetiroEntity retiro) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_registrarRetiro(?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, retiro.getMatId());
			
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
	public int editarRetiro(RetiroEntity retiro) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_actualizarRetiro(?,?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, retiro.getMatId());			
			csmt.setInt(2, retiro.getMatEstado());
			
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
	public int eliminarRetiro(int idRetiro) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_eliminarRetiro(?)";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idRetiro);
			
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
	public String nombreAlumno(int idAlumno) {

		String nomAlumno = "";
		
		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_nombreAlumno(?)}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idAlumno);
			rs = csmt.executeQuery();

			if (rs.next()) {
				AlumnoEntity entity = new AlumnoEntity(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3)
						);
				nomAlumno = entity.getNombres()+" "+entity.getApellidoPaterno()+" "+entity.getApellidoMaterno();
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
		
		return nomAlumno;
	}

	@Override
	public String nombreCurso(int idCurso) {

		String nomCurso = "";
		
		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_nombreCurso(?)}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idCurso);
			rs = csmt.executeQuery();

			if (rs.next()) {
				CursoEntity entity = new CursoEntity();
				entity.setCurNombre(rs.getString(1));
				nomCurso = entity.getCurNombre();
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
		
		return nomCurso;
	}

	@Override
	public ArrayList<AlumnoEntity> consultaAlumnoMatricula(int idMatricula) {

		ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaAlumnoMatricula(?,?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idMatricula);
			csmt.setInt(2, 0);
			rs = csmt.executeQuery();

			while (rs.next()) {
				AlumnoEntity alumnoEntity = new AlumnoEntity(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7),
						1
						);
				listaAlumno.add(alumnoEntity);
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
		
		return listaAlumno;
	}

	@Override
	public ArrayList<CursoEntity> consultaCursoMatricula(int idMatricula) {

		ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaCursoMatricula(?,?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idMatricula);
			csmt.setInt(2, 0);
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
	
}
