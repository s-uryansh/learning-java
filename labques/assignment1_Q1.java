package labques;

public class assignment1_Q1 {
    public static void main(String[] args){
        int n = 5; //120
        int factorial = 1;
        for(int i = n ; i > 0; i--){
            factorial *= i;
        }
        System.out.println("Factorial of " + n + " is := " + factorial);

    }
}
