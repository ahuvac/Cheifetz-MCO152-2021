package cheifetz.scrabble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * creates an array of words
 */
public class Dictionary {

    private final Map<String,String> wordsToDefinitions = new HashMap<>();

    public Dictionary() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("dictionary.txt"));
        while(scan.hasNext()){
            wordsToDefinitions.put(
                    scan.next(), //key
                    scan.nextLine().trim()); //value
        }
        //Arrays.sort(dictArray);
    }

    public boolean hasWord(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDef(String word){
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

}


