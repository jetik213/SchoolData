package gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.ReporteEntity;
import interfaces.ReporteInterface;
import util.MySQLConexion;

public class GestionReporte implements ReporteInterface{

	@Override
	public ArrayList<ReporteEntity> listarCantidadMatriculaPorCurso() {
		ArrayList<ReporteEntity> listaReporte = new ArrayList<ReporteEntity>();

		Connection cn = null;
		
		//CON PROCEDURES
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		String mysql = "{call usp_reporteMatriculaPorCurso}";
		
		try {
			
			cn = MySQLConexion.getConexion();
			csmt = cn.prepareCall(mysql);
			rs = csmt.executeQuery();
			
			while (rs.next()) {
				ReporteEntity reporteEntity = 
						new ReporteEntity(
								rs.getInt(1),
								rs.getString(2),
								rs.getInt(3)
								);
				listaReporte.add(reporteEntity);
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
		
		return listaReporte;
	}

}
