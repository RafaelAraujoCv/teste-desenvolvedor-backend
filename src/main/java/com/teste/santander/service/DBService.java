package com.teste.santander.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.santander.model.entity.Cliente;
import com.teste.santander.model.entity.Historico;
import com.teste.santander.repository.ClienteRepository;
import com.teste.santander.repository.HistoricoRepository;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private HistoricoRepository historicoRepository;

    public void instanciaDB() {
        Cliente cliente1 = new Cliente(null, "Rafael Araujo", true, new BigDecimal(500.00), "1234", LocalDate.now(), null);
        Cliente cliente2 = new Cliente(null, "Rafael Silva", false, new BigDecimal(2000.00), "5678", LocalDate.now(), null);

        Historico historico1 = new Historico("DEPOSITO", new BigDecimal(100.00), new BigDecimal(00), new BigDecimal(100.00), "Primeiro deposito", cliente1);
        Historico historico2 = new Historico("DEPOSITO", new BigDecimal(200.00), new BigDecimal(00), new BigDecimal(200.00), "Primeiro deposito", cliente2);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
        historicoRepository.saveAll(Arrays.asList(historico1, historico2));

    }
    
}
