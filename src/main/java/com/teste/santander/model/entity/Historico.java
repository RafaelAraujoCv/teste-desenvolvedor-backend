package com.teste.santander.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operacao")
    private String operacao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "valor_antigo")
    private BigDecimal valorAntigo;

    @Column(name = "valor_novo")
    private BigDecimal valorNovo;

    @Column(name = "mensagem_observacao")
    private String mensagemObservacao;

    @Column(name = "data_movimemtacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataMovimentacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Historico(){}

    public Historico(String operacao, BigDecimal valor, BigDecimal valorAntigo, BigDecimal valorNovo,
    String mensagemObservacao, Cliente cliente) {
        this.operacao = operacao;
        this.valor = valor;
        this.valorAntigo = valorAntigo;
        this.valorNovo = valorNovo;
        this.mensagemObservacao = mensagemObservacao;
        this.cliente = cliente;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }
    
    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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
