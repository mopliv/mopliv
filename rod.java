import java.util.Scanner;

class Main {

public static int cutRod(int[] price, int n) {
int[] val = new int[n + 1];
val[0] = 0;

for (int i = 1; i <= n; i++) {
int maxVal = Integer.MIN_VALUE;
for (int j = 0; j < i; j++) {
maxVal = Math.max(maxVal, price[j] + val[i - j - 1]);
}
val[i] = maxVal;
}

return val[n];
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of rod lengths:");
int n = scanner.nextInt();

int[] price = new int[n];
System.out.println("Enter the prices for each rod length:");
for (int i = 0; i < n; i++) {
price[i] = scanner.nextInt();
}

scanner.close();

int maxVal = cutRod(price, n);
System.out.println("Maximum obtainable value is " + maxVal);
}
}
