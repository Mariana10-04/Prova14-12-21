package com.prova_1412.prova_1412.service;


import com.prova_1412.prova_1412.model.Produto;
import com.prova_1412.prova_1412.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Produto findById(UUID id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = repository.findAll();
        return produtos;
    }

    public Produto update(UUID id, Produto produto) {
        Produto produtoEncontrado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setPrecoCompra(produto.getPrecoCompra());
        produtoEncontrado.setPrecoVenda(produto.getPrecoVenda());
        produtoEncontrado.setFornecedor(produto.getFornecedor());
        produtoEncontrado.setTipoProduto(produto.getTipoProduto());
        repository.save(produtoEncontrado);
        return produtoEncontrado;
    }

    public String delete(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        repository.deleteById(id);
        return "Produto deletado com sucesso!";
    }

    public Integer editEstoque(UUID id, Produto produto) {
        Produto produtoEncontrado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoEncontrado.setQuantidade(produto.getQuantidade());
        repository.save(produtoEncontrado);

        return produto.getQuantidade();
    }

    public String aumentaEstoque(UUID id, int quantidade) {
        Produto produto = this.findById(id);

        produto.aumentaEstoque(quantidade);

        repository.save(produto);

        return "Estoque de " + produto.getNome() + " incrementado em " + quantidade;
    }

    public String diminuiEstoque(UUID id, int quantidade) throws Exception {
        Produto produto = this.findById(id);

        produto.diminuiEstoque(quantidade);

        repository.save(produto);

        return "Estoque de " + produto.getNome() + " reduzido em " + quantidade;
    }
}