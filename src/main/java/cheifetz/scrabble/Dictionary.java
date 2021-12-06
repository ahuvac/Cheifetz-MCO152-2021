package cheifetz.scrabble;
import java.io.*;
import java.util.*;
/**
 * creates an array of words
 */
public class Dictionary {

    private final Map<String,String> wordsToDefinitions = new HashMap<>();

    public Dictionary() throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] pairs = line.split(" ", 2);
            wordsToDefinitions.put(
                    pairs[0], //key
                    pairs[1].trim()); //value
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


