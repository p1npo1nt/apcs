
import java.io.*;

public class piglatin {
    public static void main(String[] args) {
        int i = 0;
        String sentence = "";
        while (i < args.length) {
            sentence = sentence + pigify(args[i]) + " ";
            i+=1;
        }
        System.out.println(sentence);
            
    }


    // Turns a word into its pig latin equivalent
    public static String pigify(String input) {
        int i = 0;
        while(i < input.length()) {

            // For first letter vowel-case
            if(isVowel(input.charAt(0))){
                input = input.substring(i, input.length())  + "way";
                i = input.length();
            }

            // General case
            if (isVowel(input.charAt(i))) {
                input = input.substring(i, input.length()) + input.substring(0,i) + "ay";
                i = input.length();
            }

            else {
                i+=1;
            }
        }

        return input;
    }

    public static boolean isVowel(char letter) {
        String vowels = "aeiouAEIOU";
        if(vowels.indexOf(letter) == -1) {
            return false;
        }
        else{
            return true;
        }
        
    }
}

