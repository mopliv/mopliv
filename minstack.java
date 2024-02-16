import java.util.Scanner;
import java.util.Stack;

class Main {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Main() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int element) {
        stack.push(element);
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int poppedElement = stack.pop();
            if (poppedElement == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        Main stack = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        int minElement = stack.getMin();
        System.out.println("Minimum Element: " + minElement);

        stack.pop();

        int topElement = stack.top();
        System.out.println("Top Element: " + topElement);

        int newMinElement = stack.getMin();
        System.out.println("After Pop New Minimum Element: " + newMinElement);

        scanner.close();
    }
}
