package cheifetz.scrabble;
import java.io.*;
import java.util.*;
/**
 * creates an array of words
 */
public class Dictionary {

    private final Map<String,String> wordsToDefinitions = new HashMap<>();

    public Dictionary() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        Scanner scanner = new Scanner(new InputStreamReader(in));

        while(scanner.hasNext()){
            wordsToDefinitions.put(
                    scanner.next(), //key
                    scanner.nextLine().trim()); //value
        }
    }

    public boolean hasWord(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDef(String word){
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

}


