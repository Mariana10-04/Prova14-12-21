package com.prova_1412.prova_1412.util;

import com.prova_1412.prova_1412.model.Forncedor;
import com.prova_1412.prova_1412.model.Produto;
import com.prova_1412.prova_1412.model.TipoProduto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProdutoCreat {

    public static Produto produtoCreator() {
        Produto produto = new Produto();
        Forncedor fornecedor = new Forncedor(UUID.randomUUID(), "Fornecedor Teste");
        TipoProduto tipo = new TipoProduto(UUID.randomUUID(), "Tipo de teste");
        produto.setId(UUID.randomUUID());
        produto.setNome("Produto de teste");
        produto.setPrecoCompra((float)1.99);
        produto.setPrecoVenda((float)15);
        produto.setFornecedor(fornecedor);
        produto.setTipoProduto(tipo);

        return produto;
    }
}