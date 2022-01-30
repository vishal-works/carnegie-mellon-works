/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Square extends Rectangle {
    /**
     * stores side of square.
     */
    private double side;
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }
    /**
     * Method to get side of square.
     * @return side of the square.
     */
    public double getSide() {
        return side;
    }
    @Override
    public String toString() {
        return "Square " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
