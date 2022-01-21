package Shapes;

public class Main {
    public static void main(String[] args) {

        Shape shape =  new Rectangle(13D,2D);
        Shape shape2 =  new Circle(3D);

        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());

        System.out.println(shape2.getArea());
        System.out.println(shape2.getPerimeter());








    }
}
