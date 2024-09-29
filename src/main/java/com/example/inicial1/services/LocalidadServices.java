package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadServices extends BaseService<Localidad, Long>{

    List<Localidad> search(String filtro) throws Exception;

    Page<Localidad> search(String filtro, Pageable pageable) throws Exception;



}
