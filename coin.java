import java.util.Scanner;

class Main {

static int count(int coins[], int n, int sum) {
if (sum == 0)
return 1;

if (sum < 0 || n <= 0)
return 0;

return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
}

public static void main(String args[]) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of coins:");
int n = scanner.nextInt();

int coins[] = new int[n];

System.out.println("Enter the values of the coins:");
for (int i = 0; i < n; i++) {
coins[i] = scanner.nextInt();
}

System.out.println("Enter the target sum:");
int targetSum = scanner.nextInt();

scanner.close();

System.out.println("Number of ways to make " + targetSum + " using given coins: " + count(coins, n, targetSum));
}
}
