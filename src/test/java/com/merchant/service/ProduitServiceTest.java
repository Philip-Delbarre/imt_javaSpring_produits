package com.merchant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.merchant.dto.ProduitResponse;
import com.merchant.entity.Produit;
import com.merchant.repository.ProduitRepository;


@SpringBootTest 
public class ProduitServiceTest {

// on va créer un objet fictif pour les tests

    @Mock 
    private ProduitRepository produitRepository; 

    @InjectMocks 
    private ProduitService produitService;


    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void shouldReturnAllProduct (){
        Produit produitFictif1 = new Produit ( "poterie" , "c'est un truc rigard", new BigDecimal("12.30"));
        Produit produitFictif2 = new Produit ( "chatBleu" , "what you don't know this !", new BigDecimal("17"));
        
        when(produitRepository.findAll()).thenReturn( List.of(produitFictif1, produitFictif2));

        List<ProduitResponse> produits = produitService.findAll();
        assertEquals(2, produits.size());
    
    }
    

    @Test
    void testFindById() {

    }

    @Test
    void testFindByIds() {

    }

    @Test
    void testUpdate() {

    }
}
