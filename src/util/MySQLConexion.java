package util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {

	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			
			String url = "jdbc:mysql://localhost/instituto?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String clave = "";
			con = DriverManager.getConnection(url, user, clave);
		} catch (ClassNotFoundException e) {
			System.out.println("MYSQL Conector: Clase no encontrada - " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("MYSQL Conector: Conexion fallida - " + e.getMessage());
		} catch (Exception e) {
			System.out.println("MYSQL Conector: Error General - " + e.getMessage());
		}
		
		return con;
		
	}
}
