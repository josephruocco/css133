

-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------


import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null; 
       
        for (CSVRecord currentRow : parser ) {
            if ( coldestSoFar == null ){
               coldestSoFar = currentRow; 
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if ( currentTemp < largestTemp ) {
                    coldestSoFar = currentRow; 
                }
            }
        }
        return coldestSoFar;
    
    }
    public void testColdestHourInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //CSV Record is a ROW, to test you then need to access a column from the ROW
        CSVRecord testcase = coldestHourInFile(parser);
        System.out.print("The coldest temp for this file is " + testcase.get("TemperatureF")); 
    
    }
    public String fileWithColdestTemperature () {
   //Row that contains nothing 
    CSVRecord coldestSoFar = null;
   //String that contains nothing
    String fileName = null;
   //Access multiple data sets 
    DirectoryResource dr = new DirectoryResource();
     
    //for selected files from dr
    for (File f: dr.selectedFiles()) {
        // iterate over files
        FileResource fr = new FileResource(f);
        // parse over data and return coldest temperature in File
        CSVRecord currentFile = coldestHourInFile(fr.getCSVParser());
        
        if (coldestSoFar == null) {
            coldestSoFar = currentFile; 
            
        }
        else {
                double currentTemp = Double.parseDouble(currentFile.get("TemperatureF"));
                double largestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if ( currentTemp < largestTemp ) {
                    coldestSoFar = currentFile; 
                    fileName = f.getName();
                      
                }
            }    
    }
    
    return fileName;
    }
    public void testFileWithColdestTemperature () {
        DirectoryResource fr = new DirectoryResource();
        String fileName = fileWithColdestTemperature();
        System.out.println("The file with the coldest temperature is " + fileName);
        
    }
    public CSVRecord lowestHumidityInFile (CSVParser parser) {
         
        CSVRecord lowestHumiditySoFar = null;
        
        for (CSVRecord currentRow : parser) {
            
            if ( lowestHumiditySoFar == null ){
                lowestHumiditySoFar = currentRow; 
            }
            if (currentRow.get("Humidity") != "N/A") {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double lowestTemp = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                if (currentTemp < lowestTemp) {
                     lowestHumiditySoFar = currentRow;
                }
            
            }
        }
        return lowestHumiditySoFar;
    
    }
    public void testlowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    
    }
    public CSVRecord lowestHumidityInManyFiles () {
       CSVRecord lowestHumidity = null; 
       DirectoryResource dr = new DirectoryResource();
      
       
       
       for (File f : dr.selectedFiles()){
           
       FileResource fr = new FileResource(f);
       CSVRecord currentFile = lowestHumidityInFile(fr.getCSVParser());
       
       if (lowestHumidity == null){
        lowestHumidity = currentFile; 
        }
       else {
        double currentTemp = Double.parseDouble(currentFile.get("Humidity"));
        double lowestTemp = Double.parseDouble(lowestHumidity.get("Humidity"));
        if (currentTemp < lowestTemp) {
          lowestHumidity = currentFile;
        }
       }
       }
       return lowestHumidity;
    }
    public void testlowestHumidityInManyFiles () {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord csv = lowestHumidityInManyFiles();
    System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    
    }
    public double averageTemperatureInFile(CSVParser parser) {
    
    double countTotal = 0;
    double sumTotal = 0;
    
    for (CSVRecord record : parser){
        sumTotal = sumTotal + Double.parseDouble(record.get("TemperatureF"));
        countTotal = countTotal + 1;
        }
     return sumTotal/countTotal;
    }
    
    public void testaverageTemperatureInFile ( ) {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    double csv = averageTemperatureInFile(parser);
    System.out.println("Average Temperature in File is " + csv);
    
    }
    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value) {
          
       double countTotal = 0;
       double sumTotal = 0;
    
       for (CSVRecord record : parser){
        if ( Double.parseDouble(record.get("Humidity")) >= value) 
        {
          sumTotal = sumTotal + Double.parseDouble(record.get("TemperatureF"));
          countTotal = countTotal + 1;
        }
        else {
           System.out.println("No temperatures with that humidity!");
        } 
        }
       return sumTotal/countTotal;
    }
    public void testAverageTemperatureWithHighHumidityInFile () {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       double csv = averageTemperatureWithHighHumidityInFile(parser, 80);
       System.out.println("Average Temperature when high Humidity is " + csv);
    
    }
    public void 
    }

