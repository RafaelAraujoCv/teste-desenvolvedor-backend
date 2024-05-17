package com.teste.santander.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.santander.model.entity.Historico;
import com.teste.santander.repository.HistoricoRepository;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public void criarHistorico(Historico historico) {
        historicoRepository.save(historico);
    }

    public void criarHistoricoOperacao(Historico historico) {
        historicoRepository.save(historico);
    }

    public Page<Historico> buscarHistoricoPorIdCliente(Pageable pageable, Long id) {
        return historicoRepository.findAllByClienteId(pageable, id);
    }

    public Page<Historico> buscarHistoricoPorData(Pageable pageable, String data) {
        return historicoRepository.findAllByDataMovimentacao(pageable, formatarData(data));
    }

    private LocalDate formatarData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate novaData = LocalDate.parse(data,formatter);
        return novaData;
    }
    
}
