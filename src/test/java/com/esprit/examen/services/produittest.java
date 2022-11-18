package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class produittest {
    @Mock
    StockRepository sr;
    @InjectMocks
    StockServiceImpl ss;

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    Produit p1 = new Produit(55L, "2365","produit1",50);
    Produit p2 = new Produit(66L, "5681","produit5",120);


    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p1);
            add(new Produit(90L, "9687","produit2",30));
            add(new Produit(46L, "4503","produit3",70));
        }
    };



    @Test
    public void testRetrieveProduit() {

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
        Produit produit1 = produitService.retrieveProduit(55L);
        assertNotNull(produit1);
        System.out.println("1");
        assertEquals(produit1.getIdProduit(),55L);
    }

    @Test
    public void testretrieveAllProduits() {
        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
        List<Produit> listproduit3 = produitService.retrieveAllProduits();
        assertEquals(3, listproduit3.size());
        //assertEquals(produit1.getIdProduit(),55L);
        System.out.println("2555");
    }
}