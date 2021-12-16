package com.prova_1412.prova_1412.service;

import com.prova_1412.prova_1412.model.TipoProduto;
import com.prova_1412.prova_1412.repository.TipoProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TipoProdutoSevice {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public TipoProduto save(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public List<TipoProduto> findAll() {
        List<TipoProduto> tipoProduto = tipoProdutoRepository.findAll();
        return tipoProduto;
    }

    public TipoProduto update(UUID id, TipoProduto tipoProduto) {
        TipoProduto tipoProdutoEncontrado = tipoProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de produto não encontrado"));

        tipoProdutoEncontrado.setCategoria(tipoProduto.getCategoria());
        tipoProdutoRepository.save(tipoProdutoEncontrado);
        return tipoProdutoEncontrado;
    }

    public String delete(UUID id) {
        tipoProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de produto não encontrado"));
        tipoProdutoRepository.deleteById(id);
        return "Tipo de produto deletado com sucesso!";
    }
}