
public class Rocket {
    private final double velocity;
    private final double angle;
    final double GRAVITY = 9.8;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    /**
     ** @param time - double - seconds the rocket has been flying
     ** @return - double - the x coordinate of the rocket
     */
    public double getX(double time) {
        double xVelocity = Math.cos(Math.toRadians(angle)) * velocity;
        return xVelocity * time;
    }

    /**
     ** @param time - double - seconds the rocket has been flying
     ** @return - double - the y coordinate of the rocket
     */
    public double getY(double time) {
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        return yVelocity * time - 0.5 * GRAVITY * time * time;
    }
    /**
     ** @return - double - the time the rocket takes until it lands back on earth
     */
    public double timeToLand() {
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        return yVelocity / (0.5 * GRAVITY) ;
    }
}

