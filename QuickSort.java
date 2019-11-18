public class QuickSort {

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++; // ++ after found smaller than pivot because i starting at (low-1) and j starting at low instead of both starting at low

                // j goes faster until found a number smaller than pivot, will swap with i because all numbers that j visited
                // before stopping (meaning smaller than pivot) were greater than pivot. So when i++, and swap with j, greater
                // numbers will go to the right, smaller numbers will go to the left
                int temp = arr[i];
                arr[i] = arr[j]; 
                arr[j] = temp;
            }
        }

        // swapping the i+1 with the pivot so the pivot can go to the right place, which is where the partition will happen.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }
    
}