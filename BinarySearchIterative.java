public class BinarySearchIterative {

    public int binarySearch(int arr[], int l, int r, int x) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] arg) {
        BinarySearchIterative bsi = new BinarySearchIterative();
        int array[] = { 2, 3, 4, 10, 40 };
        int n = array.length;
        int x = 10;

        int result = bsi.binarySearch(array, 0, n - 1, x);

        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result);
    }
}