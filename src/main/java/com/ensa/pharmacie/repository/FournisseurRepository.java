
package com.ensa.pharmacie.repository;

import com.ensa.pharmacie.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository
        extends JpaRepository<Fournisseur, Long> {
}
