package labques;

import java.util.Scanner;
public class assignment1_Q2 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numArr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int a = input.nextInt();

            numArr[i] = a;
        }
        int maxInt = maximum(numArr);
        System.out.println(maxInt);

    }
    public static int maximum(int[] args){
        int max = 0;
        for (int i = 0 ; i < args.length; i++ ){
            if (max < args[i]){
                max = args[i];
            }else{
                continue;
            }
        }
        return max;
        
    }
}
