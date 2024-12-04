/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author surya
 */
public class Lab3_Q2 {
      public static void main(String[] args){
        Triangle t1=new Triangle();
        Triangle t2=new Triangle();

        t1.a_side=4;
        t1.b_side=5;
        t1.c_side=6;

        System.out.println("Area of first triangle is: " + t1.get_area());
        System.out.println("Perimeter of first triangle is: " + t1.get_perimeter());

        t2.a_side=1.5;
        t2.b_side=2.5;
        t2.c_side=3.5;
        System.out.println("Area of second triangle is: " + t2.get_area());
        System.out.println("Perimeter of second triangle is: " + t2.get_perimeter());
    }
}

class Triangle{
    double a_side;
    double b_side;
    double c_side;

    Triangle(){
        this.a_side = 1;
        this.b_side = 1;
        this.c_side = 1;
    }

    Triangle(double a_side, double b_side, double c_side){
        this.a_side = a_side;
        this.b_side = b_side;
        this.c_side = c_side;
    }

    public double get_side_a(){
        return a_side;
    }

    public double get_side_b(){
        return b_side;
    }

    public double get_side_c(){
        return c_side;
    }

    public void set_side_a(double a_side){
        this.a_side = a_side;
    }

    public void set_side_b(double b_side){
        this.b_side = b_side;
    }

    public void set_side_c(double c_side){
        this.c_side = c_side;
    }

    public double get_area() {
        double s = (a_side + b_side + c_side) / 2;
        return Math.sqrt(s * (s - a_side) * (s - b_side) * (s - c_side));
    }

    public double get_perimeter() {
        return a_side + b_side + c_side;
    }
}
