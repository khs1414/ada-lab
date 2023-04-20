import java.util.Random;
import java.util.Scanner;

public class shuffle {
    static String shuffleString(String str) {
        char[] characters = str.toCharArray();
        Random random = new Random();

        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String s;
        System.out.println("Enter a String : ");
        Scanner inp = new Scanner(System.in);
        s = inp.next();
        System.out.println("Shuffled string: " + shuffleString(s));
    }
}
