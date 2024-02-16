import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int[] calculateSpan(int[] stockPrices) {
        int n = stockPrices.length;
        int[] span = new int[n];
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            span[i] = 1;
            int j = i - 1;
            while (j >= 0 && stockPrices[i] >= stockPrices[j]) {
                span[i]++;
                j--;
            }
        }
        return span;
    }

    public static void main(String[] args) {
        Main calculator = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] stockPrices = new int[n];

        for (int i = 0; i < n; i++) {
            stockPrices[i] = scanner.nextInt();
        }
        scanner.close();

        int[] spans = calculator.calculateSpan(stockPrices);
        System.out.println("Stock Prices: " + Arrays.toString(stockPrices));
        System.out.println("Stock Spans: " + Arrays.toString(spans));
    }
}
