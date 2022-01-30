/**
 * Shape Array and Sort Homework.
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
    /***
     * Constructor for Rectangle Class.
     * @param newWidth has the new width.
     * @param newHeight has the height.
     */
    public Rectangle(double newWidth, double newHeight) {
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
    /**
     * Implementation of method to get area.
     * @return Returns the area.
     */
    @Override
    public double getArea() {
        return (height * width);
    }
    /**
     * Implementation of method to get perimeter.
     * @return Returns the perimeter.
     */
    @Override
    public double getPerimeter() {
        return (2 * (height + width));
    }
    /**
     * toString method of rectangle class.
     * @return returns the string.
     */
    @Override
    public String toString() {
        return "Rectangle " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
