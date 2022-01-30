/**
 * Shape Sort and Array Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Octagon extends Shape {
    /**
     * stores the side of the octagon.
     */
    private double side;
    /**
     * Constructor for the Octagon Class.
     * @param newSide Side of the Octagon.
     */
    public Octagon(double newSide) {
        side = newSide;
    }
    /**
     * return the side of the octagon.
     * @return side of the octagon.
     */
    public double getSide() {
        return side;
    }
    /**
     * Implemented method to return area.
     */
    @Override
    public double getArea() {
        return (2 * (1 + Math.sqrt(2)) * side * side);
    }
    /**
     * Implemented method to return  perimeter.
     */
    @Override
    public double getPerimeter() {
        return (8 * side);
    }
    /**
     * toString Method of Octagon Class.
     * @return Returns the string.
     */
    @Override
    public String toString() {
        return "Octagon " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
