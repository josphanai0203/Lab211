package controller;

import model.Circle;
import model.Rectangle;
import model.Triangle;
import service.CaculatorService;
import util.Library;

public class CaculatorController {

    protected Library library;
    protected CaculatorService service;

    public CaculatorController() {
        library = new Library();
        service = new CaculatorService();
    }

    public void run() {
        enterInput();
    }

    public void enterInput() {
        Triangle triangle = enterTriangle();
        Rectangle rectangle = enterRectangle();
        Circle circle = enterCircle();
        service.displayAll(triangle, rectangle, circle);

    }
    public Triangle enterTriangle(){
        while (true) {
            double a = library.getDouble("Please input side A of Triangle");
            double b = library.getDouble("Please input side B of Triangle");
            double c = library.getDouble("Please input side C of Triangle");
            if (a + b > c && b + c > a && a + c > b) {
                return service.createTrianle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }
    public Rectangle enterRectangle(){
        double width = library.getDouble("Please input side width of Rectangle");
        double length = library.getDouble("Please input length of Rectangle");
        return new Rectangle(width, length);
    }
    public Circle enterCircle(){
        double radius = library.getDouble("Please input radius of Circle");
        return new Circle(radius);
    }
}
