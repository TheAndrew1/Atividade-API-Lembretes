package com.example.Lembretes.Controller;

import com.example.Lembretes.DTO.PessoaDTO;
import com.example.Lembretes.Entity.Pessoa;
import com.example.Lembretes.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Pessoa> findById(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok(pessoaService.findById(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new Pessoa());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pessoa>> findAll(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok(pessoaService.findAll());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new ArrayList<Pessoa>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final PessoaDTO pessoaDTO){
        try {
            pessoaService.create(pessoaDTO);

            return ResponseEntity.ok("Pessoa cadastrada com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final PessoaDTO pessoaDTO){
        try {
            pessoaService.update(id, pessoaDTO);

            return ResponseEntity.ok("Pessoa editada com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            pessoaService.delete(id);

            return ResponseEntity.ok("Pessoa excluida com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
