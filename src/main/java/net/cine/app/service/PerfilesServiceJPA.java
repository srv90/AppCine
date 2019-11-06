package net.cine.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cine.app.model.Perfil;
import net.cine.app.repository.PerfilesRepository;


@Service
public class PerfilesServiceJPA implements IPerfilesService {
	
	@Autowired
	private PerfilesRepository repo;


	@Override
	public void guardar(Perfil perfil) {
		// TODO Auto-generated method stub
		repo.save(perfil);
	}

	@Override
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void eliminar(int idPerfil) {
		// TODO Auto-generated method stub
		repo.deleteById(idPerfil);
	}

	@Override
	public Perfil buscarPorId(int idPerfil) {
		// TODO Auto-generated method stub
		Optional<Perfil> optional = repo.findById(idPerfil);
		if(optional.isPresent()) {
			return optional.get();
		}
 		return null;
	}

	@Override
	public void Actualizar(int id, String cuenta, String perfil) {
		// TODO Auto-generated method stub
		
		repo.Actualizar(cuenta, perfil, id);
	}






}
