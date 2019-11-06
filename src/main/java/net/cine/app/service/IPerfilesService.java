package net.cine.app.service;

import java.util.List;

import net.cine.app.model.Perfil;

public interface IPerfilesService {

	
	void guardar(Perfil perfil);
	List<Perfil> buscarTodos();
	void eliminar(int idPerfil);
	Perfil buscarPorId(int idPerfil);
	void Actualizar(int id, String cuenta, String perfil);

}
