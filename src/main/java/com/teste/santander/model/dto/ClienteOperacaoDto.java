package com.teste.santander.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.teste.santander.model.entity.Operacao;

public class ClienteOperacaoDto {

    @NotBlank
    @NotEmpty
    private String operacao;
    private BigDecimal valor;
    private Double taxa;
    private BigDecimal valor_taxa;
    private String mensagem;

    public BigDecimal calculaTaxa(BigDecimal saldoConta, BigDecimal valor, Boolean planoExclusive){
        aptoParaSaque(saldoConta, valor);
        if(planoExclusive || valor.compareTo(new BigDecimal("100.00")) == 0 || valor.compareTo(new BigDecimal("100.00")) == -1){
            this.mensagem = "Isento de taxa de saque";
            this.taxa = (0.0 / 100.0) * valor.doubleValue();
            this.valor_taxa = new BigDecimal(taxa);
        } else if(valor.compareTo(new BigDecimal("100.00")) == 1 && valor.compareTo(new BigDecimal("300.00")) == 0 || valor.compareTo(new BigDecimal("300.00")) == -1) {
            this.taxa = (0.4 / 100.0) * valor.doubleValue();
            this.mensagem = "Taxa de 0.4% ";
            this.valor_taxa = valor.add(new BigDecimal(taxa));
        } else if(valor.compareTo(new BigDecimal("100.00")) == 1) {
            this.taxa = (0.1 / 100.0) * valor.doubleValue();
            this.mensagem = "Taxa de 0.1% ";
            this.valor_taxa = valor.add(new BigDecimal(taxa));
        }
        return saldoConta.subtract(valor_taxa);
    }

    private void aptoParaSaque(BigDecimal saldoConta, BigDecimal valor) {
        if(saldoConta.compareTo(valor) == -1)
            throw new IllegalArgumentException("Saldo em conta insuficiente. Saldo em conta: " + saldoConta + " Valor solicitado para saque: " + valor);
    }

    public String getOperacao() {
        Operacao.toEnum(operacao);
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;     
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    

    public BigDecimal getValor_taxa() {
        return valor_taxa;
    }

    public void setValor_taxa(BigDecimal valor_taxa) {
        this.valor_taxa = valor_taxa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
    
}
