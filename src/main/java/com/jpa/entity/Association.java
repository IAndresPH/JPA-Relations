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
@Table(name = "association")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;
    private String president;

    /*
    Relación uno a muchos: Una asociación puede tener muchos clubes.
    La clave primaria de Association (id) pasa a ser foránea en la entidad Club.
    */
    @OneToMany(mappedBy = "association", targetEntity = Club.class, fetch = FetchType.LAZY)
    private List<Club> clubList = new ArrayList<>();
}