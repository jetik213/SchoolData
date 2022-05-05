package interfaces;

import java.util.ArrayList;

import entidades.UsuarioEntity;

public interface UsuarioInterface {
	
	public ArrayList<UsuarioEntity> datosUsuario(String usuario);
	
	public Boolean verificarLogin(String usuario, String clave);
	
	public int registrarUsuario(UsuarioEntity usuario);
}
