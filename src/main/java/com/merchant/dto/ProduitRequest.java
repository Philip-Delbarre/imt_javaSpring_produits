package com.merchant.dto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.merchant.exception.BadRequestException;

/** Corps JSON reçu pour créer / modifier un produit (l'id est généré : un idProduit envoyé est ignoré). */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProduitRequest {

    private String nomProduit;
    private String designation;
    private BigDecimal prixUnitaire;

    // constructeur vide + setters : requis pour que Jackson remplisse l'objet depuis le JSON
    public ProduitRequest() {
    }

    /** Contrôle les données reçues ; lève une BadRequestException (HTTP 400) avec le détail des champs en erreur. */
    public boolean verifier() {
        Map<String, String> erreurs = new TreeMap<>();
        if (nomProduit == null || nomProduit.trim().isEmpty()) {
            erreurs.put("nomProduit", "le nom du produit est obligatoire");
        }
        if (prixUnitaire == null) {
            erreurs.put("prixUnitaire", "le prix unitaire est obligatoire");
        } else if (prixUnitaire.compareTo(BigDecimal.ZERO) < 0) {
            erreurs.put("prixUnitaire", "le prix unitaire doit être positif");
        }
        if (!erreurs.isEmpty()) {
            throw new BadRequestException("Données invalides", erreurs);
        }
        return true;
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
