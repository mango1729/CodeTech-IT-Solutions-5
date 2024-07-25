import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.run();
    }

    private void run() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> editProduct();
                case 3 -> deleteProduct();
                case 4 -> generateReport();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        products.add(new Product(name, quantity, price));
        System.out.println("Product added successfully.");
    }

    private void editProduct() {
        System.out.print("Enter product name to edit: ");
        String name = scanner.nextLine();
        Product product = findProductByName(name);

        if (product != null) {
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter new price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        Product product = findProductByName(name);

        if (product != null) {
            products.remove(product);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void generateReport() {
        System.out.println("Inventory Report:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
