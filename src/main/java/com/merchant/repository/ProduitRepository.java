package com.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merchant.entity.Produit;

// Spring Data génère l'implémentation (findAll, findById, findAllById, save, delete...)
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
