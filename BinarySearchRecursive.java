public class BinarySearchRecursive {

    public int binarySearch(int arr[], int l, int r, int x) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            } else {
                return binarySearch(arr, mid + 1, r, x);
            }
        }
        return -1;
    }

    public static void main(String[] arg) {
        BinarySearchRecursive bs = new BinarySearchRecursive();
        int [] array = { 2, 3, 4, 10, 40 };
        int n = array.length;

        int result = bs.binarySearch(array, 0, n - 1, 10);

        if (result == -1) {
            System.out.println("Element does not exist in array");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}