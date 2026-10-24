
package com.ensa.pharmacie.repository;

import com.ensa.pharmacie.entity.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository
        extends JpaRepository<DetailProduit, Long> {
}
