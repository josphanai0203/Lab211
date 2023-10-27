package service;

import model.Circle;
import model.Rectangle;
import model.Triangle;

public class CaculatorService {
    public Triangle  createTrianle(double a, double b, double c){
        return new Triangle(a, b, c);
    }
    public Rectangle createRectangle(double width, double length){
        return  new Rectangle(width, length);
    }
    public Circle createCircle(double radius){
        return new Circle(radius);
    }
    public void displayAll(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
