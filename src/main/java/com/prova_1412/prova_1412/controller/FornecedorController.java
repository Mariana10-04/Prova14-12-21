package com.prova_1412.prova_1412.controller;

import com.prova_1412.prova_1412.model.Forncedor;
import com.prova_1412.prova_1412.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    private FornecedorService service;

    public FornecedorController(FornecedorService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Forncedor>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Forncedor> save(@RequestBody Forncedor forncedor) {
        return new ResponseEntity<>(service.save(forncedor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Forncedor> update(@PathVariable UUID id, @RequestBody Forncedor forncedor) throws Exception {
        return new ResponseEntity(service.update(id, forncedor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}