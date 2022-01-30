/**
 * Shape Array and Sort Homework.
 * @author : Vishal Vaidhyanathan.
 * AndrewID : vvaidhya@andrew.cmu.edu
 */
public class ShapeSortTest {
    /**
     * Main Method.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        /**
         * Variable to calcuate length of args.
         */
        int argsLength = args.length;
        /**
         * Shape array to store references to input shapes.
         */
        Shape[] shapes = new Shape[argsLength];
        /**
         * Index counter to store references in array.
         */
        int count = -1;
        /**
         * Loop to store references of input shapes.
         */
        for (String s : args) {
            count = count + 1; //increasing count to get correct index.
            char firstLetter = s.charAt(0);
            double size = Double.parseDouble(s.substring(1));
            switch (firstLetter) {
                case 'C':
                    shapes[count] = new Circle(size);
                    break;
                case 'S':
                    shapes[count] = new Square(size);
                    break;
                case 'H':
                    shapes[count] = new Hexagon(size);
                    break;
                case 'O':
                    shapes[count] = new Octagon(size);
                    break;
                default :
                    System.out.print("Unrecognised");
            }
        }
        /**
         * Sorting of areas in ascending and printing.
         */
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (shapes[i].getArea() > shapes[j].getArea()) {
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            System.out.println(shapes[i]);
        }
        /**
         * Adding a blank line for readabilty.
         */
        System.out.println("");
        /**
         * Sorting of Perimeter in descending order and  printing.
         */
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (shapes[i].getPerimeter() < shapes[j].getPerimeter()) {
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
            System.out.println(shapes[i]);
        }
    }
}
