package com.ensa.pharmacie.repository;

import com.ensa.pharmacie.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository
        extends JpaRepository<Categorie, Long> {
}
