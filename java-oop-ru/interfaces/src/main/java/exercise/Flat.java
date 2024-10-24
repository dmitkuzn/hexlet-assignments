package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }

    public double getArea() {
        return area + balconyArea;
    }

    public int compareTo(Home another){
        if (getArea() > another.getArea()) {
            return 1;

        } else if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }
}
// END
