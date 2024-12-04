/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;
import java.util.Scanner;

/**
 *
 * @author surya
 */
public class SortList {
    public void sort_list(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap element if any in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //Sorting order with bubble sort
    public void sort_list(int[] arr, int n, boolean reverse) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (reverse ? arr[j] < arr[j + 1] : arr[j] > arr[j + 1]) {
                    //swap element if any in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void sort_list(String[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    //swap element if any in wrong order
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //displays array
    public void display(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }

    public void display(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortList do_sort = new SortList();

        System.out.println("size of arr: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("element: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        do_sort.sort_list(arr, n);
        System.out.println("Ascending: ");
        do_sort.display(arr);

        do_sort.sort_list(arr, n, true);
        System.out.println("Descending: ");
        do_sort.display(arr);

        System.out.println("Size of the string array: ");
        int m = sc.nextInt();
        sc.nextLine();

        String[] strArr = new String[m];
        System.out.println("Elements: ");
        for (int i = 0; i < m; i++) {
            strArr[i] = sc.nextLine();
        }

        do_sort.sort_list(strArr, m);
        System.out.println("Sorted:");
        do_sort.display(strArr);
    }
}
