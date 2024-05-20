import java.util.Scanner;

public class Main {

static boolean checkCount(int[] arr, int n, int k) {
int count;

for (int i = 0; i < n; i++) {

count = 0;
for (int j = 0; j < n; j++) {
if (arr[j] == arr[i])
count++;

if (count > 2 * k)
return false;
}
}
return true;
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);


System.out.println("Enter the number of elements in the array:");
int n = scanner.nextInt();


int[] arr = new int[n];


System.out.println("Enter the elements of the array:");
for (int i = 0; i < n; i++) {
arr[i] = scanner.nextInt();
}


System.out.println("Enter the value of k:");
int k = scanner.nextInt();


System.out.println(checkCount(arr, n, k));


scanner.close();
}
}
