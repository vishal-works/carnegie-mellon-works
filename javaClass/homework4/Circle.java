/**
 * Shape Array and Sort Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Circle extends Shape {
    /**
     * stores radius of circle.
     */
    private double radius;
    /**
     * Constructor for the Circle class.
     * @param newRadius stores the radius of the circle.
     */
    public Circle(double newRadius) {
        radius = newRadius;
    }
    /**
     * Get the radius of the circle.
     * @return radius of the circle.
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Implemented method to return area of circle.
     */
    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }
    /**
     * Implemented Method to return perimeter of the circle.
     */
    @Override
    public double getPerimeter() {
        return (Math.PI * 2 * radius);
    }
    /**
     * toString Method for Circle Class.
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
