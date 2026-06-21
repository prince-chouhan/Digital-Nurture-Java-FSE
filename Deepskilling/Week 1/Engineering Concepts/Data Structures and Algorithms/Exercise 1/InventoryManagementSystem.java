package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DataStructuresAndAlgorithms.Exercise1;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {

    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public void displayProducts() {
        inventory.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product(1, "Laptop", 10, 50000));
        ims.addProduct(new Product(2, "Mouse", 50, 500));

        ims.displayProducts();

        ims.updateProduct(1, 15, 52000);

        ims.deleteProduct(2);

        ims.displayProducts();
    }
}