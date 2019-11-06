package net.cine.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.cine.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {


	
	@Query(nativeQuery = true, value = "SELECT * FROM horarios WHERE idPelicula = :idPelicula AND fecha = :fecha ORDER BY hora")
	public List<Horario> buscarPorIdYFecha(@Param ("idPelicula") int idPelicula, @Param("fecha")Date fecha);
	
	
	@Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc")
	public List<Horario> findByFecha(@Param("fecha") Date fecha);
	

}
