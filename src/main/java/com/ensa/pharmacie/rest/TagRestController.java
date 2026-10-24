
package com.ensa.pharmacie.rest;

import com.ensa.pharmacie.entity.Tag;
import com.ensa.pharmacie.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagRestController {

    private final TagRepository repository;

    public TagRestController(TagRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tag> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        tag.setId(null);
        Tag saved = repository.save(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update(
            @PathVariable Long id,
            @RequestBody Tag tag) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tag.setId(id);
        return ResponseEntity.ok(repository.save(tag));
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
