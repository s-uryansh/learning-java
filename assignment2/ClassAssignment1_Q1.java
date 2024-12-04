package assignment2;

/**
 *
 * @author surya
 */
public class ClassAssignment1_Q1 {
    public static void main(String[] args){
        int[] arr = {1 , 22, 2, 4, 5, 6 , 2 , 23 , 13 ,132 , 9 ,19 , 10 , 145,3};
        int n = Smallest_Even(arr , 0,Integer.MAX_VALUE);
        System.out.println("Smallest even numebr -> "+n);
        n = Largest_Odd(arr, 0, Integer.MIN_VALUE);
        System.out.println("Largest odd numebr -> "+n);
        n = Largest_PrimeFactor(arr, 0, 1);
        System.out.println("Largest odd numebr -> "+n);
        
}
   // (A)
    //arr and index as 0 and small as maxvalue for int is passed.
    //in first if if index exceeds arr length or isEqual to arr length current number is returned 
    //in second if first checks if even and is smaller than small (which initially is Integer.Max_value) 
    //runs recursively checking for smallest even number
        
    
    public static int Smallest_Even(int[] arr, int index, int small) {
        if (index >= arr.length) {
            return small;
        }

        if (arr[index] % 2 == 0 && arr[index] < small) {
            small = arr[index];
        }

        return Smallest_Even(arr, index+1, small);
    }
    
   // (B)
    //arr and index as 0 and small as min value for int is passed.
    //in first ( if )if index exceeds arr length or isEqual to arr length current number is returned 
    //in second if, first checks if odd and is larger than large (which initially is Integer.min_value) 
    //runs recursively checking for larger odd number
    public static int Largest_Odd(int[] arr, int index, int large) {
        if (index >= arr.length) {
            return large;
        }

        if (arr[index] % 2 != 0 && arr[index] > large) {
            large = arr[index];
        }

        return Largest_Odd(arr, index+1, large);
    }
    
   // (C)
        //first passing arr , index ( 0 ) , and maxPrimeFactor as 1 as it is the smallest and will be used to compare
        //than using the helper function we check if current prime factor is largest or not
    public static int Largest_PrimeFactor(int[] arr, int index, int maxPrimeFactor) {
        if (index >= arr.length) {
            return maxPrimeFactor;
        }

        int largePrimeCurrent = LargestPrimeFactorOfNumber(arr[index]);
        if (largePrimeCurrent > maxPrimeFactor) {
            maxPrimeFactor = largePrimeCurrent;
        }

        return Largest_PrimeFactor(arr, index + 1, maxPrimeFactor);
    }

    // finding largest prime factor of number
    public static int LargestPrimeFactorOfNumber(int num) {
        if (num <= 1) {
            return 1;
        }

        int largestPrimeFactor = 1;
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                largestPrimeFactor = i;
                num /= i;
            }
        }

        if (num > 1) {
            largestPrimeFactor = num;
        }

        return largestPrimeFactor;
    }
    
}
