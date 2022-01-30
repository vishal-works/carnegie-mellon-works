/**
 * Shape Instantiation Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class Rectangle extends Shape {
    /**
     * variable storing width.
     */
    private double width;
    /**
     * variable storing height.
     */
    private double height;
    public Rectangle(double newWidth, double newHeight) {
        super(newWidth * newHeight, 2 * (newWidth + newHeight));
        width = newWidth;
        height = newHeight;
    }
    /**
     * Method to get width of the rectangle.
     * @return width of the rectangle.
     */
    public double getWidth() {
        return width;
    }
    /**
     * Method to return the height of the rectangle.
     * @return height of the rectangle.
     */
    public double getHeight() {
        return height;
    }
    @Override
    public String toString() {
        return "Rectangle " + String.format("%.3f", super.getArea()) + " " + String.format("%.3f", super.getPerimeter());
    }
}
