package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario


    List<Autor> findByNombreContainingOrApellidoContainingOrBiografiaContaining(String nombre, String apellido, String biografia);


    Page<Autor> findByNombreContainingOrApellidoContainingOrBiografiaContaining(String nombre, String apellido,String biografia, Pageable pageable);


    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro% OR a.biografia LIKE %:filtro%")
    List<Autor> search(@Param("filtro")String filtro);


    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro% OR a.biografia LIKE %:filtro%")
    Page<Autor> search(@Param("filtro")String filtro, Pageable pageable);



    @Query(
            value = "SELECT * FROM autor WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro% OR biografia LIKE %:filtro%",
            nativeQuery = true
    )
    List<Autor> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM autor WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro% OR biografia LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM autor WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro% OR biografia LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Autor> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}