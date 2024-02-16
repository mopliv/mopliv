import java.util.Scanner;

// 1. Node class
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

// 2. LinkedList class
class LinkedList {
    Node head;

    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
        new_node.prev = curr;
    }
}

// 3. Solution class
class Solution {
    // Merge function
    public static Node merge(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                if (temp.data != -1)
                    head1.prev = temp;
                head1 = head1.next;
            } else {
                temp.next = head2;
                if (temp.data != -1)
                    head2.prev = temp;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1.prev = temp;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2.prev = temp;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    // Find the mid point
    public static Node find_mid(Node head) {
        Node slow = head, fast = head.next;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null)
                break;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }
        Node mid = find_mid(head);
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        head2.prev = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
}

// 4. Main class
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            a.add(input.nextInt());
        }
        Solution obj = new Solution();
        a.head = obj.mergeSort(a.head);
        Node h = a.head;
        System.out.println("Sorted linked list:");
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println("");
        input.close();
    }
}
