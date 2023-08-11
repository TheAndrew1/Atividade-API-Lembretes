package com.example.Lembretes.Controller;

import com.example.Lembretes.DTO.LembreteDTO;
import com.example.Lembretes.Entity.Lembrete;
import com.example.Lembretes.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;

    @GetMapping
    public ResponseEntity<Lembrete> findById(@RequestParam("id") final Long id) {
        try {
            return ResponseEntity.ok(lembreteService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Lembrete());
        }
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Lembrete>> findAll() {
//        try {
//            return ResponseEntity.ok(lembreteService.findAll());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(new ArrayList<Lembrete>());
//        }
//    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final LembreteDTO lembreteDTO) {
        try {
            lembreteService.create(lembreteDTO);
            return ResponseEntity.ok("Lembrete cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final LembreteDTO lembreteDTO) {
        try {
            lembreteService.update(id, lembreteDTO);
            return ResponseEntity.ok("Lembrete editado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id) {
        try {
            lembreteService.delete(id);
            return ResponseEntity.ok("Lembrete excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
