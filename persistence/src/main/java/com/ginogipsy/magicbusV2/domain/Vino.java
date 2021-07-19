package com.ginogipsy.magicbusV2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;


@Data
@EqualsAndHashCode(exclude = "cantina", callSuper = false)
@Entity(name = "vino")
public class Vino{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vino_id")
    private Integer id;

    @Column(name = "qualita_vino")
    @Enumerated(EnumType.STRING)
    private QualitaVino qualitaVino;

    @Column(name = "nome", unique = true)
    private String nome;

    //@Lob(per grosse quantita', da implementare
    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "grado_alcolico")
    private Double gradoAlcolico;

    @Column(name = "costo")
    private Double costo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cantina_id")
    private Cantina cantina;

    @ManyToMany(mappedBy = "viniPreferiti")
    private Set<User> users;



}

