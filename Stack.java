// import java.io.*; 
// import java.util.*;

public class Stack {

    int[] arr = new int[100];
    int top = -1;

    public void push(int x) {
        if (top == 100 - 1) {
            System.out.println("Error: stack overflow\n");
            return;
        }
        arr[++top] = x;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Error: no element to pop\n");
            return;
        }
        top--;
    }

    public int top() {
        return arr[top];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(2); 
        s.push(5); 
        s.push(10); 
        s.print();
        s.pop(); 
        s.print();
        s.push(12); 
        s.print();
    }
}