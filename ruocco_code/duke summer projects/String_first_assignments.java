
-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------

import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene (String dna) {
        String result = "";
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1 ){
            return "";
        } 
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if (endIndex == -1) {
           return "";  
        }
        
      if ( (endIndex - startIndex) % 3 == 0 ) {
            result = dna.substring(startIndex, endIndex + 3); 
        }
        return result; 
    }
    public void testSimpleGene () {
         
        // testcase with neither ATG nor TAA in dna
        String dna = "TGCAATCTTTGACA";
        System.out.println("DNA strand is " + dna);
         String gene = findSimpleGene(dna); 
        System.out.println("Gene is" + gene);
        // test case with no ATG in dna 
        dna  = "AGGCCTAGTAA";
         System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna); 
        System.out.println("Gene is" + gene);
       
        // test case with no TAA in strand
         dna  = "AGCCCTTTAGAGAGAGATG";
      System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna); 
        System.out.println("Gene is " + gene);
        // test case that is a multiple of 3
         dna  = "ATGAGGGGGTTTCCCTAA";
        System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna); 
        System.out.println("Gene is " + gene);
        // test case that is not a multiple of 3
         dna  = "ATGCCGTCTAA";
        System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna); 
        System.out.println("Gene is " + gene);
        
        
    }

  
}
    
    












public class Part2 {
    public String findSimpleGene (String dna, String startCodon, String stopCodon) {
        String result = "";
        
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1 ){
            return "";
        }
        
        int endIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (endIndex == -1) {
           return "";  
        }
        
      if ( (endIndex - startIndex) % 3 == 0 ) {
            result = dna.substring(startIndex, endIndex + 3); 
        }
        
        if (dna.toUpperCase() == dna )
       {
           result.toUpperCase();
        }
        return result; 
    }
    public void testSimpleGene () {
         
        // testcase with neither ATG nor TAA in dna
        String dna = "TGCAATCTTTGACA";
        System.out.println("DNA strand is " + dna);
         String gene = findSimpleGene(dna, "ATG", "TAA"); 
        System.out.println("Gene is" + gene);
        // test case with no ATG in dna 
        dna  = "AGGCCTAGTAA";
         System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna, "ATG", "TAA"); 
        System.out.println("Gene is" + gene);
       
        // test case with no TAA in strand
         dna  = "AGCCCTTTAGAGAGAGATG";
      System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna, "ATG", "TAA"); 
        System.out.println("Gene is " + gene);
        // test case that is a multiple of 3
         dna  = "ATGAGGGGGTTTCCCTAA";
        System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna, "ATG", "TAA"); 
        System.out.println("Gene is " + gene);
        // test case that is not a multiple of 3
         dna  = "ATGCCGTCTAA";
        System.out.println("DNA strand is " + dna);
          gene = findSimpleGene(dna, "ATG", "TAA"); 
        System.out.println("Gene is " + gene);
        
        
    }
    
        
}

public class Part3 {
    public  boolean twoOccurences (String stringa, String stringb) {
       
         
        
        int oneOccurence = stringb.indexOf(stringa);
        
        int twoOccurence = stringb.indexOf(stringa, oneOccurence + stringa.length() );
        
        
        if ( oneOccurence == -1 ) {
            return false;
        
        }
        if ( twoOccurence == -1) {
            return false; 
        }
        else {
            return true;
        }
    
    }
    public void test () {
        /*
        // test cases for Part 3 method 
        String argtest = "a IN banana";
        System.out.println("For parameter " + argtest);
        boolean test = twoOccurences("a", "banana");
        System.out.println("Test is " + test);
        
          argtest = "a car IN a car is a car";
        System.out.println("For parameter " + argtest);
          test = twoOccurences("a car", "a car is a car");
        System.out.println("Test is " + test);
    
          argtest = "tree IN forest";
        System.out.println("For parameter " + argtest);
          test = twoOccurences("tree", "forest");
        System.out.println("Test is " + test);
    
          argtest = "a rose IN a rose is a rose";
        System.out.println("For parameter " + argtest);
         test = twoOccurences("a rose", "a rose is a rose");
        System.out.println("Test is " + test);
    
          argtest = "sea IN seashells by the seashore";
        System.out.println("For parameter " + argtest);
          test = twoOccurences("sea", "seashells by the seashore");
        System.out.println("Test is " + test);
        */
        
        String argtest = "abbot AFTER a ";
        System.out.println("For parameter " + argtest);
        String result = lastPart("a", "abbot");
        System.out.println("Test is " + result);
        
          argtest = "a car is a sandwich AFTER sandwich";
        System.out.println("For parameter " + result);
          result = lastPart("a car", "a car is a sandwich");
        System.out.println("Test is " + result);
    
          argtest = "forest AFTER tree";
        System.out.println("For parameter " + argtest);
          result = lastPart("tree", "forest");
        System.out.println("Test is " + result);
    
          argtest = "a rose is a car AFTER rose ";
        System.out.println("For parameter " + argtest);
         result = lastPart("a rose", "a rose is a car");
        System.out.println("Test is " + result);
    
          argtest = "seashells by the shorline AFTER sea";
        System.out.println("For parameter " + argtest);
          result = lastPart("sea", "seashells by the shorline");
        System.out.println("Test is " + result);
    }
    public String lastPart (String stringa, String stringb) {
            // Find first occurence of string a in string b
            int firstOccurence = stringb.indexOf(stringa);
            // find preceding characters after string a
            // if it does not occur return string b 
            if ( firstOccurence == -1) {
                return stringb;
            }
            else {
                return stringb.substring(firstOccurence + stringa.length(), stringb.length() );
            }
    }

    public class Part4 {
    public void findLink () {
    URLResource webpage = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for (String word: webpage.words()) {
         
        String little = word.toLowerCase();
        int linkIndex = little.indexOf("youtube");
        
        if ( linkIndex != -1) {
            
            int endquote = little.indexOf("\"", linkIndex);
            int startquote = little.lastIndexOf("\"", linkIndex);
            
            String link = word.substring(startquote + 1, endquote);
            System.out.println(link);
            
        }
}
}
}
