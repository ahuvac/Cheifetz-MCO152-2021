package cheifetz.scrabble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * creates an array of words
 */
public class Dictionary {

    private final String[] dictArray;

    public Dictionary(String path) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(path));
        ArrayList<String> dict = new ArrayList<>();

        while(scan.hasNextLine()){
            dict.add(scan.nextLine().split(" ")[0].toUpperCase());
        }

        dictArray = dict.toArray(new String[0]);
        Arrays.sort(dictArray);
    }

    public boolean hasWord(String check) {
        return Arrays.binarySearch(dictArray, check.toUpperCase()) >= 0;
    }

}


