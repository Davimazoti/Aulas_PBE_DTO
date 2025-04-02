package com.example.Aula2_Back_Front_Produto.DTO;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private double valor;
    private int saldo;
    private int saldoMin;


    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, double valor, int saldo, int saldoMin) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.saldo = saldo;
        this.saldoMin = saldoMin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(int saldoMin) {
        this.saldoMin = saldoMin;
    }
}
