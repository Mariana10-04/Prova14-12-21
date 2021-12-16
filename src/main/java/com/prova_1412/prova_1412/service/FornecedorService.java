package com.prova_1412.prova_1412.service;

import com.prova_1412.prova_1412.model.Forncedor;
import com.prova_1412.prova_1412.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Forncedor save(Forncedor forncedor){
        return repository.save(forncedor);
    }

    public List<Forncedor> findAll() {
        List<Forncedor> forncedores = repository.findAll();
        return forncedores;
    }

    public Forncedor update(UUID id, Forncedor forncedor) {
        Forncedor forncedorEncontrado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não achado"));
        forncedorEncontrado.setNome(forncedor.getNome());
        repository.save(forncedorEncontrado);

        return forncedorEncontrado;
    }

    public String delete(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não achado"));
        repository.deleteById(id);
        return "Fornecedor deletado!";
    }
}