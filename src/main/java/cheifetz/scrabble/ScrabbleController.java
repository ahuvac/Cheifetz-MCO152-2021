package cheifetz.scrabble;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController {
    @FXML
    Label pointsLabel;
    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;

    private int count;
    private final LetterBag letterBag = new LetterBag();
    private Dictionary dictionary;
    private int numPoints = 0;


    public ScrabbleController() {
        try {
            dictionary = new Dictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onAnswerClicked(MouseEvent event) {
        Label label = (Label) event.getSource();
        //only allowed to put back if its the last label
        if (answerLabels.indexOf(label) == count - 1) {
            putLetterBack(label);
            clearLabel(label);
            count--;
        }
    }

    public void onLetterClicked(MouseEvent event) {
        Label srcLabel = (Label) event.getSource();
        Label nextAnswerLabel = answerLabels.get(count);
        nextAnswerLabel.setText(srcLabel.getText());
        whitetoBlack(nextAnswerLabel);
        clearLabel(srcLabel);
        count++;
    }

    public void onSubmit(ActionEvent actionEvent) {
        StringBuilder word = new StringBuilder();
        for (Label label : answerLabels) {
            if (label.getText().equals("  ")) break;
            word.append(label.getText());
        }
        if (dictionary.hasWord(word.toString())) {
            numPoints += score(word.toString());
            pointsLabel.setText(numPoints + "");
            fillEmptyTiles();
            clearAnswers();
        } else {
            showAlert("error", "Word not found.", "Sorry, no such word exists.");
            for (Label ansLabel : answerLabels) {
                if (!ansLabel.getText().equals("  ")) {
                    putLetterBack(ansLabel);
                } else {
                    break;
                }
            }
        }
        count = 0;
    }

    public void onClear(ActionEvent actionEvent) {
        clearAnswers();
    }

    public void onScramble(ActionEvent actionEvent) {
        clearAnswers();
        initialize();
    }


    //////////////////
    //HELPER METHODS//
    //////////////////


    public void initialize() {
        for (Label label : letterLabels) {
            if (!letterBag.isEmpty()) {
                label.setText(letterBag.nextLetter() + "");
            }
        }
    }

    public int score(String word) {
        switch (word.length()) {
            case 3:
                return 3;
            case 4:
                return 5;
            case 5:
                return 7;
            case 6:
                return 11;
            case 7:
                return 13;
            default:
                return 1;
        }
    }

    public void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void fillEmptyTiles() {
        for (Label label : letterLabels) {
            if (label.getText().equals("  ")) {
                whitetoBlack(label);
                if (letterBag.isEmpty()) {
                    showAlert("Game Over", "Game Over", "You used up all the tiles. Final Score: " + numPoints);

                } else {
                    label.setText(letterBag.nextLetter() + "");
                }
            }
        }
    }

    private void putLetterBack(Label ansLabel) {
        for (Label letLabel : letterLabels) {
            if (letLabel.getText().equals("  ")) {
                letLabel.setText(ansLabel.getText());
                whitetoBlack(letLabel);
                clearLabel(ansLabel);
                break;

            }
        }
    }

    private void clearAnswers() {
        count = 0;
        for (Label ansLabel : answerLabels) {
            if (!ansLabel.getText().equals("  ")) {
                putLetterBack(ansLabel);
            } else {
                break;
            }
        }
        for (Label label : answerLabels) {
            clearLabel(label);
        }
    }

    private void clearLabel(Label label) {
        blacktoWhite(label);
        label.setText("  ");
    }

    private void blacktoWhite(Label label) {
        label.setStyle("-fx-background-color: white;");
    }

    private void whitetoBlack(Label label) {
        label.setStyle("-fx-background-color: black; -fx-text-fill: white;");
    }

}
