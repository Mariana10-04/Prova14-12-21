package com.prova_1412.prova_1412.repository;

import com.prova_1412.prova_1412.model.Forncedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Forncedor, Long> {
}