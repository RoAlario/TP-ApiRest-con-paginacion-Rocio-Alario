package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

    List<Libro> findByTituloContainingOrGeneroContainingOrFechaOrPaginas(String titulo, String genero, int fecha, int paginas);

    Page<Libro> findByTituloContainingOrGeneroContainingOrFechaOrPaginas(String titulo, String genero, int fecha, int paginas, Pageable pageable);


    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro% OR l.genero LIKE %:filtro% OR l.fecha = :fecha OR l.paginas = :paginas")
    List<Libro> search(@Param("filtro") String filtro, @Param("fecha") int fecha, @Param("paginas") int paginas);


    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro% OR l.genero LIKE %:filtro% OR l.fecha = :fecha OR l.paginas = :paginas")
    Page<Libro> search(@Param("filtro") String filtro, @Param("fecha") int fecha, @Param("paginas") int paginas, Pageable pageable);


    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro% OR libro.genero LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro% OR libro.genero LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM libro",
            nativeQuery = true
    )
    Page<Libro> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}