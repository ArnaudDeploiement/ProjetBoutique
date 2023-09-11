package com.projetboutique.app.services;

import com.projetboutique.app.entities.Produit;
import com.projetboutique.app.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitcrud;

    public ProduitService(ProduitRepository produitcrud) {
        this.produitcrud = produitcrud;
    }


    public void addProduit(Produit produit) {
        produitcrud.save(produit);
    }

    public List<Produit> getAllProduit() {
        return produitcrud.findAll();
    }


    public void updateProduit(Produit produit) {
        Produit existingProduit = produitcrud.findById(produit.getId()).orElse(null);
        if (existingProduit != null) {
            existingProduit.setName(produit.getName());
            if (existingProduit.getCategory() != null) {
                existingProduit.setCategory(produit.getCategory());
            }
            if (existingProduit.getPhoto() != null) {
                existingProduit.setPhoto(produit.getPhoto());
            }
            if (existingProduit.getPrice() != null) {
                existingProduit.setPrice(produit.getPrice());
            }

            produitcrud.save(existingProduit);
        }
    }


    public void deleteProduit(Long id) {
        produitcrud.deleteById(id);
    }

    public Optional<Produit> findById(Long categoryId) {
        Optional<Produit> produitfind = produitcrud.findById(categoryId);
        return produitfind;
    }


}
