package com.teste.santander.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.santander.model.entity.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    Page<Historico> findAllByClienteId(Pageable pageable, Long id);

    Page<Historico> findAllByDataMovimentacao(Pageable pageable, LocalDate data);
    
}
