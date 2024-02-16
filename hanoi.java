import java.util.Scanner;
import java.util.Stack;

public class Main {
    static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        for (int i = numDisks; i >= 1; i--) {
            sourceStack.push(i);
        }

        int totalMoves = (int) Math.pow(2, numDisks) - 1;

        char temp;
        if (numDisks % 2 == 0) {
            temp = auxiliary;
            auxiliary = destination;
            destination = temp;
        }

        for (int move = 1; move <= totalMoves; move++) {
            if (move % 3 == 1) {
                moveDisk(sourceStack, destinationStack, source, destination);
            } else if (move % 3 == 2) {
                moveDisk(sourceStack, auxiliaryStack, source, auxiliary);
            } else if (move % 3 == 0) {
                moveDisk(auxiliaryStack, destinationStack, auxiliary, destination);
            }
        }
    }

    static void moveDisk(Stack<Integer> sourceStack, Stack<Integer> destinationStack, char source, char destination) {
        if (!sourceStack.isEmpty() && (destinationStack.isEmpty() || sourceStack.peek() < destinationStack.peek())) {
            destinationStack.push(sourceStack.pop());
            System.out.println("Move disk " + destinationStack.peek() + " from " + source + " to " + destination);
        } else {
            sourceStack.push(destinationStack.pop());
            System.out.println("Move disk " + sourceStack.peek() + " from " + destination + " to " + source);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDisks = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        char source = scanner.nextLine().charAt(0);
        
        char auxiliary = scanner.nextLine().charAt(0);
        
        char destination = scanner.nextLine().charAt(0);
        
        scanner.close();

        towerOfHanoi(numDisks, source, auxiliary, destination);
    }
}
