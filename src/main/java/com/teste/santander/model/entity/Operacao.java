package com.teste.santander.model.entity;

public enum Operacao {

    SAQUE(0,"SAQUE"), DEPOSITO(1, "DEPOSITO");

    private Integer codigo;
    private String operacao;

    private Operacao(Integer codigo, String operacao) {
        this.codigo = codigo;
        this.operacao = operacao;
    }

    public static Operacao toEnum(String operacao){
        if(operacao == null) {
            return null;
        }

        for(Operacao x : Operacao.values()) {
            if(operacao.equals(x.getOperacao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Operação invalida");
    }

    
    public Integer getCodigo() {
        return codigo;
    }


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    private Operacao(String operacao) {
        this.operacao = operacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

}
