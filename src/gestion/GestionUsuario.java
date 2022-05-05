package gestion;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.UsuarioEntity;
import interfaces.UsuarioInterface;
import util.MySQLConexion;

public class GestionUsuario implements UsuarioInterface{

	@Override
	public Boolean verificarLogin(String usuario, String clave) {

		boolean login = false;

		Connection cn = null;
		PreparedStatement psmt= null;
		ResultSet rs = null;
		
		cn = MySQLConexion.getConexion();

		String mysql = "SELECT * FROM usuario WHERE usu_usuario = ? and usu_contra = ?"; 
		
		try {
			psmt = cn.prepareStatement(mysql);
			psmt.setString(1, usuario);
			psmt.setString(2, clave);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				login = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//liberar los recursos que hemos utilizado
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return login;
	}

	@Override
	public int registrarUsuario(UsuarioEntity usuario) {

		int resultado = 0;
		
		Connection cn = null;
		FileInputStream fi = null;
		CallableStatement csmt = null;
		
		try {
			File file = new File(usuario.getRutaFoto()); //pasamos la ruta
			fi = new FileInputStream(file); //lee la imagen en bytes
						
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_registrarUsuario(?,?,?,?,?)}";
			csmt = cn.prepareCall(mysql);	
			csmt.setString(1, usuario.getUsuario());
			csmt.setString(2, usuario.getContra());
			csmt.setString(3, usuario.getNombre());
			csmt.setInt(4, usuario.getTipo());
			csmt.setBinaryStream(5, fi);
			
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
	public ArrayList<UsuarioEntity> datosUsuario(String usuario) {

		ArrayList<UsuarioEntity> listaUsuarios = new ArrayList<UsuarioEntity>();

		Connection cn = null;
		
		CallableStatement csmt = null;
		ResultSet rs = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String mysql = "{call usp_listUsuario(?)}";
			csmt = cn.prepareCall(mysql);
			csmt.setString(1, usuario);
			rs = csmt.executeQuery();

			while (rs.next()) {
				UsuarioEntity usuarioEntity = new UsuarioEntity();
				usuarioEntity.setUsuario(rs.getString(2));
				usuarioEntity.setContra(rs.getString(3));
				usuarioEntity.setNombre(rs.getString(4));
				usuarioEntity.setTipo(rs.getInt(5));
				usuarioEntity.setBlob(rs.getBlob(6));

				listaUsuarios.add(usuarioEntity);
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
		
		return listaUsuarios;
	}


}
