package com.prova_1412.prova_1412.util;

import com.prova_1412.prova_1412.model.TipoProduto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoProdutoCreat {

    public static TipoProduto createTipo() {
        TipoProduto tipo = new TipoProduto();
        tipo.setId(UUID.randomUUID());
        tipo.setCategoria("Teste de tipo de produto");

        return tipo;
    }
}