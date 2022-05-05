package gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.CursoEntity;
import entidades.DocenteEntity;
import interfaces.DocenteInterface;
import util.MySQLConexion;

public class GestionDocente implements DocenteInterface{

	@Override
	public ArrayList<DocenteEntity> listarDocentes() {

		ArrayList<DocenteEntity> listaDocentes = new ArrayList<DocenteEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_listDocente}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				DocenteEntity docenteEntity = 
						new DocenteEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getDate(6),
								rs.getString(7),
								rs.getString(8),
								rs.getInt(9)
								);
				listaDocentes.add(docenteEntity);
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
		
		return listaDocentes;
	}

	@Override
	public int registrarDocente(DocenteEntity docente) {

		int resultado = 0;
		
		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_registrarDocente(?,?,?,?,?,?,?)}";
			csmt = cn.prepareCall(mysql);	
			csmt.setString(1, docente.getNombres());
			csmt.setString(2, docente.getApellidoPaterno());
			csmt.setString(3, docente.getApellidoMaterno());
			csmt.setString(4, docente.getDni());
			Date dateSqlDate = new Date(docente.getFechaIngreso().getTime());
			csmt.setDate(5, dateSqlDate);
			csmt.setString(6, docente.getCelular());
			csmt.setString(7, docente.getEspecialidad());
			
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
	public int editarDocente(DocenteEntity docente) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_actualizarDocente(?,?,?,?,?,?,?,?,?)";
			
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, docente.getId());
			csmt.setString(2, docente.getNombres());
			csmt.setString(3, docente.getApellidoPaterno());
			csmt.setString(4, docente.getApellidoMaterno());
			csmt.setString(5, docente.getDni());
			Date dateSqlDate = new Date(docente.getFechaIngreso().getTime());
			csmt.setDate(6, dateSqlDate);
			csmt.setString(7, docente.getCelular());
			csmt.setString(8, docente.getEspecialidad());
			csmt.setInt(9, docente.getEstado());
			
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
	public int eliminarDocente(int idDocente) {

		int resultado = 0;
		
		Connection cn = null;
		CallableStatement csmt = null;
		
		try {
			cn = MySQLConexion.getConexion();
			String mysql = "call usp_eliminarDocente(?)";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idDocente);
			
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
	public ArrayList<DocenteEntity> buscarDocentes(int idDocente) {

		ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_consultaDocente(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setInt(1, idDocente);

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
	public ArrayList<CursoEntity> cursosDocente(int idDocente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocenteEntity> listarDocentesConHorarios() {

		ArrayList<DocenteEntity> listaDocentes = new ArrayList<DocenteEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteDocenteConHorarios}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();

			while (rs.next()) {
				DocenteEntity docenteEntity = 
						new DocenteEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getDate(6),
								rs.getString(7),
								rs.getString(8),
								rs.getInt(9)
								);
				listaDocentes.add(docenteEntity);
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
		
		return listaDocentes;
	}

}
