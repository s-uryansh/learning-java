/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author surya
 */
public class ObjCount {
    static int count; //Static int to store variable
    
    public ObjCount() {
        //incrementing count when object is created
    count++;
}
    
    public static void main(String[] args){
        ObjCount obj1 = new ObjCount();
        ObjCount obj2 = new ObjCount();
        ObjCount obj3 = new ObjCount();
        
        ObjCount.show_count();
        
    }
    public static void show_count(){
        System.out.println("No. of objs created: " + count);
    }
}
