package cheifetz.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryTest {


    @Test
    public void hasWord_true() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertTrue(dict.hasWord("VAGRANCY"));
    }

    @Test
    public void hasWord_lowercase_true() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertTrue(dict.hasWord("cat"));
    }

    @Test
    public void hasWord_false() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.hasWord("Ahuva"));
    }
    @Test
    public void getDef() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertEquals("pertaining to agriculture [adj]",dict.getDef("AG"));
    }
    @Test
    public void getDef_nonexistant() throws IOException {
        Dictionary dict = new Dictionary();
        Assert.assertEquals(dict.getDef("Ahuva"), "");
    }

}
