
package com.ensa.pharmacie.rest;

import com.ensa.pharmacie.entity.Produit;
import com.ensa.pharmacie.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {

    private final ProduitRepository produitRepository;

    public ProduitRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    // GET : récupérer tous les produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // GET : récupérer un produit par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST : ajouter un produit
    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        produit.setId(null);
        Produit savedProduit = produitRepository.save(produit);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduit);
    }

    // PUT : modifier un produit existant
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable Long id,
            @RequestBody Produit produit) {

        return produitRepository.findById(id)
                .map(existingProduit -> {
                    produit.setId(id);
                    Produit updatedProduit = produitRepository.save(produit);
                    return ResponseEntity.ok(updatedProduit);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE : supprimer un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        if (!produitRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produitRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
