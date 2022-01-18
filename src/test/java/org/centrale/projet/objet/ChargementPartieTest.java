/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.projet.objet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author twfid
 */
public class ChargementPartieTest {
    
    private String nomFichier="fichier";
    
    public ChargementPartieTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of chargerPartie method, of class ChargementPartie.
     */
    @Test
    public void testChargerPartie() throws Exception {
        System.out.println("chargerPartie");
        ChargementPartie instance = new ChargementPartie(nomFichier);
        World expResult = new World();
        World result = instance.chargerPartie();
        assertEquals(result, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
