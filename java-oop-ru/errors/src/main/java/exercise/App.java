package exercise;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Hi!!!");

        Point point = new Point(3, 4);
        Circle circle = new Circle(point, 1);
        printSquare(circle);

    }

    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Вычисление окончено");
    }
}
// END
