import java.util.*;

public class Main {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    static boolean detectLoop(Node h) {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            if (s.contains(h))
                return true;
            s.add(h);
            h = h.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main llist = new Main();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            llist.push(data);
        }

        // Create a loop for testing
        // llist.head.next.next.next.next = llist.head;

        if (detectLoop(head))
            System.out.println("Loop Exists");
        else
            System.out.println("Loop doesn't exist");

        scanner.close();
    }
}
