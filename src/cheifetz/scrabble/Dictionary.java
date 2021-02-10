package cheifetz.scrabble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    ArrayList<String> words = new ArrayList<>();

    public Dictionary(String path) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(path));
        while(scan.hasNextLine()){
            String[] line = scan.nextLine().split(" ");
            words.add(line[0]);
        }

    }

    public boolean hasWord(String check) {
        boolean retVal = false;
        for (String word : words) {
            if (word.equalsIgnoreCase(check)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

}


