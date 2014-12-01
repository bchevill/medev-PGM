/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

/**
 *
 * @author rlebail
 */
public class PGMImage {
    
    public final static int greyScale = 255;
    public final static int lineLength = 70;
    
    private int l;
    private int h;
    private int[] pixelArray;

    public PGMImage(int largeur, int hauteur){
        l=largeur;
        h=hauteur;
    
    for(int i=0;i<l*h;i++) pixelArray[i]=0;
        
    }
    
   public PGMImage(PGMImage I){
        l = I.getL();
        h = I.getH();
        pixelArray = I.getPixelArray().clone();
    } 
       
    
    /**
     * @return the l
     */
    public int getL() {
        return l;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @return the pixelArray
     */
    public int[] getPixelArray() {
        return pixelArray;
    }
    
    public void fillImage() {
     
        for(int i=0; i<pixelArray.length; i++){
            
            pixelArray[i] = Math.round( (float) i/greyScale );
        }
        
    }
    
    
}
