-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------


import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage) {
        // I made a blank image of the same size 
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // for each pixel in outImage
         for (Pixel pixel: outImage.pixels()) {
            // look at corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // comput inPixel's red + inPixel's blue + inPixel's green
            // divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3; 
            // set pixel's red to average 
            pixel.setRed(average);
            // set pixel's green to average 
            pixel.setGreen(average);
            // set pixel's blue to average 
            pixel.setBlue(average);
    }
    return outImage; 

}
public void testGray (){
    ImageResource ir = new  ImageResource ();
    ImageResource gray = makeGray(ir);
    gray.draw();
}
public void SelectAndConvert () {
    DirectoryResource dr = new DirectoryResource();
    for (File f: dr.selectedFiles()) {
        ImageResource inFile = new ImageResource(f);
        ImageResource gray = makeGray(inFile);
        gray.draw();
    }
}
public void doSave() {
        DirectoryResource dr = new DirectoryResource(); 
        for (File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f); 
            String fname = image.getFileName();
            String newName = "gray-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    } 

}


public class InvertConverter {
    public ImageResource makeInvert (ImageResource inImage) {
        
        ImageResource outImage = new ImageResource (inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel: outImage.pixels()) {
            
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            pixel.setRed(255 - inPixel.getRed());
            
            pixel.setGreen(255 - inPixel.getGreen());
            
            pixel.setBlue(255 - inPixel.getBlue());
          
        }
        
        return outImage; 
    
    }
    
    public void SelectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inFile = new ImageResource();
            ImageResource inv = makeInvert(inFile);
            inv.draw();
            
        }
    
    }
    
    
    public void doSave () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource();
            String fname = image.getFileName();
            String newName = "inv-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        
        }
    
    }
}