import java.util.Scanner;

class PriorityQueueNode<T> {
    T data;
    int priority;
    PriorityQueueNode<T> prev;
    PriorityQueueNode<T> next;

    public PriorityQueueNode(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}

class PriorityQueue<T> {
    private PriorityQueueNode<T> head;
    private PriorityQueueNode<T> tail;

    public PriorityQueue() {
        head = null;
        tail = null;
    }

    public void insert(T data, int priority) {
        PriorityQueueNode<T> newNode = new PriorityQueueNode<>(data, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (priority < head.priority) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            PriorityQueueNode<T> current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
    }

    public T delete() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return data;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        while (true) {
            String task = scanner.nextLine();
            if (task.equalsIgnoreCase("exit")) {
                break;
            }

            int priority = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            priorityQueue.insert(task, priority);
        }
        scanner.close();

        System.out.println("Highest-priority task: " + priorityQueue.peek());
        while (!priorityQueue.isEmpty()) {
            System.out.println("Executing: " + priorityQueue.delete());
        }
    }
}
