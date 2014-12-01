/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.util.HashMap;

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
        pixelArray = new int[l*h];
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
        
    int[] dataArray = I.getPixelArray();
    int[] resArray = new int[l*h];
    
    for(int i=0; i<pixelArray.length; i++){
            
       resArray[i] = pixelArray[i]-dataArray[i]>0?pixelArray[i]-dataArray[i]:0;
    }
    
    PGMImage delta = new PGMImage(l,h);
    delta.fillPixelArray(resArray);
    
    return delta;           
    }
    
    public PGMImage seuil(int s){
       int[] resArray = new int[l*h];
       
       for(int i=0; i<pixelArray.length; i++){
            resArray[i] = pixelArray[i]>s?255:0;
       } 
       
    PGMImage seuild = new PGMImage(l,h);
    seuild.fillPixelArray(resArray);
    
    return seuild;   
    }
    
    public PGMImage seuil(){
       return this.seuil(127);
    }
    
    public PGMImage generateHistogram() {
        
       
       int[] freqArrays = new int[255];
       int maxFreq = 0;
       
       for(int i=0; i<pixelArray.length; i++){
           freqArrays[pixelArray[i]]++;
           if(freqArrays[pixelArray[i]]>maxFreq)maxFreq=freqArrays[pixelArray[i]];
       } 
              
       int[] histPixelArray = new int[255*maxFreq];
       
       for(int i=0; i<255; i++){
           for(int j=0; j<maxFreq; j++){
               
            if(j<freqArrays[i])
            {histPixelArray[255*i+j]=255;}
            else
            {histPixelArray[255*i+j]=0;}
               
           }
       }
        
       PGMImage histImage = new PGMImage(255,maxFreq); 
       histImage.fillPixelArray(histPixelArray);
       
       return histImage;        
    }
    
    public void resize(int largeur, int hauteur){
        
        
    }
}
