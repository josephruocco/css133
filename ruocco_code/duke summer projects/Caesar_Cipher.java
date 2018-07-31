

-------------------------------------------------
---------------------------------------Ruocco----
------------------------Duke Coding Project------
---------------String Processing Exercises-------



public class WordPlay {
  
   public boolean isVowel (char ch){
       //list of alphabetic vowels to cross-check ch
       String vowels = "AEIOUaeiou";
       // if ch is contained in the list of vowels
       if ( vowels.indexOf(ch) != -1) {
           // return on method is true
           return true;
        }
       else{
           // return on method is false
           return false; 
        }
       
   }
   
   public void testIsVowel(){
    
    boolean Value = isVowel('a');
   
    System.out.println(Value);
    
   }
    
    public String replaceVowels (String phrase, char ch) {
    // create a new StringBuilder object to store replaced chars
    StringBuilder replacedPhrase = new StringBuilder(phrase);
    //iterate over characters in the phrase while i is shorter than phrase length
    for (int i = 0; i < phrase.length(); i++) {
        //test if the current character of replaced phrase is a vowel
        if ( isVowel(replacedPhrase.charAt(i)) == true ){
            //set current character at index i to the char parameter ch
            replacedPhrase.setCharAt(i, ch);  
    
        }
        else {
           // set current character at index i to the character of phrase at the same index
           replacedPhrase.setCharAt(i, phrase.charAt(i));
        }
    
    }
    // exit function handing back replaced Phrase as a String
    return replacedPhrase.toString();
   }
   
   public void testreplaceVowels () {
       
       String test1 = replaceVowels("Hello World!", '*');
       
       System.out.println("test1 : " + test1);
    
    }
    
    public String emphasize (String phrase, char ch ) {
      // create a mutable string out of phrase with StringBuilder
      StringBuilder emphasizedPhrase = new StringBuilder(phrase);
      // iterate over characters in the phrase while i is shorter than phrase length
        for (int i = 0; i < phrase.length(); i++ ) {  
       // if index of character ch in phrase (after i) is at an even LOCATION  
       if ( emphasizedPhrase.charAt(i) == ch && phrase.indexOf(ch,i) % 2 == 0 ) {
           //switch character in emphasized phrase at even location i for '*'
           emphasizedPhrase.setCharAt(i, '*'); 
            
        }
       else if ( emphasizedPhrase.charAt(i) == ch && phrase.indexOf(ch,i) % 2 != 0 ) {
           //switch character in emphasized phrase at odd location i  for '+'
           emphasizedPhrase.setCharAt(i, '+'); 
            
        }
       else {
           //"leave" character in emphasized phrase at location i for the same character in phrase 
           emphasizedPhrase.setCharAt(i, phrase.charAt(i));
        }
        
      }
      // exit function handing back emphasized Phrase as a String
      return emphasizedPhrase.toString();
   }
   
   public void testemphasizeVowels () {
       
       String test1 = emphasize("dna ctgaaactga", 'a');
       
       System.out.println("test1 dna ctgaaactga should return dn* ctg+*+ctg+: " + test1);
    
    }
    
   
   
}


public class WordLengths {
    public void CountWordLengths (FileResource resource, int[] counts) {
        // read words in File Resource
        for (String word : resource.words()) {
            //for the first word, retrieve its length
            int length = word.length();
            //
            char firstChar = word.charAt(0);
            
            char lastChar = word.charAt(word.length() - 1);
            //check that character is a letter
            if ( Character.isLetter(firstChar) == true &&
            Character.isLetter(lastChar) == true) {
                // move on to find first character of next word 
                firstChar += 1;
                // store the word of length n into space n in array
                counts[length] += 1;
                
            }
            
        }
        
        for (int k =0; k < counts.length; k++){
            System.out.println(counts[k] + "\t of length" + k);
        }
    }
    
    public void testCountWordLengths () {
       
        FileResource fr = new FileResource();
        
        int[] counts = new int[31];
    
        CountWordLengths(fr, counts);
        
    }
   
    public int indexOfMax ( int[] values ) {
        // cycle through array 
        int indexMax = 0;
        for (int k = 0; k < values.length; k++) {
            // highest value
            
            // if highest value is zero
            if ( indexMax == 0 ) {
                  indexMax = values[k];
            }
            else {
                if ( indexMax < values[k]){
                   indexMax = values[k]; 
            }
        
        }
        
        
    }
    return indexMax;
   }
}

public class LessonsFromWeek2 {
        
        public void DiceRoll () {
        
        Random rand = new Random();
       
        int[] num = new int[13];
        
        for ( int k =0; k < num.length; k++ ) {
           
            int d1 = rand.nextInt(6) + 1;
            
            int d2 = rand.nextInt(6) + 1;
            
            num[d1 + d2]  += 1;
        
        }
        
        for ( int k = 2; k <= 12; k++) {
            
            System.out.println( k + " 's t/ " + num[k]);
            
        
        }
        
        }
        
        public int indexOf ( String[] list, String word) {
            for (int k = 0; k < list.length; k++) {
                if (list[k].equals(word)){
                 return k;
            }
        
        }
        return -1;
        }
    
        
        
        public String[] getCommon() {
            
            FileResource resource = new FileResource("data/common.txt");
            
            String[] common = new String[20];
            
            int index = 0;
            
            for (String s : resource.words()){
                common[index] = s;
                index += 1;
            
            }
            
            return common;
       
        }
        
        public void countWords (FileResource resource, String[] common, int[] counts ) {
            for (String word : resource.words()){
                word = word.toLowerCase();
                int index = indexOf(common, word);
                if (index != -1) {
                    
                    counts[index] += 1;
                
                }
            }
        
        
        }
       
        public void textFingerPrint ()
        
        {
        
         
        } 
        
        public void countShakespeare () {
            //initialize an array that lists text files from Shakespeare's plays
            String[] plays = { "caesar.txt"};
            
            String[] common = getCommon();
            
            int[] counts = new int[common.length];
            
            for (int k = 0; k < plays.length; k++) {
                
                FileResource resource = new FileResource("data/" + plays[k]);
                
                countWords(resource, common, counts);
                
                System.out.println("done with" + plays[k]);
            
            }
            
            }
            
            
            }

