package net.cine.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.cine.app.model.Horario;
import net.cine.app.model.Pelicula;
import net.cine.app.repository.HorariosRepository;
import net.cine.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
    @Autowired	
	private HorariosRepository horariosRepo;
	
    @Autowired
	private PeliculasRepository peliculasRepo;
	
	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarPorFecha(Date fecha) {		
		List<Pelicula> peliculas = null;
		List<Horario> horarios = horariosRepo.findByFecha(fecha);
		peliculas = new LinkedList<>();

		for (Horario h : horarios) {
			peliculas.add(h.getPelicula());
		}		
		return peliculas;
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();		
	}

	@Override
	public List<Pelicula> buscarActivas() {
		List<Pelicula> peliculas = null;
		peliculas = peliculasRepo.buscarActivas("Activa");
		return peliculas;
	}

	
		
	@Override
	public Pelicula buscarPorId(int idPelicula) {	
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
		
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}
	
	
	@Override
	public List<String> buscarGeneros() {
		
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		generos.add("Thriller");
				
		return generos;
	}


	
}