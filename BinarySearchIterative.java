public class BinarySearchIterative {

    public int binarySearch(int arr[], int n, int x) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + (r - l)) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                return r = mid - 1;
            } else {
                return l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] arg) {
        BinarySearchIterative bsi = new BinarySearchIterative();
        int array[] = { 2, 3, 4, 10, 40 };
        int n = array.length;
        int x = 10;

        int result = bsi.binarySearch(array, n, x);

        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result);
    }
}