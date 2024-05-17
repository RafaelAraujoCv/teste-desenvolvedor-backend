package com.teste.santander.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.teste.santander.model.entity.Cliente;

public class ClienteDto {

    @NotBlank
    @NotEmpty
    private String nome;

    private Boolean planoExclusive;

    private BigDecimal saldo;

    @Length(min = 5, max = 5)
    private String numero;

    @Past(message = "Data deve ser uma data passada em relação a atual")
    private LocalDate dataDeNascimento;

    public ClienteDto(){
        super();
    }

    public ClienteDto(String nome, Boolean planoExclusive, BigDecimal saldo, String numero,
            LocalDate dataDeNascimento) {
        this.nome = nome;
        this.planoExclusive = planoExclusive;
        this.saldo = saldo;
        this.numero = numero;
        this.dataDeNascimento = dataDeNascimento;
    }

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.planoExclusive = cliente.getPlanoExclusive();
        this.saldo = cliente.getSaldoConta();
        this.numero = cliente.getNumeroConta();
        this.dataDeNascimento = cliente.getDataDeNascimento();
    }

    //DTO para Entity
    public Cliente toModel() {
        var cliente = new Cliente(null, this.nome, this.planoExclusive, this.saldo, this.numero, this.dataDeNascimento, null);
        return cliente;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Boolean getPlanoExclusive() {
        return planoExclusive;
    }
    
    public void setPlanoExclusive(Boolean planoExclusive) {
        this.planoExclusive = planoExclusive;
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
    
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
}
