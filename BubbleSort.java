// import java.io.*;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {  // largest i is n-2, or else (n-i-1) would be 0 and the inside loop would not run anyways
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // if no two elements were swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }
    }

    public static void printArray (int[] arr, int n) {
        int i;
        for (i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }

}