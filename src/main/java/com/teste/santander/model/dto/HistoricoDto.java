package com.teste.santander.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.teste.santander.model.entity.Cliente;
import com.teste.santander.model.entity.Historico;

public class HistoricoDto {

    private String operacao;
    private BigDecimal valor;
    private Long idCliente;
    private BigDecimal valorAntigo;
    private BigDecimal valorNovo;
    private String mensagemObservacao;
    private LocalDate dataMovimentacao = LocalDate.now();

    public HistoricoDto(){}

    public HistoricoDto(Historico historico) {
        this.operacao = historico.getOperacao();
        this.valor = historico.getValor();
        this.idCliente = historico.getCliente().getId();
        this.valorAntigo = historico.getValorAntigo();
        this.valorNovo = historico.getValorNovo();
        this.mensagemObservacao = historico.getMensagemObservacao();
        this.dataMovimentacao = historico.getDataMovimentacao();
    }

    //DTO para Entity
    public Historico toModel(Cliente cliente) {
        var historico = new Historico(this.operacao, this.valor, this.valorAntigo, this.valorNovo, this.mensagemObservacao, cliente);
        return historico;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'toModel'");
    }
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public BigDecimal getValorAntigo() {
        return valorAntigo;
    }
    
    public void setValorAntigo(BigDecimal valorAntigo) {
        this.valorAntigo = valorAntigo;
    }
    
    public BigDecimal getValorNovo() {
        return valorNovo;
    }
    
    public void setValorNovo(BigDecimal valorNovo) {
        this.valorNovo = valorNovo;
    }
    
    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }
    
    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
    
    public Long getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getMensagemObservacao() {
        return mensagemObservacao;
    }

    public void setMensagemObservacao(String mensagemObservacao) {
        this.mensagemObservacao = mensagemObservacao;
    }
    
}
