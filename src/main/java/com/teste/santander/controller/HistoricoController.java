package com.teste.santander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.santander.model.entity.Historico;
import com.teste.santander.service.HistoricoService;

//import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    //@Operation(summary = "Operação para huscar historico completo de saque e deposito do cliente")
    public ResponseEntity<Page<Historico>> historico(Pageable pageable, @PathVariable Long id) {
        return ResponseEntity.ok().body(historicoService.buscarHistoricoPorIdCliente(pageable, id));
    }

    @GetMapping
    //@Operation(summary = "Operação para huscar historico completo de saque e deposito do cliente")
    public ResponseEntity<Page<Historico>> historicoPorData(Pageable pageable, @RequestParam("data") String data) {
        return ResponseEntity.ok().body(historicoService.buscarHistoricoPorData(pageable, data));
    }
    
}
