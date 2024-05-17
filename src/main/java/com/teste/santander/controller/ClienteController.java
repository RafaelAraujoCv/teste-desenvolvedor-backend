package com.teste.santander.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.santander.model.dto.ClienteDto;
import com.teste.santander.model.dto.ClienteOperacaoDto;
import com.teste.santander.model.entity.Cliente;
import com.teste.santander.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    //@Operation(summary = "Cadastrar novo cliente")
    public ResponseEntity<ClienteDto> cadastrarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente novoCliente = clienteService.cadastrarNovoCliente(clienteDto.toModel());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoCliente.getId()).toUri();
        return ResponseEntity.created(uri).build(); 
    }

    @GetMapping()
    //@Operation(summary = "Buscar todos os clientes")
    public ResponseEntity<List<ClienteDto>> buscarClientes() {        
        return ResponseEntity.ok().body(clienteService.buscarTodosCliente()); 
    }

    @PutMapping(value = "/depositar/{id}")
    //@Operation(summary = "Operação para depositar valor da conta do Cliente")
    public ResponseEntity<ClienteOperacaoDto> depositarValor(@PathVariable Long id, @Valid @RequestBody ClienteOperacaoDto clienteOperacaoDto) {
        return ResponseEntity.ok(clienteService.atualizarSaldoOperacao(id, clienteOperacaoDto)); 
    }

    @PutMapping(value = "/sacar/{id}")
    //@Operation(summary = "Operação para sacar valor da conta do Cliente")
    public ResponseEntity<ClienteOperacaoDto> sacarValor(@PathVariable Long id, @Valid @RequestBody ClienteOperacaoDto clienteOperacaoDto) {
        return ResponseEntity.ok(clienteService.atualizarSaldoOperacao(id, clienteOperacaoDto)); 
    }

}
