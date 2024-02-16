import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void segregateEvenOdd() {
        if (head == null) {
            return;
        }
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node current = head;
        while (current != null) {
            int data = current.data;
            if (data % 2 == 0) { // even node
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else { // odd node
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }
        // Join even and odd lists
        if (evenHead != null) {
            evenTail.next = oddHead;
        }
        if (oddHead != null) {
            oddTail.next = null;
        }
        head = evenHead != null ? evenHead : oddHead;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        list.printList();

        list.segregateEvenOdd();
        list.printList();

        scanner.close();
    }
}
