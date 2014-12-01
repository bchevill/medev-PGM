/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 *Gère l'écriture dans fichier
 * @author gmenudie & oliviernguyen
 */
public class Writer {

    /**
     *Crée unn fichier .pgm a partir d'un PGMImage
     * @param image
     */
    public static void writeToFile(PGMImage image) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("image.pgm"));
            bw.write("P2 \n#\n");
            bw.write(image.getL()+" "+image.getH()+"\n");
            bw.write(Integer.toString(PGMImage.greyScale)+"\n");
         
            for(int i=0;i<(image.getL()*image.getH());i++ ){
                bw.write(Integer.toString(image.getPixelArray()[i])+" ");
                if((i+1)%image.getL()==0)
                {
                    bw.newLine();
                }
            }   
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
