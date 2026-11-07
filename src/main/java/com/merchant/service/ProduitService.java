package com.merchant.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.merchant.dto.ProduitRequest;
import com.merchant.dto.ProduitResponse;
import com.merchant.entity.Produit;
import com.merchant.exception.ResourceNotFoundException;
import com.merchant.repository.ProduitRepository;

import jakarta.transaction.Transactional;

/**
 * Logique métier des produits (MVC : Controller -> Service -> Repository).
 * Aucune dépendance vers le module client : si un produit est supprimé, les clients
 * qui le référencent gardent simplement un id orphelin (ignoré à l'affichage).
 */
@Service
@Transactional
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<ProduitResponse> findAll() {
        return produitRepository.findAll().stream().map(ProduitResponse::from).toList();
    }

    public ProduitResponse findById(int id) {
        return ProduitResponse.from(getProduit(id));
    }

    /** Renvoie uniquement les produits qui existent parmi les ids demandés (les autres sont ignorés). */
    public List<ProduitResponse> findByIds(Collection<Integer> ids) {
        return produitRepository.findAllById(ids).stream().map(ProduitResponse::from).toList();
    }

    public ProduitResponse create(ProduitRequest request) {
        Produit produit = new Produit(request.getNomProduit(), request.getDesignation(), request.getPrixUnitaire());
        return ProduitResponse.from(produitRepository.save(produit));
    }

    public ProduitResponse update(int id, ProduitRequest request) {
        Produit produit = getProduit(id);
        produit.setNomProduit(request.getNomProduit());
        produit.setDesignation(request.getDesignation());
        produit.setPrixUnitaire(request.getPrixUnitaire());
        return ProduitResponse.from(produit);
    }

    public void delete(int id) {
        produitRepository.delete(getProduit(id));
    }

    private Produit getProduit(int id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit " + id + " introuvable"));
    }
}
