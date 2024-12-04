/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author surya
 */
public class Lab3_Q3 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4, 5);
        shapes[3] = new Sphere(5);
        shapes[4] = new Cube(3);
        shapes[5] = new Tetrahedron(4);

        for (Shape shape : shapes) {
            if (shape instanceof TwoDimensionalShape) {
                System.out.println("This is a Two-Dimensional Shape.");

                if (shape instanceof Circle) {
                    System.out.println("This is a Circle Shape.");
                }

                if (shape instanceof Rectangle) {
                    System.out.println("This is a Rectangle Shape.");
                }

                if (shape instanceof Triangle) {
                    System.out.println("This is a Triangle Shape.");
                }

                System.out.println("Area: " + shape.get_area());

            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.println("This is a Three-Dimensional Shape.");

                if (shape instanceof Cube) {
                    System.out.println("This is a Cube Shape.");
                }

                if (shape instanceof Tetrahedron) {
                    System.out.println("This is a Tetrahedron Shape.");
                }

                if (shape instanceof Sphere) {
                    System.out.println("This is a Sphere Shape.");
                }

                System.out.println("Area: " + shape.get_area());
                System.out.println("Volume: " + shape.get_vol());
            }
        }
    }
}

class Shape{
    //parent class
    double get_area(){
        return 0;
    }

    double get_vol(){
        return 0;
    }
}

class TwoDimensionalShape extends Shape{
    double get_area(){
        
        return 0;
    }
}

class Circle extends TwoDimensionalShape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double get_radius() {
        return radius;
    }

    public void set_radius(double radius) {
        this.radius = radius;
    }

    public double get_area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends TwoDimensionalShape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double get_len() {
        return length;
    }

    public double get_breadth() {
        return breadth;
    }

    public void set_len(double length) {
        this.length = length;
    }

    public void set_breadth(double breadth) {
        this.breadth = breadth;
    }

    public double get_area() {
        return length * breadth;
    }
}

class Triangle extends TwoDimensionalShape {
    private double sideA;
    private double b_side;
    private double c_side;

    public Triangle(double a_side, double b_side, double c_side) {
        this.sideA = sideA;
        this.b_side = b_side;
        this.c_side = c_side;
    }

    public double get_side_a() {
        return sideA;
    }

    public double get_side_b() {
        return b_side;
    }

    public double get_side_c() {
        return c_side;
    }

    public void set_side_a(double sideA) {
        this.sideA = sideA;
    }

    public void set_side_b(double b_side) {
        this.b_side = b_side;
    }

    public void set_side_c(double c_side) {
        this.c_side = c_side;
    }

    public double get_area() {
        double s = (sideA + b_side + c_side) / 2;
        return Math.sqrt(s * (s - sideA) * (s - b_side) * (s - c_side));
    }
}

class ThreeDimensionalShape extends Shape{
    double get_vol() {
        return 0;
    }
}

class Sphere extends ThreeDimensionalShape{
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double get_radius() {
        return radius;
    }

    public void set_radius(double radius) {
        this.radius = radius;
    }

    public double get_area() {
        return 4 * Math.PI * radius * radius;
    }

    public double get_vol() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double get_side() {
        return side;
    }

    public void set_side(double side) {
        this.side = side;
    }

    @Override
    public double get_area() {
        // Surface area of a cube: 6 * side^2
        return 6 * side * side;
    }

    public double get_vol() {
        // Volume of a cube: side^3
        return Math.pow(side, 3);
    }
}

class Tetrahedron extends ThreeDimensionalShape {
    private double side;

    public Tetrahedron(double side) {
        this.side = side;
    }

    public double get_side() {
        return side;
    }

    public void set_side(double side) {
        this.side = side;
    }

    public double get_area() {
        return Math.sqrt(3) * side * side;
    }

    public double get_vol() {
        return Math.pow(side, 3) / (6 * Math.sqrt(2));
    }
}
