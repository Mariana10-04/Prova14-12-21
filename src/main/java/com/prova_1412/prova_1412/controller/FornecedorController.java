package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.Forncedor;
import com.prova_1412.prova_1412.service.FornecedorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController{
    @Autowired
    private final FornecedorSevice fornecedorSevice;

    public FornecedorController(FornecedorSevice fornecedorSevice) {
        this.fornecedorSevice = fornecedorSevice;
    }

    @PostMapping
    public ResponseEntity<Forncedor> save(@RequestBody Forncedor forncedor){
        Forncedor forncedor1 = fornecedorSevice.save(forncedor);
        return new ResponseEntity<>(forncedor1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Forncedor>> index(){
        List<Forncedor> forncedors = fornecedorSevice.findAll();
        return new ResponseEntity<>(forncedors, HttpStatus.OK);
    }
}