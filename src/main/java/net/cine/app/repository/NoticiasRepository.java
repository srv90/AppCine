package net.cine.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.cine.app.model.Noticia;

@Repository()
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

@Query(nativeQuery = true, value = "SELECT  * FROM noticias WHERE estatus = :estatus ORDER BY id DESC LIMIT 3 ")
List<Noticia> buscarPrimeras3PorEstatus(@Param("estatus")String estatus);


}
