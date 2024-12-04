package labques;
import java.util.Scanner;

public class assignment1_Q4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int a = input.nextInt();
            numArr[i] = a;
        }
        
        fizz_buzz(numArr);
    }
    
    public static void fizz_buzz(int[] arr){
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 3 == 0 && arr[i] % 5 ==0){
                System.out.println("FizzBuzz [" + arr[i] + "]");
            }else{
                if(arr[i] % 3 == 0){
                    System.out.println("Fizz [" + arr[i] + "]");
                }else{
                    if(arr[i] % 5 == 0){
                        System.out.println("Buzz [" + arr[i] + "]");
                    }
                }
            }
        }
    }
}
