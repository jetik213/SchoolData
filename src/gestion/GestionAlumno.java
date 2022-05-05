package gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;



import entidades.AlumnoEntity;
import entidades.CursoEntity;
import interfaces.AlumnoInterface;
import util.MySQLConexion;

public class GestionAlumno implements AlumnoInterface{

	@Override
	public ArrayList<AlumnoEntity> listarAlumnos() {

		ArrayList<AlumnoEntity> listaAlumnos = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_listAlumno}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				AlumnoEntity alumnoEntity = 
						new AlumnoEntity(
								rs.getInt(1), //Se puede poner el nobre de la columna como lo hizo el profesor en clase, o también el número de columna como yo lo e puesto acá, ustedes elijan
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getInt(8)
								);
				listaAlumnos.add(alumnoEntity);
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
		
		return listaAlumnos;
	}

	@Override
	public int registrarAlumno(AlumnoEntity alumno) {

		int resultado = 0;
		
		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_registrarAlumno(?,?,?,?,?,?)}";
			csmt = cn.prepareCall(mysql);	
			csmt.setString(1, alumno.getNombres());
			csmt.setString(2, alumno.getApellidoPaterno());
			csmt.setString(3, alumno.getApellidoMaterno());
			csmt.setString(4, alumno.getDni());
			csmt.setInt(5, alumno.getEdad());
			csmt.setString(6, alumno.getCelular());
			
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
	public int editarAlumno(AlumnoEntity alumno) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_actualizarAlumno(?,?,?,?,?,?,?,?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, alumno.getId());
			csmt.setString(2, alumno.getNombres());
			csmt.setString(3, alumno.getApellidoPaterno());
			csmt.setString(4, alumno.getApellidoMaterno());
			csmt.setString(5, alumno.getDni());
			csmt.setInt(6, alumno.getEdad());
			csmt.setString(7, alumno.getCelular());
			csmt.setInt(8, alumno.getEstado());
			
			
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
	public int eliminarAlumno(int idAlumno) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_eliminarAlumno(?)";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idAlumno);
			
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
	public ArrayList<AlumnoEntity> buscarAlumnos(int idAlumno) {

		ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_buscarAlumnoActivo(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idAlumno); 
			rs = csmt.executeQuery();
			//int id, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, int edad,
			//String celular, int estado
			while (rs.next()) {
				AlumnoEntity alumnoEntity = 
						new AlumnoEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getInt(8)
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
	public ArrayList<CursoEntity> cursosAlumnoMatriculado(int idAlumno) {

		ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaCursoAlumno(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idAlumno); 
			rs = csmt.executeQuery();
			//int id, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, int edad,
			//String celular, int estado
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
	public ArrayList<AlumnoEntity> listarAlumnosMatriculaPendiente() {

		ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteAlumnosMatriculaPendiente}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();
			
			while (rs.next()) {
				AlumnoEntity alumnoEntity = 
						new AlumnoEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getInt(8)
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
	public ArrayList<AlumnoEntity> listarAlumnosMatriculaVigente() {

		ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteAlumnosMatriculaVigente}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();
			
			while (rs.next()) {
				AlumnoEntity alumnoEntity = 
						new AlumnoEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getInt(8)
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
	public ArrayList<AlumnoEntity> listarAlumnosRetirados() {

		ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();

		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteAlumnosRetirados}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();
			
			while (rs.next()) {
				AlumnoEntity alumnoEntity = 
						new AlumnoEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6),
								rs.getString(7),
								rs.getInt(8)
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

}
