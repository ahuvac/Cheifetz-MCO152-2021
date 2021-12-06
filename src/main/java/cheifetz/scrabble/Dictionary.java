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
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            int index = line.indexOf(" ");
            String word = index == -1 ? line : line.substring(0, index);
            String definition = index > -1 ? line.substring(index + 1) : null;
            wordsToDefinitions.put(
                    word, //key
                    definition); //value
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


