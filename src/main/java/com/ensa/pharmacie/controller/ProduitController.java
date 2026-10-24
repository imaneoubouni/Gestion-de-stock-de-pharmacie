
package com.ensa.pharmacie.controller;

import com.ensa.pharmacie.repository.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {

    private final ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/produits")
    public String afficherProduits(Model model) {
        model.addAttribute(
            "produits",
            produitRepository.findAll()
        );

        return "produits/list";
    }
}
