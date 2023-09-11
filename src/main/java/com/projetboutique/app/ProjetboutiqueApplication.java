package com.projetboutique.app;

import com.projetboutique.app.entities.Produit;
import com.projetboutique.app.repositories.CategoryRepository;
import com.projetboutique.app.repositories.ProduitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetboutiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetboutiqueApplication.class, args);
	}


}
