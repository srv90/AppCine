package net.cine.app.service;

import java.util.List;

import net.cine.app.model.Noticia;

public interface INoticiasService {

    void insertar(Noticia noticia);
    void eliminar (int idNoticia);
    List<Noticia> buscarTodas();
    List<Noticia> buscarPrimeras3Activas();
	Noticia buscarPorId(int idNoticia);

}
