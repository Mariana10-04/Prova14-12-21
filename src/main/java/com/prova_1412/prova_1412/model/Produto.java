package com.prova_1412.prova_1412.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private BigDecimal precoDeCompra;
    private BigDecimal precoDeVenda;

    @ManyToOne
    private Forncedor fornecedor;

    @ManyToOne
    private TipoProduto tipoProduto;
}

