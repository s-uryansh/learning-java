/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author surya
 */
public class Lab3_Q1 {
     public static void main(String[] args) {
        Shape circle = new Circle(5.27);
        Shape rectangle = new Rectangle(5.27, 72.5);
        Shape triangle = new Triangle(5.27, 7.25, 2.57);

        System.out.println("Area of rectangle: " + rectangle.get_area());
        System.out.println("Area of triangle: " + triangle.get_area());
        System.out.println("Area of circle: " + circle.get_area());
    }
}

class Shape {
    public double get_area() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double get_area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
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

    @Override
    public double get_area() {
        return length * breadth;
    }
}

class Triangle extends Shape {
    private double a_side;
    private double b_side;
    private double c_side;

    public Triangle(double a_side, double b_side, double c_side) {
        this.a_side = a_side;
        this.b_side = b_side;
        this.c_side = c_side;
    }

    public double get_side_a() {
        return a_side;
    }

    public double get_side_b() {
        return b_side;
    }

    public double get_side_c() {
        return c_side;
    }

    public void set_side_a(double a_side) {
        this.a_side = a_side;
    }

    public void set_side_b(double b_side) {
        this.b_side = b_side;
    }

    public void set_side_c(double c_side) {
        this.c_side = c_side;
    }

    @Override
    public double get_area() {
        double s = (a_side + b_side + c_side) / 2;
        return Math.sqrt(s * (s - a_side) * (s - b_side) * (s - c_side));
    }
    
}
