package com.example.inicial1.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LibrosDTO {

    private Long id;
    private String titulo;
    private String genero;
    private String autor;
    private int paginas;
    private int fecha;


}
