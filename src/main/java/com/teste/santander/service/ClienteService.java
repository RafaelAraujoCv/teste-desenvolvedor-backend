package com.teste.santander.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.santander.model.dto.ClienteDto;
import com.teste.santander.model.dto.ClienteOperacaoDto;
import com.teste.santander.model.entity.Cliente;
import com.teste.santander.model.entity.Historico;
import com.teste.santander.model.entity.Operacao;
import com.teste.santander.repository.ClienteRepository;
import com.teste.santander.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HistoricoService historicoService;

    public ClienteService(ClienteRepository clienteRepository, HistoricoService historicoService) {
        this.clienteRepository = clienteRepository;
        this.historicoService = historicoService;
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public void atualizarDadosCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente cadastrarNovoCliente(Cliente cliente) {
        var novoCliente = clienteRepository.save(cliente);
        historicoService.criarHistorico(novoCliente.historicoNovoCliente(novoCliente));
        return novoCliente;
    }

    public List<ClienteDto> buscarTodosCliente() {
        var list = clienteRepository.findAll();
        var listaDto = list.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
        return listaDto;
    }

    public ClienteOperacaoDto atualizarSaldoOperacao(Long id, ClienteOperacaoDto clienteOperacaoDto) {
        
        var cliente = buscarClientePorId(id);
        var saldoAntido = cliente.getSaldoConta();

        operacaoSaldoEmConta(cliente, clienteOperacaoDto);
        atualizarDadosCliente(cliente);
        historicoService.criarHistoricoOperacao(new Historico(clienteOperacaoDto.getOperacao(), clienteOperacaoDto.getValor_taxa(), saldoAntido, cliente.getSaldoConta(), clienteOperacaoDto.getMensagem(), cliente));

        return clienteOperacaoDto;
    }

    private void operacaoSaldoEmConta(Cliente cliente, ClienteOperacaoDto clienteOperacaoDto) {
        if(clienteOperacaoDto.getOperacao().equals(Operacao.DEPOSITO.getOperacao())){
            cliente.setSaldoConta(somarSaldo(cliente.getSaldoConta(), clienteOperacaoDto.getValor()));
        } else if(clienteOperacaoDto.getOperacao().equals(Operacao.SAQUE.getOperacao())) {
            cliente.setSaldoConta(clienteOperacaoDto.calculaTaxa(cliente.getSaldoConta(), clienteOperacaoDto.getValor(), cliente.getPlanoExclusive()));
        }
    }

    private BigDecimal somarSaldo(BigDecimal antigo, BigDecimal novo) {
        return novo = antigo.add(novo);
    }

}
