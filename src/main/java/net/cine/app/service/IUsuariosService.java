package net.cine.app.service;

import java.util.List;

import net.cine.app.model.Usuario;

public interface IUsuariosService {

	
	void guardar(Usuario usuario);
	Usuario buscarPorId(int idUsuario);
	void eliminar(int idUsuario);
	List<Usuario> buscarTodos();
}
