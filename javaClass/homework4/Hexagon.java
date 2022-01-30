/**
 * Shape Array and Sort Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Hexagon extends Shape {
    /**
     * stores the side of the hexagon.
     */
    private double side;
    /**
     * constructor for the hexagon Class.
     * @param newSide Side of the Octagon.
     */
    public Hexagon(double newSide) {
        side = newSide;
    }
    /**
     * get side of the hexagon.
     * @return the side of the hexagon.
     */
    public double getSide() {
        return side;
    }
    /**
     * Implemetned method to return area.
     * @return Returns the area.
     */
    @Override
    public double getArea() {
        return (3 * Math.sqrt(3) / 2 * side * side);
    }
    /**
     * Implemented method to return perimeter.
     * @return Returns the perimeter.
     */
    @Override
    public double getPerimeter() {
        return (6 * side);
    }
    /**
     * toString method for Hexagon Class.
     * @return Returns the string.
     */
    @Override
    public String toString() {
        return "Hexagon " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
