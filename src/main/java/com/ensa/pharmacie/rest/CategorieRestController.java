
package com.ensa.pharmacie.rest;

import com.ensa.pharmacie.entity.Categorie;
import com.ensa.pharmacie.repository.CategorieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieRestController {

    private final CategorieRepository repository;

    public CategorieRestController(CategorieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Categorie> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categorie> create(@RequestBody Categorie categorie) {
        categorie.setId(null);
        Categorie saved = repository.save(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(
            @PathVariable Long id,
            @RequestBody Categorie categorie) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        categorie.setId(id);
        return ResponseEntity.ok(repository.save(categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
