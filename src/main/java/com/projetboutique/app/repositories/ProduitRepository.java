package com.projetboutique.app.repositories;

import com.projetboutique.app.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
