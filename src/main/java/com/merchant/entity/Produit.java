package com.merchant.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Modèle (M) du MVC : l'entité JPA est utilisée directement par le service et le repository. */
@Entity
@Table(name = "produits")
public class Produit {

    // IDENTITY : la base génère l'id (1, 2, 3...) à chaque insertion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;

    @Column(nullable = false)
    private String nomProduit;

    private String designation;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prixUnitaire;

    protected Produit() {
        // requis par JPA
    }

    public Produit(String nomProduit, String designation, BigDecimal prixUnitaire) {
        this.nomProduit = nomProduit;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
