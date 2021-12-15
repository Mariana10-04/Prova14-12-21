package com.prova_1412.prova_1412.service;

import com.prova_1412.prova_1412.model.Forncedor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FornecedorSevice {

    @Autowired
    private FornecedorSevice fornecedorSevice;

    public Forncedor save(Forncedor forncedor) {
        return fornecedorSevice.save(forncedor);
    }

    public List<Forncedor> findAll(){
        List<Forncedor> supplier =  fornecedorSevice.findAll();
        return supplier;
    }
}
