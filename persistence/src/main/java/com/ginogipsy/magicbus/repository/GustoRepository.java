package com.ginogipsy.magicbus.repository;

import com.ginogipsy.magicbus.domain.*;
import com.ginogipsy.magicbus.domain.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GustoRepository extends JpaRepository<Gusto, Integer> {

    Gusto findByNome(String nome);
    List<Gusto> findByStatus(Status status);
    List<Gusto> findByBase(Base base);
    List<Gusto> findByPeriodoDisponibilita(PeriodoDisponibilita periodoDisponibilita);
    List<Gusto> findByCategoriaProdotto(CategoriaProdotto categoriaProdotto);
    List<Gusto> findByDisponibileAndPeriodoDisponibilita(Boolean disponibile, PeriodoDisponibilita periodoDisponibilita);
    List<Gusto> findByDisponibileAndStatus(Boolean disponibile, Status status);
    List<Gusto> findByGustoUtente_InseritaDaUtente(Boolean inseritaDaUtente);
    List<Gusto> findByGustoUtente_InseritaDaUtenteAndStatus(Boolean inseritaDaUtente, Status status);
    List<Gusto> findByTipologiaMenuAndDisponibile(TipologiaMenu tipologiaMenu, Boolean disponibile);
}
