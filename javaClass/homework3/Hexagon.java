/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Hexagon extends Shape {
    /**
     * stores the side of the hexagon.
     */
    private double side;
    public Hexagon(double newSide) {
        super(3 * Math.sqrt(3) / 2 * newSide * newSide, 6 * newSide);
        side = newSide;
    }
    /**
     * get side of the hexagon.
     * @return the side of the hexagon.
     */
    public double getSide() {
        return side;
    }
    @Override
    public String toString() {
        return "Hexagon " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
