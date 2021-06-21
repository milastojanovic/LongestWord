import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        String sen = "fun&!! time"; // result: time
        String sen = "I love dogs"; // love
//        String sen = "   !!!^&*fun&!!lagj           \n yui(()! (*%jgfla time";

        String theLongestWord = longestWord(sen);
        System.out.println(theLongestWord);
    }

    public static String longestWord(String sen) {
        // exercise: assume sen will not be empty

        String theLongestWord = "";
        Map<Integer, String> firstWordsOfTheSpecificLength = new HashMap<>();

        sen = sen
                .replaceAll("\\t+", " ")
                .replaceAll("\\n+", " ")
                .replaceAll("\\p{Punct}", " ")
                .trim()
                .replaceAll("\\s+", " ");

        String[] words = sen.split(" ");

        for (String word : words) {
            int length = word.length();
            if (!firstWordsOfTheSpecificLength.containsKey(length)) {
                firstWordsOfTheSpecificLength.put(length, word);
            }
        }

        // get the longest word
        Set<Integer> lengths = firstWordsOfTheSpecificLength.keySet();
        int maxLength = 0;
        for (Integer l : lengths) {
            if (l > maxLength) {
                maxLength = l;
            }
        }
        theLongestWord = firstWordsOfTheSpecificLength.get(maxLength);

        return theLongestWord;
    }
}
