package week4.day_2.mapinterface;

import java.util.*;

class ShoppingCart<T> {
    private Map<T, Double> productPrices = new HashMap<>();
    private Map<T, Double> cartOrder = new LinkedHashMap<>();
    private TreeMap<T, Double> sortedByPrice = new TreeMap<>(Comparator.comparing(productPrices::get));

    public void addProduct(T product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        sortedByPrice.put(product, price);
    }

    public void displayCart() {
        System.out.println("Cart Items (Insertion Order): " + cartOrder);
    }

    public void displaySortedByPrice() {
        System.out.println("Cart Items (Sorted by Price): " + sortedByPrice);
    }
}

public class ImplementShoppingCart {
    public static void main(String[] args) {
        ShoppingCart<String> cart = new ShoppingCart<>();
        cart.addProduct("Laptop", 1000.0);
        cart.addProduct("Mouse", 25.0);
        cart.addProduct("Keyboard", 50.0);
        cart.addProduct("Monitor", 200.0);

        cart.displayCart();
        cart.displaySortedByPrice();
    }
}

