package com.prova_1412.prova_1412.service;

import com.prova_1412.prova_1412.model.TipoProduto;
import com.prova_1412.prova_1412.repository.TipoProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TipoProdutoSevice {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public TipoProduto save(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public List<TipoProduto> findAll(){
        List<TipoProduto> tipoProdutos =  tipoProdutoRepository.findAll();
        return tipoProdutos;
    }
}
