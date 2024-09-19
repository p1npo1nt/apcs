// Vasudevn Govardhanen
// Pigify
// 16sep24

public class piglatin {
    public static void main(String[] args) {
       
        int i = 0;
        String sentence = "";
        while (i < args.length) {
            if(!doNotPigify(args[i])) {
                sentence = sentence + pigify(args[i]) + " ";
            }
            else {
                sentence = sentence + args[i] + " ";
            }
            i+=1;
        }
        System.out.println(sentence);
            
    }


    // Turns a word into its pig latin equivalent
    public static String pigify(String input) {
        
        // For first letter vowel-case
        if(isVowel(input.charAt(0))){
            input = input.substring(0, input.length())  + "way";
        }

        int i = 1;
        while(i < input.length()) {
            // General case, pigifies individual word
            if (isVowelY(input.charAt(i))) {
                input = input.substring(i, input.length()) + input.substring(0,i) + "ay";
                break;
            }
            
            // iterates to next letter if current letter is not a vowel
            else {
                i+=1;
            }
        }

        return input;
    }

    public static boolean isVowel(char letter) {
        return "aeiouAEIOU".indexOf(letter) != -1;
    }

    // includes 'y' as a vowel, used if 'y' is not the first letter of the word, i.e. acts as a vowel
    public static boolean isVowelY(char letter) {
        return "aeiouyAEIOUY".indexOf(letter) != -1;
    }


    // do not pigify certain words such as articles
    public static boolean doNotPigify(String word) {
        String [] w = {"the", "a", "in", "an", "of", "I", "be", "is", "or", "not", "and", "up", "not", "are", "am"};
        int i = 0; 
        while(i < w.length) {
            if(word.equals(w[i]) || word.toLowerCase().equals(w[i])) {
                return true;
            }
            i+=1;
        }

        return false;

        
    }
}

