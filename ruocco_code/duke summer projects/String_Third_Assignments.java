
-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------


import edu.duke.*;


public class Part1 {
    public int findStopCodon (String dnaStr, int startIndex, 
    String stopCodon) {
         int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
         while (currIndex != -1) {
            int diff = currIndex - startIndex; 
            if (diff % 3 == 0) {
                return currIndex;
            }
            else {  
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
            
            }
            return -1;
    }
    public String findGene (String dna, int where) {
    int startIndex = dna.indexOf("ATG", where);
    if  ( startIndex == -1){
        return "";
    }
    int taaIndex = findStopCodon(dna, startIndex, "TAA");
    int tagIndex = findStopCodon(dna, startIndex, "TAG");
    int tgaIndex = findStopCodon(dna, startIndex, "TGA");
    
    //int temp = Math.min(taaIndex, tagIndex);
    //int minIndex = Math.min(temp, tgaIndex);
    int minIndex = 0;
    if ( taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex) ) {
        minIndex = tgaIndex;
    
    }
    else {
        minIndex = taaIndex;
    }
    
    if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex))
    {
        minIndex = tagIndex;
    }
    
    if (minIndex == -1 ){
        return "";
    }
    return dna.substring(startIndex, minIndex+3);
    } 
    

    public StorageResource getallGenes(String dna) {
    int startIndex = 0;
    StorageResource genepool = new StorageResource();
    while (true) {
        String currentGene = findGene(dna, startIndex);
        
        if (currentGene.isEmpty()) {
            break;
        }
  
        genepool.add(currentGene);
        
        startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        
    }
    return genepool;
    }
    
    public int testOn (String dna) {
        System.out.println("This is a test of getAllGenes"); 
        StorageResource genes = getallGenes(dna);
        int count = 0; 
        for (String g: genes.data()){
             System.out.println(g);
             count = count + 1 ;
        }
         return count;
    }
     
    public void test ( ) {
       StorageResource dnastrand = new StorageResource();
        FileResource fr = new FileResource("GRch38dnapart.fa");
         String dna = fr.asString();
         dnastrand.add(dna);
         StorageResource genelist = getallGenes(dna);
        int genes = processGenes(genelist);
        System.out.println("The longest gene here is: " + genes );
        
    
    
    }
    public float cgRatio (String dna) {
        int indexC = dna.indexOf("C");
        int indexG = dna.indexOf("G");
        
        double countC = 0;
        double countG = 0;
        
        while (true) {
           if ( indexC != -1) {
               indexC = dna.indexOf("C", indexC + 1 );
               countC ++ ;
    }
    else if ( indexG != -1 ) {
        indexG = dna.indexOf("G", indexG + 1);
        countG ++ ; 
    }
     float ratio = (float)( countC + countG) / dna.length();
     return ratio;
    }
    }
    public void testcgRatio ( ) {
        System.out.println("Testing CG Ratio, Expected 1.5");
        double cgratio = cgRatio("AGAGAGCCTCTC");
        System.out.println("The cg Ratio here is " + cgratio);


    }
    public int countCTG (String dna) {
    int currIndex = dna.indexOf("CTG", 0);
    int count = 0;
    
    while ( currIndex != -1) {
        currIndex = dna.indexOf("CTG", currIndex + 3);
        count ++;
   
    }
    return count; 
    }
    public void testCountCTG(){
    FileResource fr = new FileResource("GRch38dnapart.fa");
     String dna = fr.asString();
    int ctgCount = countCTG(dna);
    System.out.println("There are "+ ctgCount + " CTG in "+dna);
    }

    public int processGenes (StorageResource sr ) {
       //cCount: character counts
    int countNine = 0;
        //rCount: ratio counts
    int countRatio = 0;
    int geneLength = 0;
    int longestGene = 0;
    
    
    for(String g: sr.data() ) {
       
        //1.print the strings that's longer than 9 chracters
            //2.count the number of those strings
       if ( g.length() > 60){
           System.out.println("Gene that is longer than 60 characters is " + g);
           countNine = countNine + 1; 
    }
     //3.print the strings that has a cgRatio is higher than 0.35
            //4.count the number of those strings
     float ratio = cgRatio(g);
    if (ratio > .35){
        System.out.println("String whose CG ratio is higher than .35 is " + g);
        countRatio = countRatio + 1 ; 
    }
    
    int currGene = Math.max( g.length(), longestGene);
    
    longestGene = currGene; 
        
    }
    System.out.println("The number of strings that are longer than 60 characters are "+ countNine);
    System.out.println("The number of strings whose CG ratio is higher than 0.35 are "+ countRatio );
    System.out.println("The longest gene is " + longestGene + ", it's length is " + longestGene);
    return longestGene;
   }
    
    }

    public class thisthing {
    public String mystery(String dna) {
  int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}
public void test () {
    String result = mystery("ATCGGCTCATCGA"); 
    System.out.println(result);
    

}
}