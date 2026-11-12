package com.merchant.service;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import com.merchant.dto.ProduitRequest;
import com.merchant.dto.ProduitResponse;
import com.merchant.entity.Produit;

public class ProduitServiceTest {
    // test de la classe Produit pour vérifier que les getters et setters fonctionnent correctement 
    // & that's it 
    // very simple unit test to check the getters and setters of the Produit class
    @Test
    void shouldCreateProduit() {
        // Given / When
        Produit produit = new Produit("poterie", "c'est un truc rigard", new BigDecimal("12.30"));

        // Then
        assertNotNull(produit);
        assertEquals("poterie", produit.getNomProduit());
        assertEquals("c'est un truc rigard", produit.getDesignation());
        assertEquals(new BigDecimal("12.30"), produit.getPrixUnitaire());
    }

    @Test
    void shouldCreateTwoDifferentProduits() {
        Produit produit1 = new Produit("poterie", "c'est un truc rigard", new BigDecimal("12.30"));
        Produit produit2 = new Produit("chatBleu", "what you don't know this !", new BigDecimal("17"));

        assertNotEquals(produit1.getNomProduit(), produit2.getNomProduit());
        assertEquals(0, new BigDecimal("17").compareTo(produit2.getPrixUnitaire()));
    
    }
    
// test le bon formattage de la reponse pour voir si elle ne leve pas d'erreur / expextion à sa création
    @Test 
     void produitValideNeLevePasErreur() {
        ProduitRequest request = new ProduitRequest();
        request.setNomProduit("poterie");
        request.setPrixUnitaire(new BigDecimal("12.30"));
        assertDoesNotThrow(()-> request.verifier());
    
    }

    @Test
    void testResponseFormat() {
        ProduitResponse produitResponse =   new ProduitResponse(1, "sabre Lazer", "un sacré cadeau pour ce noel car j'en ai bien besoin", new BigDecimal("200.30"));
        Produit testProduct = new Produit("sabre Lazer", "un sacré cadeau pour ce nole car j'en ai bien besoin", new BigDecimal("200.30"));
        assertEquals(produitResponse.getNomProduit(), testProduct.getNomProduit());

   
    }
}

