/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Octagon extends Shape {
    /**
     * stores the side of the octagon.
     */
    private double side;
    public Octagon(double newSide) {
        super(2 * (1 + Math.sqrt(2)) * newSide * newSide, 8 * newSide);
        side = newSide;
    }
    /**
     * return the side of the octagon.
     * @return side of the octagon.
     */
    public double getSide() {
        return side;
    }
    @Override
    public String toString() {
        return "Octagon " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
