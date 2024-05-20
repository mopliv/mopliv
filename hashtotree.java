import java.util.*;
import java.util.stream.*;

class Main {


public static <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap) {
Map<K, V> treeMap = hashMap

.entrySet()

.stream()

.collect(Collectors

.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, TreeMap::new));


return treeMap;
}

public static void main(String args[]) {

Scanner scanner = new Scanner(System.in);


Map<String, String> hashMap = new HashMap<>();


System.out.println("Enter the number of entries: ");
int n = scanner.nextInt();
scanner.nextLine();  


for (int i = 0; i < n; i++) {
System.out.println("Enter key for entry " + (i + 1) + ": ");
String key = scanner.nextLine();
System.out.println("Enter value for entry " + (i + 1) + ": ");
String value = scanner.nextLine();
hashMap.put(key, value);
}


System.out.println("HashMap: " + hashMap);


Map<String, String> treeMap = convertToTreeMap(hashMap);


System.out.println("TreeMap: " + treeMap);


scanner.close();
}
}
