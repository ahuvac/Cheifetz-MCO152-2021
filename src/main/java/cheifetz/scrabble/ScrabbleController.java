package cheifetz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController {
    @FXML
    Button submit;
    @FXML
    Button clear;
    @FXML
    Button points;

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;

    private LetterBag letterBag = new LetterBag();
    private Dictionary dictionary;

    public ScrabbleController() {
        try {
            dictionary = new Dictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        for (Label label : letterLabels) {
            label.setText(letterBag.nextLetter() + "");
        }
    }

    public void onAnswerClicked(MouseEvent event) {
        Label label = (Label) event.getSource();
    }

    public void onLetterClicked(MouseEvent mouseEvent) {
    }

    public void onSubmit(ActionEvent actionEvent) {
    }

    public void onClear(ActionEvent actionEvent) {
    }
}
