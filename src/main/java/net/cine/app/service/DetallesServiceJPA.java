package net.cine.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cine.app.model.Detalle;
import net.cine.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {

	@Autowired
	private DetallesRepository repo;
	@Override
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
	repo.save(detalle);	
	}

	
	
}