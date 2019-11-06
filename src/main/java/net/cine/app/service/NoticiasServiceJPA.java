package net.cine.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cine.app.model.Noticia;
import net.cine.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	private NoticiasRepository repo;


	@Override
	public void insertar(Noticia noticia) {
		repo.save(noticia);

	}

	@Override
	public void eliminar(int idNoticia) {
        repo.deleteById(idNoticia);
	}

	@Override
	public List<Noticia> buscarTodas() {
		return repo.findAll();
	}

	@Override
	public List<Noticia> buscarPrimeras3Activas() {
		return repo.buscarPrimeras3PorEstatus("Activa");
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		Optional<Noticia> optional = repo.findById(idNoticia);
		return optional.get();
	}

}
