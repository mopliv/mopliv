import java.util.Scanner;

class Main {
    // Node class definition
    static class Node {
        int data;
        Node next;
        Node prev;
    }

    // Function to reverse a doubly linked list
    static Node reverse(Node head_ref) {
        Node temp = null;
        Node current = head_ref;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null)
            head_ref = temp.prev;
        return head_ref;
    }

    // Function to merge two sorted doubly linked lists
    static Node merge(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            if (first.next != null)
                first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null)
                second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    // Function to sort a doubly linked list
    static Node sort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node current = head.next;
        while (current != null && current.prev != null) {
            if (current.data < current.prev.data)
                break;
            current = current.next;
        }

        if (current == null)
            return head;

        current.prev.next = null;
        current.prev = null;
        current = reverse(current);
        return merge(head, current);
    }

    // Function to insert a new node at the beginning of a doubly linked list
    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = head_ref;
        if (head_ref != null)
            head_ref.prev = new_node;
        head_ref = new_node;
        return head_ref;
    }

    // Function to print a doubly linked list
    static void printList(Node head) {
        if (head == null)
            System.out.println("Doubly Linked list empty");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Main function
    public static void main(String args[]) {
        Node head = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int newData = scanner.nextInt();
            head = push(head, newData);
        }
        scanner.close();
        System.out.println("Original List:");
        printList(head);
        head = sort(head);
        System.out.println("\nSorted List:");
        printList(head);
    }
}
