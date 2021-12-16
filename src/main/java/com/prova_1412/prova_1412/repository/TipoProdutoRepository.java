package com.prova_1412.prova_1412.repository;

import com.prova_1412.prova_1412.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, UUID> {
}
