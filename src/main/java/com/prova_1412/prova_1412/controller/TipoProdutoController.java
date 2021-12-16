package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.TipoProduto;
import com.prova_1412.prova_1412.service.TipoProdutoSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("api/tipos")
public class TipoProdutoController {

    private TipoProdutoSevice tipoProdutoSevice;

    public TipoProdutoController(TipoProdutoSevice service) {
        this.tipoProdutoSevice = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoProduto>> listAll() {
        return ResponseEntity.ok(tipoProdutoSevice.findAll());
    }

    @PostMapping
    public ResponseEntity<TipoProduto> save(@RequestBody TipoProduto tipoProduto) {
        return new ResponseEntity<>(tipoProdutoSevice.save(tipoProduto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProduto> update(@PathVariable UUID id, @RequestBody TipoProduto tipoProduto) throws Exception {
        return new ResponseEntity(tipoProdutoSevice.update(id, tipoProduto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")UUID id) {
        return new ResponseEntity<>(tipoProdutoSevice.delete(id), HttpStatus.OK);
    }
}