import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
public static void LBS(int[] nums) {
int n = nums.length;
if (n == 0) {
return;
}

List<List<Integer>> I = new ArrayList<>();
for (int i = 0; i < n; i++) {
I.add(new ArrayList<>());
}

I.get(0).add(nums[0]);
for (int i = 1; i < n; i++) {
for (int j = 0; j < i; j++) {
if (I.get(i).size() < I.get(j).size() && nums[i] > nums[j]) {
I.set(i, new ArrayList<>(I.get(j)));
}
}
I.get(i).add(nums[i]);
}

List<List<Integer>> D = new ArrayList<>();
for (int i = 0; i < n; i++) {
D.add(new ArrayList<>());
}

D.get(n - 1).add(0, nums[n - 1]);
for (int i = n - 2; i >= 0; i--) {
for (int j = n - 1; j > i; j--) {
if (D.get(i).size() < D.get(j).size() && nums[i] > nums[j]) {
D.set(i, new ArrayList<>(D.get(j)));
}
}
D.get(i).add(0, nums[i]);
}

int peak = 0;
for (int i = 1; i < n; i++) {
if ((I.get(i).size() + D.get(i).size()) > (I.get(peak).size() + D.get(peak).size())) {
peak = i;
}
}

System.out.print("Longest Bitonic Subsequence: ");
System.out.print(I.get(peak));
D.get(peak).remove(0);
System.out.println(D.get(peak));
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

LBS(nums);

scanner.close();
}
}
