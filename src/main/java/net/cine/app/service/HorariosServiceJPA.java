package net.cine.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.cine.app.model.Horario;
import net.cine.app.model.Pelicula;
import net.cine.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService {
	


	@Autowired
	private HorariosRepository repo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {

		return repo.buscarPorIdYFecha(idPelicula, fecha);
	}

	@Override
	public void eliminar(int idHorario) {
		// TODO Auto-generated method stub
		repo.deleteById(idHorario);
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		repo.save(horario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		// TODO Auto-generated method stub
		Optional<Horario> optional = repo.findById(idHorario);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("fecha").and(Sort.by("hora")));
	}

	@Override
	public Page<Horario> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return repo.findAll(page);
	}

	@Override
	public void insertarHorarios() {

		List<Horario> horarios = new ArrayList<>();

		Pelicula pelicula = new Pelicula();
		pelicula.setId(9);
		Pelicula pelicula1 = new Pelicula();
		pelicula1.setId(12);
		Pelicula pelicula2 = new Pelicula();
		pelicula2.setId(13);
		Pelicula pelicula3 = new Pelicula();
		pelicula3.setId(14);
		
		Horario horario1 = new Horario(new Date(), "19:30", "Sala 1", 500, pelicula);
		Horario horario2 = new Horario(new Date(), "20:30", "Sala 2", 500, pelicula1);
		Horario horario3 = new Horario(new Date(), "21:30", "Premium", 1000, pelicula2);	
		Horario horario4 = new Horario(new Date(), "19:30", "Sala 3", 500, pelicula);
		Horario horario5 = new Horario(new Date(), "22:30", "Sala 1", 500, pelicula1);
		Horario horario6 = new Horario(new Date(), "21:30", "Premium", 1000, pelicula2);	
		Horario horario19 = new Horario(new Date(), "23:30", "Sala 1", 500, pelicula3);
		Horario horario20 = new Horario(new Date(), "23:30", "Premium", 1000, pelicula3);		
		
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		

		Horario horario7 = new Horario(dt, "19:30", "Sala 2", 500, pelicula);
		Horario horario8 = new Horario(dt, "20:30", "Premium", 1000, pelicula1);
		Horario horario9 = new Horario(dt, "21:30", "Sala 1", 500, pelicula2);
		Horario horario10 = new Horario(dt, "19:30", "Sala 3", 500, pelicula);
		Horario horario11= new Horario(dt, "22:30", "Sala 1", 500, pelicula1);
		Horario horario12= new Horario(dt, "21:30", "Premium", 1000, pelicula2);	
		Horario horario21= new Horario(dt, "23:30", "Sala 1", 500, pelicula3);
		Horario horario22= new Horario(dt, "23:30", "Premium", 1000, pelicula3);	
		
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		
		Horario horario13 = new Horario(dt, "19:30", "Premium", 1000, pelicula);
		Horario horario14 = new Horario(dt, "20:30", "Sala 2", 500, pelicula1);
		Horario horario15= new Horario(dt, "21:30", "Premium", 1000, pelicula2);
		Horario horario16 = new Horario(dt, "19:30", "Sala 3", 500, pelicula);
		Horario horario17 = new Horario(dt, "22:30", "Sala 1", 500, pelicula1);
		Horario horario18 = new Horario(dt, "21:30", "Premium", 1000, pelicula2);	
		Horario horario23 = new Horario(dt, "23:30", "Sala 1", 500, pelicula3);
		Horario horario24 = new Horario(dt, "23:30", "Premium", 1000, pelicula3);	
		
		horarios.add(horario1);
		horarios.add(horario2);
		horarios.add(horario3);
		horarios.add(horario4);
		horarios.add(horario5);
		horarios.add(horario6);
		horarios.add(horario7);
		horarios.add(horario8);	 
		horarios.add(horario9);
		horarios.add(horario10);
		horarios.add(horario11);
		horarios.add(horario12);
		horarios.add(horario13);
		horarios.add(horario14);
		horarios.add(horario15);
		horarios.add(horario16);
		horarios.add(horario17);	 
		horarios.add(horario18);
		horarios.add(horario19);
		horarios.add(horario20);
		horarios.add(horario21);
		horarios.add(horario22);
		horarios.add(horario23);	 
		horarios.add(horario24);
		
		repo.saveAll(horarios);

	}

}
