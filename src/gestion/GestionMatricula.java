package gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.DocenteEntity;
import entidades.MatriculaEntity;
import interfaces.MatriculaInterface;
import util.MySQLConexion;

public class GestionMatricula implements MatriculaInterface{

	@Override
	public ArrayList<MatriculaEntity> listarMatricula() {

		ArrayList<MatriculaEntity> listaMatriculas = new ArrayList<MatriculaEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_listMatricula}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				MatriculaEntity alumnoEntity = 
						new MatriculaEntity(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getDate(5),
								rs.getInt(6)
								);
				listaMatriculas.add(alumnoEntity);
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
		
		return listaMatriculas;
	}

	@Override
	public int registrarMatricula(MatriculaEntity matricula) {

		int resultado = 0;
		
		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_registrarMatricula(?,?,?)}";
			csmt = cn.prepareCall(mysql);	
			csmt.setInt(1, matricula.getAluId());
			csmt.setInt(2, matricula.getCurId());
			csmt.setInt(3, matricula.getDocId());
			
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
	public int editarMatricula(MatriculaEntity matricula) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_actualizarMatricula(?,?,?,?,?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, matricula.getMatId());
			csmt.setInt(2, matricula.getAluId());
			csmt.setInt(3, matricula.getCurId());
			csmt.setInt(4, matricula.getDocId());
			
			Date dateSqlDate = new Date(matricula.getFecha().getTime());
			csmt.setDate(5, dateSqlDate);
			
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
	public int eliminarMatricula(int idMatricula) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_eliminarMatricula(?)";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idMatricula);
			
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
	public String nombreDocente(int idDocente) {

		String nomDocente = "";
		
		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_nombreDocente(?)}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idDocente);
			rs = csmt.executeQuery();

			if (rs.next()) {
				DocenteEntity entity = new DocenteEntity(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3)
						);
				nomDocente = entity.getNombres()+" "+entity.getApellidoPaterno()+" "+entity.getApellidoMaterno();
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
		
		return nomDocente;
	}

	@Override
	public Boolean verificarMatricula(int idAlumno, int idCurso) {
		
		boolean verificar = false;

		Connection cn = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
			
		String mysql = "{call usp_verificarMatricula(?,?)}";
		
		try {
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idAlumno);
			csmt.setInt(2, idCurso);
			
			rs = csmt.executeQuery(); //devuelve filas de datos
			
			if (rs.next()) { //rs.next() indica que tiene elementos que le van a permitir iterar
				verificar = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//liberar los recursos que hemos utilizado
			try {
				if (rs != null) rs.close();
				if (csmt != null) csmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return verificar;
	}

	//CONSULTAS
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
			csmt.setInt(2, 1);
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
	public ArrayList<DocenteEntity> consultaDocenteMatricula(int idMatricula) {

		ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaDocenteMatricula(?,?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idMatricula);
			csmt.setInt(2, 1);
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
			csmt.setInt(2, 1);
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
