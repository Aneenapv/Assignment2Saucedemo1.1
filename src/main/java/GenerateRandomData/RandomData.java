package GenerateRandomData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

	public static void main(String[] args) {
		Random random = new Random();
		
		
		String[] firstnames = {"aneena","akhil","john","jofna"};
		String[] lastnames = {"vincent","george","johnson","thomas"};
		String firstname = firstnames[random.nextInt(firstnames.length)];
		String lastname = lastnames[random.nextInt(lastnames.length)];
		System.out.println("full name = "+firstname+" " +lastname);
		
		
		List<String> fName = Arrays.asList("Jim", "Fred", "Baz", "Bing");
	    Collections.shuffle(fName);
		List<String> lName = Arrays.asList("Duck", "Swan", "Cooper", "Bing");
		Collections.shuffle(lName);
		System.out.println("fullname = " +fName + lName);
		
		
		int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        for(int x=1;x<=3;x++)
        { 
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString);
        }
        
        
      
	}  
            
}   

