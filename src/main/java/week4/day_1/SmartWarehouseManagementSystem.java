package week4.day_1;

import java.util.ArrayList;
import java.util.List;

// Abstract class for Warehouse Items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }
   //method to get name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + name;
    }
}

// Subclasses for different item types
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}
//class Groceries extends WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}
//class Furniture extends class WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic storage class for warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Utility class to display all items in storage regardless of type
class WarehouseUtility {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to demonstrate functionality
public class SmartWarehouseManagementSystem  {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Mobile Phones"));
        electronicsStorage.addItem(new Electronics("Televisions"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Oil"));
        groceriesStorage.addItem(new Groceries("Rice"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Bed"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display individual storage items
        System.out.println("Electronics:");
        electronicsStorage.displayItems();

        System.out.println("\nGroceries:");
        groceriesStorage.displayItems();

        System.out.println("\nFurniture:");
        furnitureStorage.displayItems();

        // Using wildcard method to display items of any type
        WarehouseUtility.displayAllItems(electronicsStorage.getItems());
        WarehouseUtility.displayAllItems(groceriesStorage.getItems());
        WarehouseUtility.displayAllItems(furnitureStorage.getItems());
    }
}

