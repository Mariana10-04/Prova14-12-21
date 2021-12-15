package com.prova_1412.prova_1412.service;


import com.prova_1412.prova_1412.model.Produto;
import com.prova_1412.prova_1412.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto findById(Long produtoId){
        Produto person =  produtoRepository.findById(produtoId)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        return person;
    }

    public List<Produto> findAll(){
        List<Produto> produto =  produtoRepository.findAll();
        return produto;
    }

    public Produto update(Long produtoId, Produto produto){
        Produto productFound =  produtoRepository.findById(produtoId)
                .orElseThrow(()-> new RuntimeException("Product não encontrado"));

        productFound.setNome(produto.getNome());
        productFound.setTipoProduto(produto.getTipoProduto());
        productFound.setPrecoDeCompra(produto.getPrecoDeCompra());
        productFound.setPrecoDeVenda(produto.getPrecoDeVenda());
        productFound.setTipoProduto(produto.getTipoProduto());
        productFound.setQuantidade(produto.getQuantidade());
        productFound.setFornecedor(produto.getFornecedor());
        produtoRepository.save(productFound);
        return productFound;
    }

    public void delete(Long produtoId){
        produtoRepository.findById(produtoId)
                .orElseThrow(()-> new RuntimeException("Product não encontrado"));
        produtoRepository.deleteById(produtoId);
    }
}