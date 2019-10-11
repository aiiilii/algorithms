public class LinkedList {

    Node head;
    static int count;

    public static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static LinkedList insertBeginning(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            newNode.next = list.head;
            list.head = newNode;
        }
        return list;
    }

    public static LinkedList insertAt(LinkedList list, int data, int index) throws Exception {
        Node newNode = new Node(data);
        newNode.next = null;
        // countNodes(list.head);

        if (index == 0) {
            newNode.next = list.head;
            list.head = newNode;
        } 
        //else if (index >= count) {
         //   throw new Exception("Invalid index.");
       // } 
        else {
            Node preIndexNode = list.head;
            for (int i = 0; i < index - 1; i++) {
                if (preIndexNode == null) {
                    throw new Exception ("Invalid insertion index");
                }
                preIndexNode = preIndexNode.next;
            }     
            newNode.next = preIndexNode.next;
            preIndexNode.next = newNode;
        }
        return list;
    }

    public static LinkedList delete (LinkedList list, int index) throws Exception {
        if (index == 0) {
            list.head = (list.head).next;
        } else {
            Node deletedNode = list.head;
            for (int i = 0; i < index - 1; i++) {
                if (deletedNode == null) {
                    throw new Exception("Invalid deletion index");
                }
                deletedNode = deletedNode.next;
            }
            deletedNode.next = (deletedNode.next).next;
        }
        return list;
    }

    public static int countNodes(Node head) {
        count = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count += 1;
        }
        return count;
    }

    public static LinkedList reverse(LinkedList list) {
        Node currentNode = list.head;
        Node prevNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode =  currentNode;
            currentNode = nextNode;
        }
        list.head = prevNode;
        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 

        list = insertBeginning(list, 13);
    
        try {
            list = insertAt(list, 9, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        try {
        list = delete(list, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        printList(list); 

        list = reverse(list);

        printList(list);
    }
}