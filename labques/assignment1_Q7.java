package labques;

import java.util.Scanner;

public class assignment1_Q7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double[] arr = new double[10];

        //TAKING INPUT FROM CONSOLE
//        System.out.println("Enter 10 double numbers:");
//        for (int i = 0; i < 10; i++) {
//            arr[i] = scanner.nextDouble();
//        }

        //FOR TEST PROGRAM
        
        double[] arr = {3.4, 1.2, 4.5, 2.1, 6.7, 8.9, 0.5, 9.1, 7.3, 5.6};
        //MANUALLY ADDED ARR

        System.out.println("Original array:");
        displayArr(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        displayArr(arr);
    }

        public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void displayArr(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
