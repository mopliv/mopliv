import java.util.Scanner;

public class Main {
public static int findMaxCoins(int[] coin, int i, int j, int[][] lookup) {
if (i == j) return coin[i];
if (i + 1 == j) return Math.max(coin[i], coin[j]);
if (lookup[i][j] == 0) {
int start = coin[i] + Math.min(findMaxCoins(coin, i + 2, j, lookup), findMaxCoins(coin, i + 1, j - 1, lookup));
int end = coin[j] + Math.min(findMaxCoins(coin, i + 1, j - 1, lookup), findMaxCoins(coin, i, j - 2, lookup));
lookup[i][j] = Math.max(start, end);
}
return lookup[i][j];
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of coins:");
int n = scanner.nextInt();

int[] coin = new int[n];
System.out.println("Enter the values of the coins:");
for (int i = 0; i < n; i++) {
coin[i] = scanner.nextInt();
}

scanner.close();

int[][] lookup = new int[n][n];
System.out.println("Maximum coins collected by player: " + findMaxCoins(coin, 0, n - 1, lookup));
}
}
