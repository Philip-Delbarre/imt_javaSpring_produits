package com.merchant.dto;

import java.math.BigDecimal;

import com.merchant.entity.Produit;

/** Corps JSON renvoyé pour un produit. */
public class ProduitResponse {

    private final Integer idProduit;
    private final String nomProduit;
    private final String designation;
    private final BigDecimal prixUnitaire;

    public ProduitResponse(Integer idProduit, String nomProduit, String designation, BigDecimal prixUnitaire) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
    }

    public static ProduitResponse from(Produit produit) {
        return new ProduitResponse(
                produit.getIdProduit(),
                produit.getNomProduit(),
                produit.getDesignation(),
                produit.getPrixUnitaire());
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }
}
