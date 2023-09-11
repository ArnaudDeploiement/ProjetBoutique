package com.projetboutique.app.services;

import com.projetboutique.app.entities.Category;
import com.projetboutique.app.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private final CategoryRepository categorycrud;

    public CategoryService(CategoryRepository categorycrud) {
        this.categorycrud = categorycrud;
    }


    public void addCategory(Category category) {
        categorycrud.save(category);
    }

    public List<Category> getAllCategory() {
        return categorycrud.findAll();
    }


    public void updateCategory(Category category) {
        Category existingCategory = categorycrud.findById(category.getId()).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            if (existingCategory.getProduit() != null) {
                existingCategory.getProduit().addAll(category.getProduit());
            }
            categorycrud.save(existingCategory);
        }
    }


    public void deleteCategory(Long id) {
        categorycrud.deleteById(id);
    }

    public Optional<Category> findById(Long categoryId) {
        Optional<Category> categoryfind = categorycrud.findById(categoryId);
        return categoryfind;
    }
}
