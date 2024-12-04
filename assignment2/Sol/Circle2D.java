/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;
//import java.util.Scanner;
/**
 *
 * @author surya
 */
public class Circle2D {
  double x;
  double y;
  double r;
  
  public static void main(String[] args){
    Circle2D c1 = new Circle2D(2, 2, 5.5);

    System.out.println("Area: " + c1.circle_area());
    System.out.println("Perimeter: " + c1.circle_parameter());

    System.out.println("Contains (3, 3): " + c1.contains(3, 3));
    System.out.println("Contains circle (4, 5, 10.5): " + c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println("Overlaps with circle (3, 5, 2.3): " + c1.overlaps(new Circle2D(3, 5, 2.3)));
  
  }
  
  //=============================================================//
                     //FOR USER INPUT//
  //=============================================================//
  
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.println("x : "); //x for the circle's center
//    double x = scanner.nextDouble();
//
//    System.out.println("y : "); //y for the circle's center
//    double y = scanner.nextDouble();
//
//    System.out.println("Radius: "); //Radius of circle
//    double radius = scanner.nextDouble();
//
//    Circle2D c1 = new Circle2D(x, y, radius); //creating circle object
//
//    //Performing calculations 
//    
//    System.out.println("A: " + c1.circle_area());
//    System.out.println("P: " + c1.circle_parameter());
//
//    //asks for x and y coordinate of a point to check if it is in circle
//    System.out.println("x of the point to check:");
//    double x2 = scanner.nextDouble();
//
//    System.out.println("y of the point to check:");
//    double y2 = scanner.nextDouble();
//
//    System.out.println("Contains point (" + x2+ ", " + y2 + "): " + c1.contains(x2, y2));
//    
//    //asks for x and y of another circle > creates another circle object and checks if it is inside of first circle
//
//    System.out.println("x of the circle's center to check:");
//    double x3 = scanner.nextDouble();
//
//    System.out.println("y of the circle's center to check:");
//    double y3 = scanner.nextDouble();
//
//    System.out.println("Radius of the circle to check:");
//    double r2 = scanner.nextDouble();
//
//    Circle2D c2 = new Circle2D(x3, y3, r2);
//
//    System.out.println("Contains circle (" + x3 + ", " + y3 + ", " + r2 + "): " + c1.contains(c2));
//    System.out.println("Overlaps with circle (" + x3 + ", " + y3 + ", " + r2 + "): " + c1.overlaps(c2));
//  }
  
  // constructor without parameter
  public Circle2D() {
    this(0, 0, 1);
  }

  // Constructor with xparameters
  public Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.r = radius;
  }

  // Calculating Area of circle
  public double circle_area() {
    return Math.PI * r * r;
  }

  // Calculating Parameter of circle
  public double circle_parameter() {
    return 2 * Math.PI * r;
  }

  // checking if x & y exists in circle
  public boolean contains(double x, double y) {
    double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    return distance <= r;
  }

  // checking circle in a circle
  public boolean contains(Circle2D circle) {
    double distance = Math.sqrt(Math.pow(circle.x - this.x, 2) + Math.pow(circle.y - this.y, 2));
    return distance + circle.r <= this.r;
  }

  // checking if circle is overlaping the other circle
  public boolean overlaps(Circle2D circle) {
    double distance = Math.sqrt(Math.pow(circle.x - this.x, 2) + Math.pow(circle.y - this.y, 2));
    return distance <= this.r + circle.r;
  }
  
}

