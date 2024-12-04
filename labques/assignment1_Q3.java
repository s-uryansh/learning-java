package labques;

import java.util.Scanner;
public class assignment1_Q3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int a = input.nextInt();
            numArr[i] = a;
        }
        int[] Primearr = primeArr(numArr);
        System.out.print("[");
        for(int i = 0 ; i < Primearr.length ; i++){
            if (Primearr[i] == 0){
                
            }else{
                System.out.print(Primearr[i] + " ");

            }
        }
        System.out.print("]\n");

        
    }
    
    public static int[] primeArr(int[] arr){
        int[] primeArray = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            boolean isPrime = true; 
            for(int j = 2 ; j*j <=arr[i] ;j++){
                if(arr[i] % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                    primeArray[i] = arr[i];
                }
        }
        return primeArray;
    }
}
