package labques;

import java.util.Scanner;

public class assignment1_Q5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the interest rate: ");
        double  interestRate = input.nextDouble();
        
        System.out.print("Enter the number of years: ");
        double numberOfYears = input.nextDouble();
        
        System.out.print("Enter the loan amount: ");
        double  loanAmount = input.nextDouble();
        
        double monthlyPayment = ( (loanAmount * interestRate) / (1.0 - (1.0/Math.pow(1+interestRate , (numberOfYears * 12.0)))));
        
        System.out.printf("Monthly payment: $%.2f%n", monthlyPayment);
    }
}
