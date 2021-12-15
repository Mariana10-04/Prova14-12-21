package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.Produto;
import com.prova_1412.prova_1412.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProdutoController {
    @Autowired
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        Produto produto1 = produtoService.save(produto);
        return new ResponseEntity<>(produto1, HttpStatus.CREATED);
    }

    @GetMapping("{produtoId}")
    public ResponseEntity<Produto> findProdutoFornecedor(@PathVariable("produtoId") Long produtoId){
        Produto produtos = produtoService.findById(produtoId);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> index(){
        List<Produto> serHumano = produtoService.findAll();
        return new ResponseEntity<>(serHumano, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Produto> updateSerHumano(@PathVariable Long produtoId, @RequestBody Produto produto){
        Produto serHumanoUpdated = produtoService.update(produtoId, produto);
        return new ResponseEntity<>(serHumanoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteSerHumano(@PathVariable Long produtoId)  {
        produtoService.delete(produtoId);
        return ResponseEntity.noContent().build();
    }
}