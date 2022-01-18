/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.projet.objet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author twfid
 */
public class Point2DTest {
    
    public Point2D point2D=new Point2D(); ;
    
    public Point2DTest() {
    }
    
    @BeforeEach
    public void setUp()
    {
        point2D=new Point2D();
        
    }
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

//    /**
//     * Test of setX method, of class Point2D.
//     */
//    @Test
//    public void testSetX() {
//        System.out.println("setX");
//        int value = 0;
//        Point2D instance = new Point2D();
//        instance.setX(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setY method, of class Point2D.
//     */
//    @Test
//    public void testSetY() {
//        System.out.println("setY");
//        int value = 0;
//        Point2D instance = new Point2D();
//        instance.setY(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPosition method, of class Point2D.
//     */
//    @Test
//    public void testSetPosition() {
//        System.out.println("setPosition");
//        int x = 0;
//        int y = 0;
//        Point2D instance = new Point2D();
//        instance.setPosition(x, y);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getX method, of class Point2D.
//     */
//    @Test
//    public void testGetX() {
//        System.out.println("getX");
//        Point2D instance = new Point2D();
//        int expResult = 0;
//        int result = instance.getX();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getY method, of class Point2D.
//     */
//    @Test
//    public void testGetY() {
//        System.out.println("getY");
//        Point2D instance = new Point2D();
//        int expResult = 0;
//        int result = instance.getY();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of affiche method, of class Point2D.
//     */
//    @Test
//    public void testAffiche() {
//        System.out.println("affiche");
//        Point2D instance = new Point2D();
//        instance.affiche();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of translate method, of class Point2D.
     */
//    @Test
//    public void testTranslate() {
//        System.out.println("translate");
//        int dx = 0;
//        int dy = 0;
//        Point2D instance = new Point2D();
//        instance.translate(dx, dy);
//       
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of distance method, of class Point2D.
     */
    @Test
    void testDistance() {
        System.out.println("distance");
        //Point2D p = null;
        Point2D testinstance=new Point2D(0,-5);
        //assertEquals(0.0, point2D.distance(p));
        assertEquals(5.0, point2D.distance(testinstance));
        assertEquals( 5.0, testinstance.distance(point2D));
        assertEquals(0,testinstance.distance(testinstance));
        assertEquals( 0.0, point2D.distance(point2D));
    }

    /**
     * Test of checkDistance method, of class Point2D.
     */
    @Test
    void testCheckDistance() {
        System.out.println("checkDistance");
        Point2D p2=new Point2D(5,5);
        Point2D p=new Point2D(-6,-7);
        assertTrue(point2D.checkDistance(point2D, 0));
        assertTrue(point2D.checkDistance(p2, 10));
        assertFalse(point2D.checkDistance(p2, 0));
        assertFalse(point2D.checkDistance(p2, 5));
        assertFalse(p2.checkDistance(p, 1));
        // TODO review the generated test code and remove the default call to fail.
        
    }

//    /**
//     * Test of equals method, of class Point2D.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Point2D instance = new Point2D();
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of hashCode method, of class Point2D.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Point2D instance = new Point2D();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
