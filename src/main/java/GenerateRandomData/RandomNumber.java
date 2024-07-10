package GenerateRandomData;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {


		        // create instance of Random class
		        Random random = new Random();
		   
		        // Generate random integers in range 0 to 999
		        int random1= random.nextInt(1000);
		        int random2 = random.nextInt(1000);
		   
		        // Print random integers
		       System.out.println("Random Integers: "+random1);
		       System.out.println("Random Integers: "+random2);
		   
		        // Generate Random doubles
		        double rand_dub1 = random.nextDouble(100);
		        double rand_dub2 = random.nextDouble(100);
		   
		        // Print random doubles
		        System.out.println("Random Doubles: "+rand_dub1);
		        System.out.println("Random Doubles: "+rand_dub2);
		        
		        
		        System.out.println("using math function= "+ Math.random());
		        
		        
		        
		        int min=50;
		        int max=100;
		        
		        System.out.println(random.nextInt(max-min+1)+min);
		        
		        
		        

		    }
		        
		        
		    }
		


