/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;
import java.util.Scanner;
/**
 *
 * @author surya
 */
public class Lab3_Q5 {
     public static void main(String[] args) {
        boolean[] seats = new boolean[10];

        for (int i = 0; i < seats.length; i++) {
            seats[i] = false;
        }

        for (int j = 0; j < seats.length; j++) {
            int choice = str();  // Save the str result

            if (choice == 1) {
                // First class seats
                if (first_class_full(seats)) {
                    System.out.println("First class is full, is a seat in Economy acceptable? (Reply in yes/no): ");
                    Scanner sc = new Scanner(System.in);
                    String answer = sc.nextLine();

                    if (economy_class_full(seats)) {
                        System.out.println("Economy class is full as well, next flight leaves in 3 hours.");
                    } else if (answer.equalsIgnoreCase("yes")) {
                        economy_class_assign(seats);
                    } else {
                        System.out.println("Next flight leaves in 3 hours.\n\n");
                    }
                } else {
                    first_class_assign(seats);
                }
            } else if (choice == 2) {
                // Economy class seats
                if (economy_class_full(seats)) {
                    System.out.println("Economy class is full, is a seat in First Class acceptable? (Reply in yes/no): ");
                    Scanner sc = new Scanner(System.in);
                    String answer = sc.nextLine();

                    if (first_class_full(seats)) {
                        System.out.println("First class is full as well, next flight leaves in 3 hours.");
                    } else if (answer.equalsIgnoreCase("yes")) {
                        first_class_assign(seats);
                    } else {
                        System.out.println("Next flight leaves in 3 hours.\n\n");
                    }
                } else {
                    economy_class_assign(seats);
                }
            }
        }

        if (first_class_full(seats) && economy_class_full(seats)) {
            System.out.println("All tickets booked, next flight leaves in 3 hours. \n\n");
        }
    }

    public static int str() {
        System.out.println("Please type 1 for a first class ticket or 2 for an economy class ticket: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static boolean[] first_class_assign(boolean[] seats) {
        for (int k = 0; k < 5; k++) {
            if (!seats[k]) {
                seats[k] = true;
                System.out.println("Assigned seat: " + (k + 1) + " in First Class.\n\n");
                break;
            }
        }
        return seats;
    }

    public static boolean[] economy_class_assign(boolean[] seats) {
        for (int k = 5; k < 10; k++) {
            if (!seats[k]) {
                seats[k] = true;
                System.out.println("Assigned seat: " + (k + 1) + " in Economy Class.\n\n");
                break;
            }
        }
        return seats;
    }

    public static boolean first_class_full(boolean[] seats) {
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean economy_class_full(boolean[] seats) {
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                return false;
            }
        }
        return true;
    }
}
