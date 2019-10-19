public class MaxHeap {
    int [] heap;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        heap = new int[this.maxSize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private Boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos < size) { 
            // (size - 1 - 1) / 2 is the last parent
            // next node would be leaf, which is ((size - 1 - 1) / 2) + 1
            return true;
        }
        return false;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void maxHeapify(int pos) {
        if(isLeaf(pos)) {
            return;
        }
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void push(int element) throws IllegalStateException {
        if (size == heap.length) {
            throw new IllegalStateException("Heap full");
        }

        size ++;
        heap[size - 1] = element;
        int current = size - 1;
        // while (heap[current] > heap[parent(current)]) {
        //     swap(current, parent(current));
        //     current = parent(current);
        // }
        while (current > 0) {
            if (heap[parent(current)] >= heap[current]) {
                return;
            } else {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    public int popMax() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("Empty heap");
        }
        int popped = heap[0];
        heap[0] = heap[size - 1];
        size--;

        maxHeapify(0);
        return popped;
    }

    public void print() {
        for (int i = 0; i <= ((size / 2) - 1); i++) {
            if ((2 * i) + 2 >= size) {
                System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[(2 * i) + 1]);
                System.out.println();
            } else {
                System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[(2 * i) + 1] + " RIGHT CHILD : " + heap[(2 * i) + 2]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        
        System.out.println("The Max Heap is: ");
        try {
        maxHeap.push(5); 
        maxHeap.push(3); 
        maxHeap.push(17); 
        maxHeap.push(10); 
        maxHeap.push(84); 
        maxHeap.push(19); 
        maxHeap.push(6); 
        maxHeap.push(22); 
        maxHeap.push(9);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        maxHeap.print();
        try {
            System.out.println("The max value popped is " + maxHeap.popMax());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        maxHeap.print();
    }
}