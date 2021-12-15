package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.TipoProduto;
import com.prova_1412.prova_1412.service.TipoProdutoSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("type")
@CrossOrigin(origins = "*")
public class TipoProdutoController {
    @Autowired
    private final TipoProdutoSevice tipoProdutoSevice;

    public TipoProdutoController(TipoProdutoSevice tipoProdutoSevice) {
        this.tipoProdutoSevice = tipoProdutoSevice;
    }

    @GetMapping
    public ResponseEntity<List<TipoProduto>> index(){
        List<TipoProduto> tiposProdutos = tipoProdutoSevice.findAll();
        return new ResponseEntity<>(tiposProdutos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoProduto> save(@RequestBody TipoProduto tipoProduto){
        TipoProduto produto = tipoProdutoSevice.save(tipoProduto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

}