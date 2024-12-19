package soal1;

public class Paint {
    private double coverage;

    public Paint(double c) {
        coverage = c;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}

class PaintTest {
    public static void main(String[] args) {
        Paint paint = new Paint(500);

        Shape sphere = new Sphere(6);
        Shape rectangle = new Rectangle(8, 10);
        Shape cylinder = new Cylinder(5, 90);

        System.out.printf("Paint that are needed for %s is this much %.2f gallons%n", sphere, paint.amount(sphere));
        System.out.printf("Paint that are needed for %s is this much %.2f gallons%n", rectangle, paint.amount(rectangle));
        System.out.printf("Paint that are needed for %s is this much %.2f gallons%n", cylinder, paint.amount(cylinder));
    }
}
