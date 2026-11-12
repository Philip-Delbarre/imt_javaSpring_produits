package com.merchant.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.merchant.dto.ProduitRequest;
import com.merchant.dto.ProduitResponse;

import com.merchant.entity.Produit;
import com.merchant.repository.ProduitRepository;


@SpringBootTest 
public class ProduitServiceTest {

// on va créer un objet fictif pour les tests

    
   private ProduitRepository produitRepository; 
   private ProduitService produitService;


    @Test
    void shouldReturnAllProduct (){
        Produit produitFictif1 = new Produit ( "poterie" , "c'est un truc rigard", new BigDecimal("12.30"));
        Produit produitFictif2 = new Produit ( "chatBleu" , "what you don't know this !", new BigDecimal("17"));
        
        when(produitRepository.findAll()).thenReturn( List.of(produitFictif1, produitFictif2));

        List<ProduitResponse> produits = produitService.findAll();
        assertEquals(2, produits.size());
    
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
        ProduitResponse produitResponse =   new ProduitResponse(1, "sabre Lazer", "un sacré cadeau pour ce nole car j'en ai bien besoin", new BigDecimal("200.30"));
        Produit testProduct = new Produit("sabre Lazer", "un sacré cadeau pour ce nole car j'en ai bien besoin", new BigDecimal("200.30"));
        assertEquals(produitResponse.getNomProduit(), testProduct.getNomProduit());

    }

    @Test
    void testUpdate() {

    }
}
