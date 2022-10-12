package com.desarrollo.fullcar.services;

import com.desarrollo.fullcar.entities.Categoria;

import javax.transaction.Transactional;
import java.util.List;

//aca se anotan todos los metodos principales que necesitamos, la creacion,la optencion,actualizacion y eliminacion
// <E> aca va la entidad a llamar
public interface BaseService<E> {
    public List<E> findAll() throws Exception;

    public E findById(Long id) throws Exception;



    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
