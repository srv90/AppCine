package net.cine.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.cine.app.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {


  @Query(nativeQuery = true, value = "SELECT * FROM banners WHERE estatus = :estatus ORDER BY id LIMIT 4")
  public List<Banner> buscarUltimos4Activos(@Param("estatus") String estatus);

}


