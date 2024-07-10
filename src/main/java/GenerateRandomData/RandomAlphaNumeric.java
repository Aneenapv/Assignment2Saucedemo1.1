package GenerateRandomData;

import java.util.Random;

public class RandomAlphaNumeric{

    // Characters that can be included in the alphanumeric string
    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

    
    public static void main(String[] args) {
        int length = 6; 
        String randomString = generateRandomAlphanumeric(length);
        System.out.println("Random Alphanumeric String: " + randomString);
    }

 
    public static String generateRandomAlphanumeric(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
            stringBuilder.append(ALPHANUMERIC_CHARACTERS.charAt(index));
        }

        return stringBuilder.toString();
    }
}

