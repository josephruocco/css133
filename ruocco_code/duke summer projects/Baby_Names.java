
-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------


public class FirstCSVPractice {
    public void tester () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(); 
        //String testcase = countryInfo(parser, "Germany");
        //System.out.println(testcase);
         
        //parser = fr.getCSVParser();
        //listTwoExporters(parser, "cotton", "flowers" );
         
        //parser = fr.getCSVParser();
        //int goldExporters = numberOfExporters(parser, "cocoa");
        //System.out.println("There are " + goldExporters + " countries that export gold");
        
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
        
}
  public String countryInfo (CSVParser parser, String country) {
     String info = "";
    
        for(CSVRecord record: parser){
        String countries = record.get("Country"); 
        if ( countries.contains(country)) {
            return info = record.get("Country")+ ":" + record.get("Exports")+":" + record.get("Value (dollars)");
            
        }
        else {
             return info = "Not Found"; 
            
        }
    }
   return info;
}

public void listTwoExporters (CSVParser parser, String exportItem1, String exportItem2 ) {
     
    for (CSVRecord record: parser) {
        String items = record.get("Exports");
        if (items.contains(exportItem1) && items.contains(exportItem2)) {
            String country = record.get("Country");
            System.out.println(country);
            
        } 
    
    
    }
   
} 

public int numberOfExporters (CSVParser parser, String exportItem ) {
    int count = 0;
    for (CSVRecord record: parser){
        String items = record.get("Exports");
        if (items.contains(exportItem)){
            count = count + 1;
            
        }
        
    }
    return count; 
}

public void bigExporters (CSVParser parser, String amount) {
    for (CSVRecord record: parser) {
        String value = record.get("Value (dollars)");
        if ( value.length() > amount.length() ) {
           
            System.out.println( record.get("Country") +" "+ record.get("Value (dollars)"));
        
        }  
    }


}
}
 

