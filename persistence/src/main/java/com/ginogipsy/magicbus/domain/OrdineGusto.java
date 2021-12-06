package com.ginogipsy.magicbus.domain;

import com.ginogipsy.magicbus.domain.enums.CategoriaProdotto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "ordine_gusto")
@Data
@EqualsAndHashCode(exclude = {"ordine", "gusto", "impasto"})
public class OrdineGusto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordinegusto_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gusto_id")
    private Gusto gusto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "impasto_id")
    private Impasto impasto;

    @Column(name = "quantita")
    private Double quantita;

    @Column(name = "annullato", columnDefinition = "TINYINT", length = 1)
    private Boolean annullato;

    @Column(name = "costo_totale")
    private Double costoTotale;

    public void setCostoTotale(){
        this.costoTotale = this.quantita * this.gusto.getCosto();
    }

    public void setImpasto(Impasto impasto){
        if(gusto.getCategoriaProdotto().equals(CategoriaProdotto.PIZZA) || gusto.getCategoriaProdotto().equals(CategoriaProdotto.CALZONE) || gusto.getCategoriaProdotto().equals(CategoriaProdotto.PANINO)){
            this.impasto = impasto;
            this.costoTotale = costoTotale + impasto.getCostoAggiuntivo()*this.quantita;
        }
    }
}

