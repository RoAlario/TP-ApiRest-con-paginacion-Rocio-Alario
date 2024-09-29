package com.example.inicial1.repositories;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario


    List<Domicilio> findByCalleContainingOrNumero(String calle, int numero);

    Page<Domicilio> findByCalleContainingOrNumero(String calle, int numero, Pageable pageable);


    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro% OR CAST(d.numero AS string) LIKE %:filtro%")
    List<Domicilio> search(@Param("filtro") String filtro);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro% OR CAST(d.numero AS string) LIKE %:filtro%")
    Page<Domicilio> search(@Param("filtro") String filtro, Pageable pageable);


    @Query(
            value = "SELECT * FROM domicilio WHERE calle LIKE %:filtro% OR CAST(numero AS CHAR) LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM domicilio WHERE calle LIKE %:filtro% OR CAST(numero AS CHAR) LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}