package com.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera clave primaria automáticamente
    private Integer id;
    private String name;

    /*
    Relación uno a uno: Un club tiene un entrenador.
    La clave primaria de una de las tablas pasa a ser foránea de la otra tabla.
    Especificamos explícitamente la clase y cuando la entidad independiente se guarde, también lo hará la entidad relacionada.
    */
    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    private Coach coach;

    /*
    Relación uno a muchos: Un club puede tener muchos jugadores.
    La clave primaria de Club (id) pasa a ser foránea en la entidad Player.
    Mapeamos la relación con el atributo "club" en la clase Player.
    */
    @OneToMany(mappedBy = "club", targetEntity = Player.class, fetch = FetchType.LAZY)
    private List<Player> playerList = new ArrayList<>();

    /*
    Relación muchos a uno: Muchos clubes pueden pertenecer a una asociación.
    La clave primaria de Association (id) pasa a ser foránea en la entidad Club.
    */
    @ManyToOne(targetEntity = Association.class)
    private Association association;

    /*
    Relación muchos a muchos: Muchos clubes pueden participar en muchas competiciones.
    Se utiliza una tabla intermedia (fk_club_competition) para manejar la relación.
    */
    @ManyToMany(targetEntity = Competition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "fk_club_competition", joinColumns = @JoinColumn(name = "fk_club_id"), inverseJoinColumns = @JoinColumn(name = "fk_competition_id"))
    private List<Competition> competitionList = new ArrayList<>();
}