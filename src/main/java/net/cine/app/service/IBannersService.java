package net.cine.app.service;

import java.util.List;

import net.cine.app.model.Banner;

public interface IBannersService {
	
	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	void eliminar(int idBanner);
	Banner buscarPorId(int idBanner);
	List<Banner> buscarActivos();

	


}
