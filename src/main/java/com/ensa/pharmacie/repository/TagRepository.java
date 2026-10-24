package com.ensa.pharmacie.repository;

import com.ensa.pharmacie.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository
        extends JpaRepository<Tag, Long> {
}
