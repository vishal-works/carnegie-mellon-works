/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Circle extends Shape {
    /**
     * stores radius of circle.
     */
    private double radius;
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius, Math.PI * 2 * newRadius);
        radius = newRadius;
    }
    /**
     * Get the radius of the circle.
     * @return radius of the circle.
     */
    public double getRadius() {
        return radius;
    }
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
