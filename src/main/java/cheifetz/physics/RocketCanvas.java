package cheifetz.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * draws the rocket to the screen
 */
public class RocketCanvas extends Canvas {

    /**
     * draws the path of the rocket, starting from time=0 to the rockets flight time.
     * @param rocket
     */
    public void draw(Rocket rocket)
    {
        GraphicsContext context = getGraphicsContext2D();
        context.setFill(Color.LAVENDERBLUSH);
        context.fillRect(0,0, getWidth(), getHeight());
        context.setFill(Color.CORAL);
        context.translate(0, getHeight());
        context.beginPath();
        for(double sec = 0; sec <= rocket.timeToLand(); sec += 0.5){
            context.fillOval(rocket.getX(sec), -rocket.getY(sec),  5 ,5);
            context.setLineWidth(.5);
            context.lineTo(rocket.getX(sec),-rocket.getY(sec));
        }
        context.stroke();
        context.translate(0, -getHeight());
    }

}
