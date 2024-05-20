import java.util.Scanner;

public class Main {

public static int calculateLBS(int[] nums) {
int n = nums.length;

if (n == 0) {
return 0;
}

int[] I = new int[n];
int[] D = new int[n];

I[0] = 1;
for (int i = 1; i < n; i++) {
for (int j = 0; j < i; j++) {
if (nums[j] < nums[i] && I[j] > I[i]) {
I[i] = I[j];
}
}
I[i]++;
}

D[n - 1] = 1;
for (int i = n - 2; i >= 0; i--) {
for (int j = n - 1; j > i; j--) {
if (nums[j] < nums[i] && D[j] > D[i]) {
D[i] = D[j];
}
}
D[i]++;
}

int lbs = 1;
for (int i = 0; i < n; i++) {
lbs = Integer.max(lbs, I[i] + D[i] - 1);
}
return lbs;
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of elements in the array:");
int n = scanner.nextInt();

int[] nums = new int[n];

System.out.println("Enter the elements of the array:");
for (int i = 0; i < n; i++) {
nums[i] = scanner.nextInt();
}

System.out.println("Length of Longest Bitonic Subsequence: " + calculateLBS(nums));

scanner.close();
}
}
