package week4.day_1;

import java.util.ArrayList;
import java.util.List;

// Abstract base class for product categories
abstract class ProductCategory {
    private String name;

    //constructor
    public ProductCategory(String name) {
        this.name = name;
    }
   //method to get name
    public String getName() {
        return name;
    }
}

// Specific product categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Book");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadget");
    }
}

// Generic Product class with bounded type parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category.getName() + ") - " + price;
    }
}

// Generic method to apply discount
class DiscountManager {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + product.getName() + " now costs $" + product.getPrice());
    }
}

// Marketplace Catalog
class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void showProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Product<BookCategory> book = new Product<>("Java", 76.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Black Shirt", 33.99, new ClothingCategory());
        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 89.99, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(smartphone);

        System.out.println("Before Discount:");
        catalog.showProducts();

        DiscountManager.applyDiscount(book, 15);
        DiscountManager.applyDiscount(shirt, 10);
        DiscountManager.applyDiscount(smartphone, 20);

        System.out.println("\nAfter Discount:");
        catalog.showProducts();
    }
}
