/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author surya
 */
public class ClassAssignment1_Q2 {
    
    //Reverse array without using another array
    
    public static void main(String[] args) {
        //initlizing aray
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        
        //Displaying original array
        System.out.print("Original Arr-> ");
        display(arr);
        
        //Reverse array
        arr = ArrayReverse(arr); 
        //New line
        System.out.print("\n");
        
        //Displaying reversed array
        System.out.print("Reversed Arr-> ");
        display(arr);
    }
    
    public static int[] ArrayReverse(int[] arr){
        for(int i = 0 ; i <= 5 ; i++){
            //Storing last element in a temp var
            int temp = arr[arr.length - 1 - i]; //10 
            //changing element on (arr.length - 1 - i) with current element
            arr[arr.length - 1 - i] = arr[i]; //10 -> 0
            //changing current element with element on (arr.length - 1 - i) with help of temp
            arr[i] = temp; // 0 -> 10
        }
        return arr;
    }
    
    //Simple function to print array
    public static void display(int[] arr){
        System.out.print("[");
        for(int i = 0; i <= arr.length -1 ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
