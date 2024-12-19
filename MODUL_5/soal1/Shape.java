package soal1;

public abstract class Shape {
    protected String shapeName;

    public Shape(String name) {
        shapeName = name;
    }

    public abstract double area();

    @Override
    public String toString() {
        return "Shape: " + shapeName;
    }
}

class Sphere extends Shape {
    private double radius;

    public Sphere(double r) {
        super("Sphere");
        radius = r;
    }

    @Override
    public double area() {
        return 4 * Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + " of radius " + radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double l, double w) {
        super("Rectangle");
        length = l;
        width = w;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}

class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius) * height;
    }

    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}

class Main {
    public static void main(String[] args) {
        Shape sphere = new Sphere(6);
        Shape rectangle = new Rectangle(8, 10);
        Shape cylinder = new Cylinder(5, 90);

        System.out.println(sphere);
        System.out.println("Area: " + sphere.area() + " square units\n");

        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.area() + " square units\n");

        System.out.println(cylinder);
        System.out.println("Area: " + cylinder.area() + " square units\n");
    }
}
