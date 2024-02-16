import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static boolean isStackPermutation(int[] original, int[] target) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        for (int element : original) {
            stack.push(element);
            while (!stack.isEmpty() && stack.peek() == target[i]) {
                stack.pop();
                i++;
            }
        }
        
        return stack.isEmpty() && i == target.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int size = scanner.nextInt();

        int[] original = new int[size];
        int[] target = new int[size];

        
        for (int i = 0; i < size; i++) {
            original[i] = scanner.nextInt();
        }

        
        for (int i = 0; i < size; i++) {
            target[i] = scanner.nextInt();
        }

        boolean result = isStackPermutation(original, target);
        System.out.println("Is it a stack permutation? " + result);

        scanner.close();
    }
}
