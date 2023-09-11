package com.projetboutique.app.controllers;


import com.projetboutique.app.entities.Category;
import com.projetboutique.app.entities.Produit;
import com.projetboutique.app.services.CategoryService;
import com.projetboutique.app.services.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProduitController {


    private final ProduitService produitService;
    private final CategoryService categoryService;

    public ProduitController(ProduitService produitService, CategoryService categoryService) {
        this.produitService = produitService;
        this.categoryService = categoryService;
    }


    @PostMapping("/saveProduit")
    public String addProduit(@ModelAttribute("newProduit") Produit produit) {
        produitService.addProduit(produit);
        return "redirect:/produit";
    }

    @PostMapping("/editProduit")
    public String editProduit(@ModelAttribute("updateProduit") Produit produit) {
        produitService.updateProduit(produit);
        return "redirect:/produit";
    }


    @GetMapping("/produit/{produitId}")
    public String updateProduit(@PathVariable Long produitId, Model model) {
        Optional<Produit> produitOptional = produitService.findById(produitId);
        List<Category> categoryList = categoryService.getAllCategory();
        if (produitOptional.isPresent()) {
            Produit produit = produitOptional.get();
            model.addAttribute("updateProduit", produit);
            model.addAttribute("getCategory",categoryList);
            return "editproduit";
        } else {

            //pense à mettre un message d'erreur
            return "redirect:/produit";
        }
    }


    @PostMapping("/produit/delete/{deleteId}")
    public String deleteProduit(@PathVariable Long deleteId) {
        produitService.deleteProduit(deleteId);
        //pense à afficher un message de suppression dans une div.
        return "redirect:/produit";
    }

    @GetMapping("/produit")
    public String viewSaveandGetProduit(Model save, Model get) {
        List<Produit> produitList = produitService.getAllProduit();
        List<Category> categoryList = categoryService.getAllCategory();
        Produit produit = new Produit();
        save.addAttribute("newProduit", produit);
        get.addAttribute("getProduit", produitList);
        get.addAttribute("getCategory",categoryList);
        return "backproduit";
    }


}
