package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base,ID extends Serializable>{
    //Lista de todas las personas que tenemos en la base de datos
    public List<E> findAll() throws Exception;

    public Page<E> findAll(Pageable pageable) throws  Exception;

    //Busca por ID a una persona o entidad
    public E findById(ID id) throws Exception;
    //Crear una nueva entidad
    public E save(E entity) throws Exception;
    //Actualiza una entidad
    public E update(ID id,E entity) throws Exception;
    //Elimina un registro de la base de datos
    public boolean delete(ID id) throws Exception;
}
