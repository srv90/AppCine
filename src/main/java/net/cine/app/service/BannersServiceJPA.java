package net.cine.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cine.app.model.Banner;
import net.cine.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService {

	@Autowired
	private BannersRepository repo;
	
	@Override
	public void insertar(Banner banner) {
		// TODO Auto-generated method stub
    repo.save(banner);
	}

	@Override
	public List<Banner> buscarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void eliminar(int idBanner) {
		// TODO Auto-generated method stub
        repo.deleteById(idBanner);
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		// TODO Auto-generated method stub
		Optional<Banner> optional =repo.findById(idBanner);
		if(optional.isPresent()){
			return optional.get();
		}
		return null ;
	}

	@Override
	public List<Banner> buscarActivos() {
		// TODO Auto-generated method stub
		return repo.buscarUltimos4Activos("Activo");
	}

}
