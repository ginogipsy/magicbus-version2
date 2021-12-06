package com.ginogipsy.magicbus.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordine_pagamento")
@Data
@EqualsAndHashCode(exclude = {"ordine", "tipologiaPagamento"})
public class OrdinePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordinepagamento_id")
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipologiapagamento_id")
    private TipologiaPagamento tipologiaPagamento;

    @Column(name = "pagato", columnDefinition = "TINYINT", length = 1)
    private Boolean pagato;

    @Column(name = "ora_pagamento")
    private Date oraPagamento;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;
}
