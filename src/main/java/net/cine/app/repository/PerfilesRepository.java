package net.cine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import net.cine.app.model.Perfil;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
	
 @Modifying
 @Transactional
 @Query(nativeQuery = true, value = "UPDATE perfiles SET perfil = :perfil, cuenta = :cuenta  WHERE idUsuario = :idUsuario")	
 public void Actualizar(@Param("cuenta") String cuenta, @Param("perfil") String perfil, @Param("idUsuario") int id);

}
