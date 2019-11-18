public class QuickSort2 {

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++; // ++ after found smaller than pivot because i starting at (low-1) and j starting at low instead of both starting at low
            }
        }
        int temp = arr[i]; 
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +  " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, -99, 18, 9999, 3205, -5524, 0, 7, 6, 53, -53};
        int n = arr.length - 1;

        System.out.println("Given array: ");
        printArray(arr);

        QuickSort2 qs = new QuickSort2();
        qs.sort(arr, 0, n);

        System.out.println("\nSorted array: ");
        printArray(arr);
    }
}