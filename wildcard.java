import java.util.Scanner;

public class Main {
public static boolean isMatch(String word, String pattern) {
int n = word.length();
int m = pattern.length();
boolean[][] T = new boolean[n + 1][m + 1];
T[0][0] = true;
for (int j = 1; j <= m; j++) {
if (pattern.charAt(j - 1) == '*') {
T[0][j] = T[0][j - 1];
}
}
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= m; j++) {
if (pattern.charAt(j - 1) == '*') {
T[i][j] = T[i - 1][j] || T[i][j - 1];
} else if (pattern.charAt(j - 1) == '?' || word.charAt(i - 1) == pattern.charAt(j - 1)) {
T[i][j] = T[i - 1][j - 1];
}
}
}
return T[n][m];
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the word:");
String word = scanner.nextLine();

System.out.println("Enter the pattern:");
String pattern = scanner.nextLine();

scanner.close();

if (isMatch(word, pattern)) {
System.out.print("Match");
} else {
System.out.print("No Match");
}
}
}
