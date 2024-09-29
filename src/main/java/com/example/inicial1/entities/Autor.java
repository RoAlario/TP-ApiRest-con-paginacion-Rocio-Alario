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
@Table(name = "Autor")
public class Autor extends Base{


    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "Biografia", length = 1500)
    private String biografia;

 /*   @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros; */
}
