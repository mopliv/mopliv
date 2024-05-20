import java.util.Scanner;

public class LongestCommonSubsequence {

public static String findLCS(String A, String B) {
int m = A.length();
int n = B.length();

int[][] lcsLength = new int[m + 1][n + 1];

for (int i = 0; i <= m; i++) {
for (int j = 0; j <= n; j++) {
if (i == 0 || j == 0) {
lcsLength[i][j] = 0;
} else if (A.charAt(i - 1) == B.charAt(j - 1)) {
lcsLength[i][j] = 1 + lcsLength[i - 1][j - 1];
} else {
lcsLength[i][j] = Math.max(lcsLength[i - 1][j], lcsLength[i][j - 1]);
}
}
}

int i = m, j = n;
StringBuilder lcs = new StringBuilder();
while (i > 0 && j > 0) {
if (A.charAt(i - 1) == B.charAt(j - 1)) {
lcs.insert(0, A.charAt(i - 1));
i--;
j--;
} else if (lcsLength[i - 1][j] > lcsLength[i][j - 1]) {
i--;
} else {
j--;
}
}
return lcs.toString();
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the first string:");
String A = scanner.nextLine();

System.out.println("Enter the second string:");
String B = scanner.nextLine();

String lcs = findLCS(A, B);
System.out.println("Longest Common Subsequence: " + lcs);

scanner.close();
}
}
