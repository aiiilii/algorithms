public class BubbleSort2 {

    public void bubbleSort2(int[] arr, int n) {
        int i, j, temp;
        for (i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
        System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, -99, 18, 9999, 3205, -5524, 0, 7, 6, 53, -53};
        int n = arr.length;
        System.out.println("Given array: ");
        printArray(arr, n);

        BubbleSort2 bs = new BubbleSort2();
        bs.bubbleSort2(arr, n);
        System.out.println("\nSorted array: ");
        printArray(arr, n);
    }
}