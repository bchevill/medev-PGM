/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

/**
 *
 * @author rlebail
 */
public class ImageProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Test d'écriture
        PGMImage image= new PGMImage(512,512);
        image.generateHistogram();
        Writer.writeToFile(image);
     
    }
}
