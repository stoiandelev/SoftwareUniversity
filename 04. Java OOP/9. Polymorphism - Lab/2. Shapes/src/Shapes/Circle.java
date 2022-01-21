package Shapes;

public class Circle extends Shape {

    private  Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }


    @Override
    protected void calculatePerimeter() {
        Double result = 2 * Math.PI * radius;
        setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        Double result = Math.PI * radius * radius;
        setArea(result);
    }

    public final Double getRadius() {
        return radius;
    }
}
