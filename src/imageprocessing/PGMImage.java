/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.util.ArrayList;

/**
 *
 * @author rlebail
 */
public class PGMImage {
    
    public final static int greyScale = 255;
    public final static int lineLength = 70;
    
    private int l;
    private int h;
    private ArrayList<Integer> pixelArray;

    public PGMImage(int largeur, int hauteur){
        l=largeur;
        h=hauteur;
        pixelArray = new ArrayList<>();
        for(int i=0;i<l*h;i++) {pixelArray.add(200);}
        
    }
    
   public PGMImage(PGMImage I){
        l = I.getL();
        h = I.getH();
        pixelArray = I.getPixelArray();
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
    public ArrayList<Integer> getPixelArray() {
        return pixelArray;
    }
    
    public void fillPixelArray(ArrayList a) {
        if(a.size() != pixelArray.size()) {
            System.out.println("Size error");}
        else {
            for(int i=0; i<a.size(); i++){ 
                pixelArray.set(i,(int)a.get(i));
            }       
        }
    }
    
    public void fillImage() {
     
        for(int i=0; i<pixelArray.size(); i++){
            
            pixelArray.set(i, Math.round( (float) i*greyScale/pixelArray.size() ));
        }
        
    }
    
    public PGMImage diff(PGMImage I){
    
    int diffVal = 0;
        
    if(!(l==I.getL() && h==I.getH())) {
        System.out.println("Les images n'ont pas la même taille");
        return I;
    }
        
    ArrayList<Integer> dataArray = I.getPixelArray();
    ArrayList<Integer> resArray = new ArrayList<>();
    
    for(int i=0; i<pixelArray.size(); i++){
       
       diffVal = pixelArray.get(i)-dataArray.get(i)>0?(pixelArray.get(i)-dataArray.get(i)):0;
       resArray.set(i, diffVal);
    }
    
    PGMImage delta = new PGMImage(l,h);
    delta.fillPixelArray(resArray);
    
    return delta;           
    }
    
    public PGMImage seuil(int s){
       ArrayList<Integer> resArray = new ArrayList<>();
       int diffVal = 0;
       
       for(int i=0; i<pixelArray.size(); i++){
           diffVal =  pixelArray.get(i)>s?255:0;
           resArray.set(i,diffVal);
       } 
       
    PGMImage seuild = new PGMImage(l,h);
    seuild.fillPixelArray(resArray);
    
    return seuild;   
    }
    
    public PGMImage seuil(){
       return this.seuil(127);
    }
    
    public PGMImage generateHistogram() {
        
       
       ArrayList<Integer> freqArrays = new ArrayList<>();
       int maxFreq = 0;
       
       for(int i=0; i<pixelArray.size(); i++){
           freqArrays.set(pixelArray.get(i),freqArrays.get(pixelArray.get(i)+1));
           if(freqArrays.get(pixelArray.get(i))>maxFreq){
               maxFreq=freqArrays.get(pixelArray.get(i));
           }
       } 
       
       
       ArrayList<Integer> histPixelArray = new ArrayList<>();
       
       for(int i=0; i<256; i++){
           for(int j=0; j<maxFreq; j++){
             
               
            if(j<freqArrays.get(i))
            {histPixelArray.set(maxFreq*i+j,0);}
            else
            {histPixelArray.set(maxFreq*i+j,255);}
            
           }
       }
        
       PGMImage histImage = new PGMImage(maxFreq,256); 
       histImage.fillPixelArray(histPixelArray);
       
       return histImage;        
    }
    
    public void resizeH(int hauteur, PGMImage I)
    { 
        int deltaH = h-hauteur; 
        
        if(deltaH==0){return;}
        if(deltaH>0){ //réduction
        int[] delIndicesArray = new int[deltaH];    
            
        for(int i=0;i<deltaH;i++){
            delIndicesArray[i]=Math.round((float) i*h/deltaH);
        }    
        
        for(int i=0;i<h;i++){
            
            
            
        }
            
            
        }
        else{
            
            
            
            
        }
    }
    
    public void resizeL(int largeur, PGMImage I)
    {
        int deltaL = l-largeur;
    }       
            
    public PGMImage resize(int largeur, int hauteur){
    
    PGMImage I = new PGMImage(largeur, hauteur);
        
    resizeH(hauteur,I);
    resizeL(largeur,I);    
    
    return I;
    }
}
