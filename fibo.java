import java.util.Scanner;

public class Fibonacci {

public static void generateFibonacci(int n) {
int num1 = 0, num2 = 1;

System.out.print("Fibonacci sequence up to " + n + " terms: ");

for (int i = 1; i <= n; ++i) {
System.out.print(num1 + " ");


int nextTerm = num1 + num2;
num1 = num2;
num2 = nextTerm;
}
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of terms for the Fibonacci sequence:");
int n = scanner.nextInt();

generateFibonacci(n);

scanner.close();
}
}
