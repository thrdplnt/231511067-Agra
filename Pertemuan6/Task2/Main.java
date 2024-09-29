package Pertemuan6.Task2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Shape class:");
        Shape s1 = new Shape();
        System.out.println(s1);
        Shape s2 = new Shape("red", false);
        System.out.println(s2);

        System.out.println("\nTesting Circle class:");
        Circle c1 = new Circle();
        System.out.println(c1);
        Circle c2 = new Circle(2.0);
        System.out.println(c2);
        Circle c3 = new Circle(3.0, "blue", false);
        System.out.println(c3);
        System.out.println("Area of c3: " + c3.getArea());
        System.out.println("Perimeter of c3: " + c3.getPerimeter());

        System.out.println("\nTesting Rectangle class:");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        Rectangle r2 = new Rectangle(2.0, 3.0);
        System.out.println(r2);
        Rectangle r3 = new Rectangle(4.0, 5.0, "orange", true);
        System.out.println(r3);
        System.out.println("Area of r3: " + r3.getArea());
        System.out.println("Perimeter of r3: " + r3.getPerimeter());

        System.out.println("\nTesting Square class:");
        Square sq1 = new Square();
        System.out.println(sq1);
        Square sq2 = new Square(2.5);
        System.out.println(sq2);
        Square sq3 = new Square(3.5, "yellow", true);
        System.out.println(sq3);
        System.out.println("Area of sq3: " + sq3.getArea());
        System.out.println("Perimeter of sq3: " + sq3.getPerimeter());

        sq3.setSide(4.0);
        System.out.println("\nAfter changing side of sq3:");
        System.out.println(sq3);
        sq3.setWidth(5.0);
        System.out.println("After setting width of sq3:");
        System.out.println(sq3);
    }
}
