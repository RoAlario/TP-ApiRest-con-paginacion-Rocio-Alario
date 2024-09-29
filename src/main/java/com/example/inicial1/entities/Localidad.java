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
public class Localidad extends  Base{


    @Column(name = "denominacion")
    private String denominacion;

    @OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL)
    private List<Domicilio> domicilios;
}
