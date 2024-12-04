package labques;

public class assignment1_Q8 {
        public static void main(String[] args) {
        double[] arr = {3.4, 1.2, 4.5, 2.1, 6.7, 8.9, 0.5, 9.1, 7.3, 5.6};

        System.out.println("Original array:");
        displayArr(arr);
        System.out.println();

        insertionSort(arr);

        System.out.println("Sorted array:");
        displayArr(arr);
        
        System.out.println();

        double target = 5.6; // Testing
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " is not in array");
        }
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

    public static int binarySearch(double[] arr, double target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // not found
    }

    public static void displayArr(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
