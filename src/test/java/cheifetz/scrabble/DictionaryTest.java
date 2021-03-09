package cheifetz.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DictionaryTest {


    @Test
    public void hasWord_true() throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        Assert.assertTrue(dict.hasWord("VAGRANCY"));
    }

    @Test
    public void hasWord_lowercase_true() throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        Assert.assertTrue(dict.hasWord("cat"));
    }

    @Test
    public void hasWord_false() throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        Assert.assertFalse(dict.hasWord("Ahuva"));
    }
    @Test
    public void getDef() throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        Assert.assertEquals("pertaining to agriculture [adj]",dict.getDef("AG"));
    }
    @Test
    public void getDef_nonexistant() throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        Assert.assertEquals(dict.getDef("Ahuva"), "");
    }

}
