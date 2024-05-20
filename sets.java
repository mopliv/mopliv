import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);


Set<String> set = new HashSet<>();


System.out.println("Enter elements for the set (type 'done' to finish):");
while (true) {
String input = scanner.nextLine();
if (input.equalsIgnoreCase("done")) {
break;
}
set.add(input);
}


System.out.println("Set elements: " + set);


System.out.print("Enter an element to check if the set contains it: ");
String checkElement = scanner.nextLine();
boolean containsElement = set.contains(checkElement);
System.out.println("Contains '" + checkElement + "': " + containsElement);


int setSize = set.size();
System.out.println("Set size: " + setSize);


boolean isEmpty = set.isEmpty();
System.out.println("Is set empty: " + isEmpty);


System.out.println("Iterating over elements:");
for (String element : set) {
System.out.println(element);
}


System.out.print("Enter an element to remove from the set: ");
String removeElement = scanner.nextLine();
set.remove(removeElement);
System.out.println("Set elements after removal: " + set);


set.clear();
System.out.println("Set elements after clearing: " + set);


Set<String> set1 = new HashSet<>();
Set<String> set2 = new HashSet<>();

System.out.println("Enter elements for the first set (type 'done' to finish):");
while (true) {
String input = scanner.nextLine();
if (input.equalsIgnoreCase("done")) {
break;
}
set1.add(input);
}

System.out.println("Enter elements for the second set (type 'done' to finish):");
while (true) {
String input = scanner.nextLine();
if (input.equalsIgnoreCase("done")) {
break;
}
set2.add(input);
}


Set<String> union = new HashSet<>(set1);
union.addAll(set2);
System.out.println("Set Union: " + union);


Set<String> intersection = new HashSet<>(set1);
intersection.retainAll(set2);
System.out.println("Set Intersection: " + intersection);


Set<String> difference = new HashSet<>(set1);
difference.removeAll(set2);
System.out.println("Set Difference: " + difference);


scanner.close();
}
}
