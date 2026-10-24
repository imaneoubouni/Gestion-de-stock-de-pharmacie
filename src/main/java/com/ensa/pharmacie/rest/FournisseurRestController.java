
package com.ensa.pharmacie.rest;

import com.ensa.pharmacie.entity.Fournisseur;
import com.ensa.pharmacie.repository.FournisseurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurRestController {

    private final FournisseurRepository repository;

    public FournisseurRestController(FournisseurRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Fournisseur> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fournisseur> create(
            @RequestBody Fournisseur fournisseur) {
        fournisseur.setId(null);
        Fournisseur saved = repository.save(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(
            @PathVariable Long id,
            @RequestBody Fournisseur fournisseur) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fournisseur.setId(id);
        return ResponseEntity.ok(repository.save(fournisseur));
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
