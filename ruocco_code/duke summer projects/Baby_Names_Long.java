
-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------




import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class MiniProjectBabyNames {
    public void totalBirths ( ) {
     // get a file
     FileResource fr = new FileResource();
     // init a var to count boy # 
     int totalBoys = 0;
     // init a var to count girl #
     int totalGirls = 0;
     // iterate over all rows in csv record
     for (CSVRecord record : fr.getCSVParser(false)) {
         // if the record lists a boy, store the # of births in total boys
         if (record.get(1).equals("M")){
             totalBoys = totalBoys + 1;
             //for following entries, increase totalBoys by the increased value of numBorn
            
            } 
         else {
             // see above
             totalGirls = totalGirls + 1;
         }
         
    }
    
    System.out.println("Total boys are " + totalBoys);  
    
    System.out.println("Total girls are " + totalGirls);  
}

public int getRank (int year, String name, String gender) {
    // pick a file
    FileResource fr = new FileResource();
    
    CSVParser parser = fr.getCSVParser(false);
    
    int rank = 0;
    // for each row in the file
    for (CSVRecord record : parser){
    //check if the gender matches for the parameter
        if ( record.get(1).equals(gender) ){
          // increase rank by 1 
          rank = rank + 1; 
          // determine that name is corrent
          if (record.get(0).equals(name) ){
             break;
          }
                
    }
     
    
    }
    return rank ;
}

public void testgetRank () {
    
    int rank = getRank(1971, "Frank", "M");
    System.out.println("Ava is " + rank + " in 2014");
}

public String getName (int year, int rank, String gender) {
    // choose a file
    FileResource fr = new FileResource( );
    // file does not have headers
    CSVParser parser = fr.getCSVParser(false);
    // iterate over each row in file
   String name = null;  
    
   int currentRow = 0;
   for (CSVRecord record : parser) {
    
    if (record.get(1).equals(gender)) {
        currentRow = currentRow + 1; 
     if (currentRow == rank) {  
       name =  record.get(0);
    }
   
}
}
 return name; 
}

public void testgetName () {
    String test1 = getName(1980,350,"F" );
    System.out.println("Rank 350 name: " + test1);
    String test2 = getName(1982, 450, "M");
    System.out.println("Rank 450 name: " + test2);
}

public void whatisNameInYear (String name, int year, int newYear, String gender) {
  
   int currRank = getRank(year, name, gender);
   
   String equalName = getName(year, currRank, gender);
   
   String newName = getName(newYear, currRank, gender);
   
    if (gender == "F"){
        System.out.println( name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
           }
    else if (gender == "M"){ 
        //Isabella born in 2012 would be Sophia if she was born in 2014.
        System.out.println( name + " born in " + year + " would be " + newName + " if he was born in " + newYear);
    
   }

}

public void testwhatisNameInYear () {
   
    whatisNameInYear("Susan", 1972, 2014, "F" );
    
    whatisNameInYear("Owen", 1974, 2014,  "M");
    

}

public int yearOfHighestRank (String name, String gender) {
    // initialize a rank for the parameters in selected files
    int highestrank = 0;
    // initialize a number that will updated with highest year in which the params occur
    int highestYear = 0;
    // get a collection of files
    DirectoryResource dr = new DirectoryResource();
    // iterate over files 
    for (File f : dr.selectedFiles()) {
     //highest rank assumes rank to be the highest so far
    String fileName = f.getName();
    // convert the year of that fileName to int and store in HighestYear. 
    int year = Integer.parseInt(fileName.substring(3,7));
        
    FileResource fr = new FileResource(f);
    //get rank for name in this year
    CSVParser parser = fr.getCSVParser(false);
    //find a temporary rank
    int temprank = 0;
    // for each row in the file
        for (CSVRecord record : parser){
        //check if the gender matches for the parameter
         if ( record.get(1).equals(gender) ){
          // increase rank by 1 
          temprank = temprank + 1; 
          // determine that name is corrent
          if (record.get(0).equals(name) ){
             break;
          }
          else{
            
            } 
                
         }
    
     }
     
    //if rank in this file is higher than the highest rank you've seen so far
        if (highestrank == 0 && temprank != -1 ) {
            highestrank = temprank; 
            highestYear = year;
    }
    
    else {
        // if the rank just found has a lesser value, that rank is higher than the highest rank.
        if( temprank < highestrank && temprank != -1 ){
             
             highestrank = temprank; 
             
             highestYear = year;
        
        }
        
    }

   }
  //return variable to keep track of year with highest rank
   return highestYear; 

}
 
public void testYearOfHighestRank () {
    
 
    int year1 = yearOfHighestRank("Genevieve", "F");
    System.out.println(" Year of Highest Rank: Genevieve, 'F': " + year1);
    int year2 = yearOfHighestRank("Mich","M");
    System.out.println(" Year of Highest Rank: Mich, 'M': " + year2);
   
      year2 = yearOfHighestRank("Mason","M");
    System.out.println(" Year of Highest Rank: Mason, 'M': " + year2);

}
 
public Double getAverageRank (String name, String gender ) {
   // get a Directory Resource (collection of files)
   DirectoryResource dr = new DirectoryResource();
   // # of files 
   int numfiles = 0;
   //initialize currentRank
   int currentRank = 0;
   //initialize totalRank, which takes all ranks and adds them together
   int totalRanks = 0;
   // iterate over files  
    for (File f : dr.selectedFiles()){
    // increase the count for the # of files
    numfiles = numfiles + 1;
    //following are steps to get rank: get FileResource
    FileResource fr = new FileResource(f);
    // initialize a parser to iterate over file
    CSVParser parser = fr.getCSVParser(false);
    // iterate over each row in file
   int temprank = 0;
    for (CSVRecord record : parser){
      //check if the gender matches for the parameter
       
        if ( record.get(1).equals(gender) ){
          // increase rank by 1 
          temprank = temprank + 1;
          // increment currentRank for gender until name is found
          if (record.get(0).equals(name) ){
              //exit record loop
              currentRank = temprank;
              break;
          }
          
        }
      // sum currentRank found ^ with current total Ranks of other files
    
    }
    
    totalRanks = currentRank + totalRanks;
  
}

 if (totalRanks == 0 ) {
        return -1.0;
    } 
  else {
       return (double)(totalRanks)/numfiles;
    }
    
}

public void testgetAverageRank () {
      
    double test1 = getAverageRank("Jacob", "M");
     System.out.println("The average rank of Jacob is " + test1);
      test1 = getAverageRank("Susan", "F");
     System.out.println("The average rank of Susan is " + test1);
      test1 = getAverageRank("Robert", "M");
     System.out.println("The average rank of Robert is " + test1);
    
}

public int getTotalBirthsRankedHigher (int year, String name, String gender) {
    //get a file 
    FileResource fr = new FileResource();
    //totalBirths initialized to zero
    int totalBirths = 0;
     //current Rank initialized at zero
    int currentRank = 0;
    //iterate over rows in the file
    for (CSVRecord record: fr.getCSVParser(false)) {
       
        // check if gender matches
        if (record.get(1).equals(gender) ){
            // increase count of rank by one  
            currentRank = currentRank + 1; 
            // check if the names are equivalent
            if (record.get(0).equals(name) ) {  
                //retain currentRank and exit the loop
                break;
               
               }
   
        }
    
    }
 
    // number of ranks higher than the given name
    int currentRankHigher = 0;
    // iterate over collection of files
    for(CSVRecord record : fr.getCSVParser(false)){
       // if record of gender matches parameter...
        if(record.get(1).equals(gender)){
          // increase current rank (Higher than name) by 1
          currentRankHigher++;
          if(currentRankHigher < currentRank){
             // increase   
             totalBirths = totalBirths + Integer.parseInt(record.get(2));
          }
            
        }
        
    }
        
    //total number of births of those names with the same gender and same year who are ranked higher than name
    return totalBirths;
}

public void testTotalBirthsRankedHigher( ) {
    int sum = getTotalBirthsRankedHigher(1990, "Emily", "F");
    System.out.println(sum);
    sum = getTotalBirthsRankedHigher(1990, "Drew", "M");
    System.out.println(sum);
    }
    
}
 