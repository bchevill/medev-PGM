/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NguyenQuoc
 */
public class ReaderTest {

    public ReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readFromFile method, of class Reader.
     */
    @Test
    public void testReadFromFile() throws Exception {
        System.out.println("readFromFile");
        String filename = "lena.pgm";
        PGMImage expResult = new PGMImage(512, 512);
        PGMImage expResult2 = new PGMImage(512, 512);
        expResult = Reader.readFromFile(filename);
        Writer.writeToFile(expResult, "resultExp.pgm");
        expResult2 = Reader.readFromFile("resultExp.pgm");
        
        ArrayList<Integer> pixelArray1, pixelArray2;
        
        pixelArray1=expResult.getPixelArray();
        pixelArray2=expResult2.getPixelArray();
        
        assertEquals(pixelArray1,pixelArray2);
        
        
//        String ligne1;
//        BufferedReader br1 = new BufferedReader(new FileReader(filename));
//        StringTokenizer tokenizer1;
//        
//        String ligne2;
//        BufferedReader br2 = new BufferedReader(new FileReader("resultExp.pgm"));
//        StringTokenizer tokenizer2;
//        
//        String mot1, mot2;
//        
//        
//        
//        while((ligne1 = br1.readLine())!=null && (ligne2 = br2.readLine())!=null){
//                tokenizer1  = new StringTokenizer(ligne1," \t");
//                tokenizer2  = new StringTokenizer(ligne2," \t");
//                
//                while(tokenizer1.hasMoreTokens() && tokenizer2.hasMoreTokens()){
//                    
//                    mot1 = tokenizer1.nextToken();
//                    mot2 = tokenizer2.nextToken();
//                    
//                    System.out.println("mot 1 : "+mot1);
//                    System.out.println("mot 2 : "+mot2);
//                    assertEquals(mot1,mot2);                   
//                }
//            }

        // TODO review the generated test code and remove the default call to fail.

    }

}
