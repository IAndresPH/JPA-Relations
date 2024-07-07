package com.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name") // JPA crea la base de datos sin camel case
    private String firstName; // Nomenclatura para Java

    @Column(name = "last_name")
    private String lastName;

    private short age;
    private String nacionality;
    private String position;

    /*
    Relación muchos a uno: Muchos jugadores pueden pertenecer a un club.
    La clave primaria de Club (id) pasa a ser foránea en la entidad Player.
    */
    @ManyToOne(targetEntity = Club.class)
    private Club club;
}