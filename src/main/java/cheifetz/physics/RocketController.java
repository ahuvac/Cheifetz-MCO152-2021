package cheifetz.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class RocketController {
    @FXML
    public Button calculateButton;
    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Label locationLabel;
    @FXML
    RocketCanvas rocketCanvas;
    @FXML
    Label flightTime;


    public void calculateRocket(ActionEvent actionEvent) {

        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);

        String position = String.format("(%.2f, %.2f)",
                        rocket.getX(seconds),
                        rocket.getY(seconds));

        String time = rocket.timeToLand() + "";
        //System.out.println(rocket.timeToLand());

        locationLabel.setText(position);
        flightTime.setText(time);
        rocketCanvas.draw(rocket);

    }
}
