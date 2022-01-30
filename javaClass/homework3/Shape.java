/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Shape {
    /**
     * variable storing area.
     */
    private double area;
    /**
     * variable syoting perimeter.
     */
    private double perimeter;
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }
    /**
     * Method to get Area.
     * @return area of the given shape.
     */
    public double getArea() {
        return area;
    }
    /**
     * Method to get Perimeter.
     * @return perimeter of the given shape.
     */
    public double getPerimeter() {
        return perimeter;
    }
    @Override
    public String toString() {
        return "Shape " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
    public static void main(String[] args) {
        Shape s = new Shape(60.4545, 2.6654433);
        System.out.println(s);
    }
}
