/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import static imageprocessing.PGMImage.greyScale;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author onguyenq
 */
public class WriterTest {

    public WriterTest() {
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
     * Test du writer. On crée une image de aléatoire, on la sauvegarde dans
     * un fichier et on teste que le contenu du fichier est identique à ce qu'on
     * pourrait attendre.
     */
    @Test
    public void testWriteToFile() {

        //On génère l'image
        System.out.println("writeToFile");
        int l = (int) Math.round(Math.random() * 512);
        int h = (int) Math.round(Math.random() * 512);
        System.out.println("l="+l+" h="+h+"\n");
        PGMImage image = new PGMImage(l, h);
        image.fillImage();

        // On enregistre l'image dans le fichier writer_test_file.txt
        Writer.writeToFile(image, "writer_test_file.pgm");

        // On ouvre le fichier généré et on le teste
        String ligne;
        BufferedReader br;
        try {
            
            br = new BufferedReader(new FileReader("writer_test_file.pgm"));
            StringTokenizer tokenizer;
            int i = 0;

            tokenizer = new StringTokenizer(br.readLine(), " ");
            assertEquals("P2", tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            assertEquals("#", tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            assertEquals(Integer.toString(l), tokenizer.nextToken());
            assertEquals(Integer.toString(h), tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            assertEquals("255", tokenizer.nextToken());

            while ((ligne = br.readLine()) != null) {
                tokenizer = new StringTokenizer(ligne, " \t");
                while (tokenizer.hasMoreTokens()) {
                    assertEquals(Integer.parseInt(tokenizer.nextToken()), Math.round((float) i * greyScale / image.getPixelArray().size()));
                    i++;
                }
            }
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Test terminé, on détruit le fichier créé
        File fichier = new File("writer_test_file.pgm");
        assertTrue(fichier.delete());


    }
}