/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


/**
 *
 * @author cando
 */
public class PGMImageTest {
    
    public PGMImageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getL method, of class PGMImage.
     */
    @ Ignore
    @Test
    public void testGetL() {
        System.out.println("getL");
        PGMImage instance = null;
        int expResult = 0;
        int result = instance.getL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getH method, of class PGMImage.
     */
    @ Ignore
    @Test
    public void testGetH() {
        System.out.println("getH");
        PGMImage instance = null;
        int expResult = 0;
        int result = instance.getH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPixelArray method, of class PGMImage.
     */
    @ Ignore
    @Test
    public void testGetPixelArray() {
        System.out.println("getPixelArray");
        PGMImage instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getPixelArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillPixelArray method, of class PGMImage.
     */
    @Ignore
    @Test
    public void testFillPixelArray() {
        System.out.println("fillPixelArray");
        ArrayList a = null;
        PGMImage instance = null;
        instance.fillPixelArray(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillImage method, of class PGMImage.
     */
    @Ignore
    @Test
    public void testFillImage() {
        System.out.println("fillImage");
        PGMImage instance = null;
        instance.fillImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff method, of class PGMImage.
     */
    @Ignore
    @Test
    public void testDiff() {
        System.out.println("diff");
        PGMImage I = null;
        PGMImage instance = null;
        PGMImage expResult = null;
        PGMImage result = instance.diff(I);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seuil method, of class PGMImage.
     */
    @Test
    public void testSeuil_int() {
        System.out.println("seuil");
        int s = 100;
        PGMImage instance = new PGMImage(10,10);
        Writer.writeToFile(instance, "testSeuil.pgm");
        //ArrayList<int> listblanc = new ArrayList<>();
        //for (int i=0; i<100; i++) {listblanc.add(8);}
        //instance.fillPixelArray(listblanc);
        ArrayList<Integer> expResult = new ArrayList<>();
        for (int i=0; i<100; i++) {expResult.add(255);}
        PGMImage result = instance.seuil(s);
        Object[] exRes;
        exRes = expResult.toArray();
        Object[] res;
        res = result.getPixelArray().toArray();
        assertArrayEquals(exRes, res);

    }

    /**
     * Test of seuil method, of class PGMImage.
     */
    @Ignore
    @Test
    public void testSeuil_0args() {
        System.out.println("seuil");
        PGMImage instance = null;
        PGMImage expResult = null;
        //PGMImage result = instance.seuil();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateHistogram method, of class PGMImage.
     */
    @Ignore
    @Test
    public void testGenerateHistogram() {
        System.out.println("generateHistogram");
        PGMImage instance = null;
        PGMImage expResult = null;
        PGMImage result = instance.generateHistogram();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resizeH method, of class PGMImage.
     */
//    @ Ignore
//    @Test
//    public void testResizeH() {
//        System.out.println("resizeH");
//        int hauteur = 0;
//        PGMImage instance = null;
//        instance.resizeH(hauteur);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of resizeL method, of class PGMImage.
//     */
//    @ Ignore
//    @Test
//    public void testResizeL() {
//        System.out.println("resizeL");
//        int largeur = 0;
//        PGMImage instance = null;
//        instance.resizeL(largeur);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of resize method, of class PGMImage.
//     */
//    @ Ignore
//    @Test
//    public void testResize() {
//        System.out.println("resize");
//        int largeur = 0;
//        int hauteur = 0;
//        PGMImage instance = null;
//        instance.resize(largeur, hauteur);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setL method, of class PGMImage.
//     */
//    @ Ignore
//    @Test
//    public void testSetL() {
//        System.out.println("setL");
//        int l = 0;
//        PGMImage instance = null;
//        instance.setL(l);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setH method, of class PGMImage.
//     */
//    @ Ignore
//    @Test
//    public void testSetH() {
//        System.out.println("setH");
//        int h = 0;
//        PGMImage instance = null;
//        instance.setH(h);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}