package cheifetz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class ScrabbleController {
    @FXML
    public Button submit;
    @FXML
    TextField clear;
    @FXML
    TextField num_points;

    public void checkWord(ActionEvent event) throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");

    }
    public void clear(ActionEvent actionEvent){
        System.out.println("hi");
    }
    public void getPoints(ActionEvent actionEvent){
        System.out.println("hi");
    }
}
