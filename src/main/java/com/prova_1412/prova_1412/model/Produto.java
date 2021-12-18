package com.prova_1412.prova_1412.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String nome;

    private int quantidade;

    private float precoVenda;

    private float precoCompra;

    @ManyToOne
    private Forncedor forncedor;

    @ManyToOne
    private TipoProduto tipoProduto;

    public Produto(UUID id, String nome, int quantidade, float precoVenda, float precoCompra, Forncedor fornecedor, TipoProduto tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.forncedor = fornecedor;
        this.tipoProduto = tipoProduto;
    }

    public Produto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Forncedor getFornecedor() {
        return forncedor;
    }

    public void setFornecedor(Forncedor fornecedor) {
        this.forncedor = fornecedor;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void aumentaEstoque(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }

    public void diminuiEstoque(int quantidade) throws Exception {
        if (this.quantidade > 0 && this.quantidade >= quantidade) {
            this.quantidade = this.quantidade - quantidade;
        } else {
            throw new Exception("Tá devendo, é?");
        }
    }
}


