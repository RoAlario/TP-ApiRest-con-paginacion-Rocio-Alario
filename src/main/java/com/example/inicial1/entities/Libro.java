package com.example.inicial1.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Audited



@Entity
@Table
public class Libro extends Base{


    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @Column(name = "autor")
    private String autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}
