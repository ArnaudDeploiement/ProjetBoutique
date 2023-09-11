package com.projetboutique.app.controllers;


import com.projetboutique.app.entities.Category;
import com.projetboutique.app.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("newCategory") Category category) {
        categoryService.addCategory(category);
        return "redirect:/category";
    }


    @PostMapping("/editCategory")
    public String editCategory(@ModelAttribute("updateCategory") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category";
    }


    @GetMapping("/category/{categoryId}")
    public String updateCategory(@PathVariable Long categoryId, Model model) {
        Optional<Category> categoryOptional = categoryService.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            model.addAttribute("updateCategory", category);
            return "editcategory";
        } else {

            //pense à mettre un message d'erreur
            return "redirect:/category";
        }
    }


    @PostMapping("/category/delete/{deleteId}")
    public String deleteCategory(@PathVariable Long deleteId) {
        categoryService.deleteCategory(deleteId);
        //pense à afficher un message de suppression dans une div.
        return "redirect:/category";
    }


    @GetMapping("/category")
    public String viewSaveandGetCategory(Model save, Model get) {
        List<Category> categoryList = categoryService.getAllCategory();
        save.addAttribute("newCategory", new Category());
        get.addAttribute("getCategory", categoryList);
        return "backcategorie";
    }


}
