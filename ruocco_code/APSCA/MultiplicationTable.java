
public class MultiplicationTable {
	
 
	public static void main(String[] args) {
	
		System.out.print("\t");
		for (int k = 1; k <= 10; k++)
	         System.out.print(k + " \t");
	      System.out.println();
	     
	      System.out.print("\t");
	      for (int k = 1; k <= 10; k++)
		         System.out.print("-- \t");
		      System.out.println();

	   for(int i= 1; i <= 10; i++){
		   
		         System.out.print(i + "| \t");
		   
		   
		   for(int j = 1; j <= 10; j++) {
			      System.out.print(i * j + "\t");
			      
			    }  
		   System.out.println();
	      }    
	   
	   String hello = "hello";
	   char last = hello.charAt(10);
	   
	}
	
}