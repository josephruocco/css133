-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------




public class Part1 {
       public int findStopCodon ( String dna, int startIndex, String stopCodon) {
           // THis method returns the index of the first occurence of StopCodon that appears
           // past startIndex and is a multiple of three away from startIndex
            
           int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
           
           
           while ( currentIndex != -1  ) {
              if ( (currentIndex - startIndex) % 3 == 0 ){
                  
                  return currentIndex;
                
                }
              else {
                
                  return dna.length();
                }
             
            
            }
           return 0;
        
        } 
    
       public String findGene (String dna ) {
           // find the index of the first occurence of start codon "ATG". 
           int startIndex = dna.indexOf("ATG") ;
           // if there is no ATG, return the empty string.
           if (startIndex != -1 ){
               return "";
            }
           // find the index of the first occurence of the stop codon TAA after the first
           // occurence of ATG that is a multiple of 3 away from ATG
         int taaIndex = findStopCodon(dna, startIndex, "TAA");
           //Find the index of the first occurrence of the stop codon “TAG”  
           //that is a multiple of three away from the “ATG”. 
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
           
           //Find the index of the first occurrence of the stop codon “TGA” 
           //that is a multiple of three away from the “ATG
          
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = 0;
        
        // if TAA is not found or TGA is found and less than the index of TAA
        if ( taaIndex == -1 || ( tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        // if minIndex value is not found or  TAG index is found and closer than minIndex
        if ( minIndex == -1 || ( tagIndex != -1 && tagIndex < minIndex )) {
            minIndex = tagIndex;
        
        }
        // if there is no gene return the empty string 
        if ( minIndex == -1 ) {
            return "";
        }
       
        return dna.substring(startIndex, minIndex + 3); 
        
}
    
public void testFindGene () {
    // test cases:
    // for each test, print the DNA string and 
    // calculate the gene by sending this DNA string as an 
    // argument to findGene - if test works print gene else "";
    
    // no ATG in dna string
    String dna = "ATTTGGCCGCGCGCTAA";
    System.out.println("Dna strand is " + dna);
    String gene = findGene(dna);
    if ( findGene(dna) != "" ) {
        System.out.println("Gene is " + gene);
    }
    else {
        System.out.println("");
    }
    //Dna with one ATG and one valid stop Codon,
     dna = "ATGATTTGGCCGCGCGCTAA";
    System.out.println("Dna strand is " + dna);
     gene = findGene(dna);
    if ( findGene(dna) != "" ) {
        System.out.println("Gene is " + gene);
    }
    else {
        System.out.println("");
    }
    // Dna with ATG and multiple valid stop Codons, 
     dna = "ATTTGGCCGTAGCGCGCGTAA";
    System.out.println("Dna strand is " + dna);
     gene = findGene(dna);
    if ( findGene(dna) != "" ) {
        System.out.println("Gene is " + gene);
    }
    else {
        System.out.println("");
    }
    //Dna with ATG and no valid stopCodons
     dna = "ATTTGGCCGCGCGC";
    System.out.println("Dna strand is " + dna);
     gene = findGene(dna);
    if ( findGene(dna) != "" ) {
        System.out.println("Gene is " + gene);
    }
    else {
        System.out.println("");
    }
    
}
}

public class Part2 {
    public int howMany ( String stringa, String stringb) {
        
        // find the first occurence of a in b
        int currentIndex = stringb.indexOf(stringa);
        //  count the number of times starting with 1 
        int count = 0;
        // if first occurence is found
      
                // if following occurence is found, increase times by 1 
        while ( currentIndex != -1 ) {
            // look for following occurence past 1st one
            int StopIndex = currentIndex + stringa.length();
            count = count + 1; 
            currentIndex = stringb.indexOf(stringa,StopIndex);
        }
       // how many times does string a occur in string b
        return count;
    }
     
 
    public void testHowMany () {
        
        String stringa = "m";
        String stringb = "month";
        System.out.println( "how many " + stringa + "'s occur in " + stringb);
        int result  = howMany(stringa, stringb);
        System.out.println("There are " + result + " occurences!");
        
        
         stringa = "a";
         stringb = "banana";
        System.out.println( "how many " + stringa + "'s occur in " + stringb);
         result  = howMany(stringa, stringb);
        System.out.println("There are " + result + " occurences!");
       
         stringa = "m";
         stringb = "month";
        System.out.println( "how many " + stringa + "'s occur in " + stringb);
         result  = howMany(stringa, stringb);
        System.out.println("There are " + result + " occurences!");
        
        
    }
}

public class Part3 {
  public int findStopCodon ( String dna, int startIndex, String stopCodon) {
           // THis method returns the index of the first occurence of StopCodon that appears
           // past startIndex and is a multiple of three away from startIndex
            
           int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
           
           
           while ( currentIndex != -1  ) {
              if ( (currentIndex - startIndex) % 3 == 0 ){
                  
                  return currentIndex;
                
                }
              else {
                
                  return dna.length();
                }
             
            
            }
           return 0;
        
        } 
      public String findGene (String dna ) {
           // find the index of the first occurence of start codon "ATG". 
           int startIndex = dna.indexOf("ATG") ;
           // if there is no ATG, return the empty string.
         if (startIndex != -1 ){
               return "";
            }
           // find the index of the first occurence of the stop codon TAA after the first
           // occurence of ATG that is a multiple of 3 away from ATG
         int taaIndex = findStopCodon(dna, startIndex, "TAA");
           //Find the index of the first occurrence of the stop codon “TAG”  
           //that is a multiple of three away from the “ATG”. 
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
           
           //Find the index of the first occurrence of the stop codon “TGA” 
           //that is a multiple of three away from the “ATG
          
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = 0;
        
        // if TAA is not found or TGA is found and less than the index of TAA
        if ( taaIndex == -1 || ( tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        // if minIndex value is not found or  TAG index is found and closer than minIndex
        if ( minIndex == -1 || ( tagIndex != -1 && tagIndex < minIndex )) {
            minIndex = tagIndex;
        
        }
        // if there is no gene return the empty string 
        if ( minIndex == -1 ) {
            return "";
        }
       
        return dna.substring(startIndex, minIndex + 3); 
        
}
public int CountGenes (String dna) {
    
    int CurrentIndex = dna.indexOf("ATG");
    
    int noGenes = 0;
         
   // if ATG is found  
    while ( CurrentIndex != -1)  {
       //find a gene 
        String gene = findGene(dna);
        
         // update where 
        
         int StopIndex = (CurrentIndex + 3) + gene.length();
        
         // update Current Index 
         CurrentIndex = dna.indexOf("ATG", StopIndex);
         
         
         //increase Gene # by 1
         noGenes = noGenes + 1; 
        
    
    }
    
    return noGenes; 


}
public void testCountGenes () {
      // two genes
    String dna = "CATGGGGTAACGCGATGCGCGCGCGCGCGTAG";
      System.out.println("This is dna " + dna + " with two genes");
      int gene = CountGenes(dna);
      System.out.println("There are " + gene + " in this dna strand" );
      // three genes
        dna = "ATGTAAATGTGAATGTAA";
      System.out.println("This is dna " + dna  + " with three genes");
       gene = CountGenes(dna);
      System.out.println("There are " + gene + " in this dna strand" );
      // no genes - no ATG
        dna = "TAAGCGCGCGCGCGCTAA";
      System.out.println("This is dna " + dna + " with no genes");
       gene = CountGenes(dna);
      System.out.println("There are " + gene + " in this dna strand" );
      // five genes 
        dna = "ATGGGTAACCCATGAAATAAGGGATGCGCGCGTAAAGCGCAATGGGTAACCCATGAAATAA";
      System.out.println("This is dna " + dna + " with five genes");
       gene = CountGenes(dna);
      System.out.println("There are " + gene + " this dna strand" );
      // five genes
        dna = "ATGGGTAACCCATGGGTAGAAAATGGGTAAAAAATGCCCTGA";
      System.out.println("This is dna " + dna + " four genes");
       gene = CountGenes(dna);
      System.out.println("There are " + gene + " in this dna strand" );
      

}
}


public class Part3_1 {
    public int howMany (String stringa, String stringb) {
    
    int CurrentIndex = stringb.indexOf(stringa);
    int count = 0;
    
    while (CurrentIndex != -1 ){
        int StopIndex = CurrentIndex + stringa.length();
        CurrentIndex = stringb.indexOf(stringa, StopIndex);
        count = count + 1;
    
    }
    
    return count; 
    }
    public void testhowMany () {
        String stringa = "a";
        String stringb = "banana";
        int result = howMany(stringa, stringb);
        System.out.println("There are " + result + " occurences of " + stringa + " in " + stringb );
    
    }
}
