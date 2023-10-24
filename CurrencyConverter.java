package CodeSoftTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Initialize exchange rates (example rates, not real-time)
        exchangeRates.put("USD", 1.0);  // US Dollar as the base currency
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.73); // British Pound
        exchangeRates.put("JPY", 110.0); // Japanese Yen
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);
        return amount * (toRate / fromRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Welcome to the Currency Converter!");

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the base currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        double convertedAmount = converter.convertCurrency(amount, fromCurrency, toCurrency);

        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

        scanner.close();
    }
}

