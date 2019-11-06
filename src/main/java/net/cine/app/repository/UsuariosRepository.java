package net.cine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cine.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
