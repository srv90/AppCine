package net.cine.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.cine.app.model.Pelicula;

public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {

	

	
	@Query(nativeQuery = true, value = "SELECT * FROM peliculas WHERE estatus = :estatus")
	public List<Pelicula> buscarActivas(@Param("estatus") String estatus);
}
