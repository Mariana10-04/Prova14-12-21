package com.prova_1412.prova_1412.util;

import com.prova_1412.prova_1412.model.Forncedor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FornecedorCreat {

    public static Forncedor createFornecedor() {
        Forncedor fornecedor = new Forncedor();
        fornecedor.setId(UUID.randomUUID());
        fornecedor.setNome("Fornecedor Teste");

        return fornecedor;
    }
}