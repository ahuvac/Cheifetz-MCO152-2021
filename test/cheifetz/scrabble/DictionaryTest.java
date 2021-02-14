package cheifetz.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryTest {

    @Test
    public void hasWord() throws FileNotFoundException {
        Dictionary dict = new Dictionary("/Users/ahuvacheifetz/Downloads/dictionary.txt");
        Assert.assertTrue(dict.hasWord("OCCIDENTALIZING"));
        Assert.assertTrue(dict.hasWord("KARN"));
        Assert.assertTrue(dict.hasWord("apron"));
        Assert.assertFalse(dict.hasWord("Ahuva"));
    }

}
