package cheifetz.scrabble;

import cheifetz.physics.Rocket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class DictionaryController {
    @FXML
    public Button findButton;
    @FXML
    TextField wordField;
    @FXML
    TextField resultField;

    public void check(ActionEvent actionEvent) throws FileNotFoundException {
        String word = wordField.getText();

        Dictionary dictionary = new Dictionary("/Users/ahuvacheifetz/Downloads/dictionary.txt");
        String result = dictionary.hasWord(word)+"";
        resultField.setText(result);

    }


}
