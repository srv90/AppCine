package net.cine.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.cine.app.model.Horario;

public interface IHorariosService {

List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);	
void eliminar(int  idHorario);
void insertar(Horario horario);
Horario buscarPorId(int idHorario);
List<Horario> buscarTodos();
Page<Horario> buscarTodos(Pageable page);
void insertarHorarios();
	
}
