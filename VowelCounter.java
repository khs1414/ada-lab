import java.util.Scanner;

public class VowelCounter {
    static void countVowels(String str) {
        int count_a = 0;
        int count_e = 0;
        int count_i = 0;
        int count_o = 0;
        int count_u = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'A') {
                count_a++;
            }
            if (ch == 'e' || ch == 'E') {
                count_e++;
            }
            if (ch == 'i' || ch == 'I') {
                count_i++;
            }
            if (ch == 'o' ||ch == 'O' ) {
                count_o++;
            }
            if (ch == 'u' || ch == 'U') {
                count_u++;
            }
        }
        if(count_a>0){
            System.out.println("count a : "+ count_a);
        }
        if(count_e>0){
            System.out.println("count a : "+ count_e);
        }
        if(count_i>0){
            System.out.println("count a : "+ count_i);
        }
        if(count_o>0){
            System.out.println("count a : "+ count_o);
        }
        if(count_u>0){
            System.out.println("count a : "+ count_u);
        }

      
    }

    public static void main(String[] args) {
        String s;
        System.out.println("Enter a String : ");
        Scanner inp = new Scanner(System.in);
        s = inp.next();
        countVowels(s);
    }
}
