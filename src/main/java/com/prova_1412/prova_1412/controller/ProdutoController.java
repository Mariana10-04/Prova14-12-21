package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.Produto;
import com.prova_1412.prova_1412.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService service){
        this.produtoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @PutMapping("/estoque/{id}")
    public ResponseEntity<Integer> editEstoque(@PathVariable UUID id, @RequestBody Produto produto) throws Exception {
        return new ResponseEntity(produtoService.editEstoque(id, produto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Produto> update(@PathVariable UUID id, @RequestBody Produto produto) throws Exception {
        return new ResponseEntity(produtoService.update(id, produto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")UUID id) {
        return new ResponseEntity<>(produtoService.delete(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteSerHumano(@PathVariable UUID produtoId)  {
        produtoService.delete(produtoId);
        return ResponseEntity.noContent().build();
    }
}