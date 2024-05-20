import java.util.Scanner;

public class SubsetSumTopDown {
private static Boolean[][] subsetSumMem;

private static boolean hasSubsetSumRecur(int[] values, int targetSum, int n) {
if (targetSum == 0) {
return true;
}
if (n == 0) {
return false;
}
if (subsetSumMem[targetSum][n] != null) {
return subsetSumMem[targetSum][n];
}
if (values[n - 1] > targetSum) {
subsetSumMem[targetSum][n] = hasSubsetSumRecur(values, targetSum, n - 1);
} else {
subsetSumMem[targetSum][n] = hasSubsetSumRecur(values, targetSum - values[n - 1], n - 1)
|| hasSubsetSumRecur(values, targetSum, n - 1);
}
return subsetSumMem[targetSum][n];
}

private static boolean hasSubsetSumMemoized(int[] values, int targetSum, int n) {
subsetSumMem = new Boolean[targetSum + 1][n + 1];
return hasSubsetSumRecur(values, targetSum, n);
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of elements in the array:");
int n = scanner.nextInt();
int[] values = new int[n];

System.out.println("Enter the elements of the array:");
for (int i = 0; i < n; i++) {
values[i] = scanner.nextInt();
}

System.out.println("Enter the target sum:");
int target = scanner.nextInt();
scanner.close();

System.out.println("Has Subset sum: " + hasSubsetSumMemoized(values, target, n));
}
}
