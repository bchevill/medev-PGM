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
    
    public void fillPixelArray(int [] a) {
        if(a.length != pixelArray.length) {
            System.out.println("Size error");}
        else {
            for(int i=0; i<a.length; i++){ 
                pixelArray[i]=a[i];
            }       
        }
    }
    
    public void fillImage() {
     
        for(int i=0; i<pixelArray.length; i++){
            
            pixelArray[i] = Math.round( (float) i*greyScale/pixelArray.length );
        }
        
    }
    
    public PGMImage diff(PGMImage I){
       
    if(!(l==I.getL() && h==I.getH())) {
        System.out.println("Les images n'ont pas la même taille");
        return I;
    }
        
    PGMImage delta = new PGMImage(l,h);
    int[] dataArray = I.getPixelArray();
    int[] resArray = null;
    
    for(int i=0; i<pixelArray.length; i++){
            
       resArray[i] = pixelArray[i]-dataArray[i]>0?pixelArray[i]-dataArray[i]:0;
    }
    
    delta.fillPixelArray(resArray);
    
    return delta;           
    }
                
}
