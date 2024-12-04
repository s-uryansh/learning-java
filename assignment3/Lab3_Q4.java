/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author surya
 */
public class Lab3_Q4 {
   public static void main(String[] args){
        Fan f1=new Fan();
        f1.set_speed(Fan.FAST);
        f1.set_radius(10);
        f1.set_color("yellow");
        f1.set_on(true);
        System.out.println(f1.tostring());

        Fan f2=new Fan();
        f2.set_speed(Fan.MEDIUM);
        f2.set_radius(5);
        f2.set_color("blue");
        System.out.println(f2.tostring());
    }
}

class Fan{
    public static final int SLOW=1;
    public static final int MEDIUM=2;
    public static final int FAST=3;

    private int speed;
    public int get_speed(){
        return speed;
    }
    public void set_speed(int speed){
        this.speed = speed;
    }

    private boolean on;
    public boolean isOn(){
        return on;
    }
    public void set_on(boolean on){
        this.on = on;
    }

    private double radius;
    public double get_radius(){
        return radius;
    }
    public void set_radius(double radius){
        this.radius = radius;
    }

    private String color;
    public String get_color(){
        return color;
    }
    public void set_color(String color){
        this.color = color;
    }

    Fan(){
        this.speed=SLOW;
        this.on=false;
        this.radius=5;
        this.color="Blue";
    }

    public String tostring(){
        if (this.isOn()){
            String string=speed + " " + color+ " " +radius+ " " ;
            return string;
        }

        else{
            String string=color+ " " +radius+ " " +"fan is off";
            return string;
        }
    }

}
