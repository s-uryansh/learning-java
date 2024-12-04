package assignment5;
import java.util.Scanner;

class NaturalNumbers implements Runnable {
    private int n;

    public NaturalNumbers(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class EvenNumbers implements Runnable {
    private int n;

    public EvenNumbers(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.print((i * 2) + " ");
        }
        System.out.println();
    }
}

class OddNumbers implements Runnable {
    private int n;

    public OddNumbers(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.print((i * 2 - 1) + " ");
        }
        System.out.println();
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt(); // User input for n

        // Input validation
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return;
        }
        //T stands for thread here :)
        Thread naturalT = new Thread(new NaturalNumbers(n));
        Thread evenT = new Thread(new EvenNumbers(n));
        Thread oddT = new Thread(new OddNumbers(n));

        naturalT.start();
        try {
            naturalT.join(); // Wait for the natural numbers thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        evenT.start();
        try {
            evenT.join(); // Wait for the even numbers thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        oddT.start();
        try {
            oddT.join(); // Wait for the odd numbers thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        scanner.close(); // Close the scanner
    }
}