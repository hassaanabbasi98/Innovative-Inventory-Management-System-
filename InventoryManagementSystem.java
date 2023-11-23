import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockManager stockManager = new StockManager();
        ReportsManager reportsManager = new ReportsManager();
        TransactionsManager transactionsManager = new TransactionsManager();

        // Sample usage of the Inventory Management System
        // You can create instances of classes and perform various operations here
        // For testing purposes, let's assume we have some products and stores

        while (true) {
            System.out.println("==== Inventory Management System ====");
            System.out.println("Enter number of action to perform.");
            System.out.println("1. Add Product");
            System.out.println("2. Add Store");
            System.out.println("3. Add Incoming Transaction");
            System.out.println("4. Add Outgoing Transaction");
            System.out.println("5. Generate Inventory Report");
            System.out.println("6. Generate Items Entered Report");
            System.out.println("7. Generate Items Sent Report");
            System.out.println("8. Generate Transaction Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID(e.g. 123): ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter Product Name(e.g. Laptop): ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter Product Quantity(e.g. 5): ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Product product = new Product(productId, productName, productQuantity);
                    stockManager.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Store ID(e.g. 123): ");
                    int storeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter Store Name(e.g. MM Store): ");
                    String storeName = scanner.nextLine();

                    System.out.print("Enter Store Address: ");
                    String storeAddress = scanner.nextLine();

                    Store store = new Store(storeId, storeName, storeAddress);
                    stockManager.addStore(store);
                    System.out.println("Store added successfully.");
                    break;
                     
                case 3:
                    // Code to add an incoming
                    System.out.print("Enter Transaction ID(e.g. 123): ");
                    int incomingTransactionId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter Transaction Type (incoming/outgoing): ");
                    String incomingTransactionType = scanner.nextLine();

                    System.out.print("Enter Transaction Date (e.g., 7/28/2023): ");
                    String incomingTransactionDate = scanner.nextLine();

                    Transaction incomingTransaction = new Transaction(incomingTransactionId, incomingTransactionType, incomingTransactionDate);

                     // Adding products to the incoming transaction
                     System.out.println("Add Products to the Incoming Transaction (Enter 'done' to finish):");
                    while (true) {
                        System.out.print("Enter Product ID(e.g. 123): ");
                        int prodId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                    if (prodId == -1) {
                    break;
                    }

                    System.out.print("Enter Product Quantity(e.g. 5): ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Product prod = stockManager.getProductById(prodId);
                    if (prod != null) {
                    incomingTransaction.addProduct(prod, quantity);
                    prod.setNumberOfItems(prod.getNumberOfItems() + quantity); // Update product quantity
                } 
                    else {
                    System.out.println("Product not found in the inventory.");
        }
    }

                 transactionsManager.addTransaction(incomingTransaction);
                 System.out.println("Incoming Transaction added successfully.");
                break;

            
                case 4:
                    // Code to add an outgoing transaction
                    System.out.print("Enter Transaction ID(e.g. 123): ");
                    int outgoingTransactionId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter Transaction Date (e.g., 7/28/2023): ");
                    String outgoingTransactionDate = scanner.nextLine();

                    Transaction outgoingTransaction = new Transaction(outgoingTransactionId, "outgoing", outgoingTransactionDate);

                    // Adding products to the outgoing transaction
                    System.out.println("Add Products to the Outgoing Transaction (Enter 'done' to finish):");
                    while (true) {
                        System.out.print("Enter Product ID(e.g. 123): ");
                        int prodId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (prodId == -1) {
                            break;
                        }

                        System.out.print("Enter Product Quantity(e.g. 5): ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        Product prod = stockManager.getProductById(prodId);
                        if (prod != null) {
                            outgoingTransaction.addProduct(prod, quantity);
                        } else {
                            System.out.println("Product not found in the inventory.");
                        }
                    }

                    transactionsManager.addTransaction(outgoingTransaction);
                    System.out.println("Outgoing Transaction added successfully.");

                    break;
                case 5:
                    // Generate and print the inventory report
                    reportsManager.setProducts(stockManager.getProducts());
                    List<Product> inventoryReport = reportsManager.generateInventoryReport();
                    System.out.println("Inventory Report");
                    System.out.println("--------------------------------------");
                    System.out.printf("%-5s | %-15s | %-10s%n", "ID", "Product Name", "Quantity");
                    System.out.println("--------------------------------------");
                    for (Product prod : inventoryReport) {
                        System.out.printf("%-5d | %-15s | %-10d%n", prod.getID(), prod.getName(), prod.getNumberOfItems());
                    }
                    System.out.println("--------------------------------------");
                    break;

                case 6:
                    // Generate and print the items entered report
                    System.out.print("Enter the month (1-12): ");
                    int enteredMonth = scanner.nextInt();
                    System.out.print("Enter the year: ");
                    int enteredYear = scanner.nextInt();
                    List<Product> itemsEnteredReport = reportsManager.generateItemsEnteredReport(enteredMonth, enteredYear);
                    System.out.println("Items Entered Report");
                    System.out.println("--------------------------------------");
                    System.out.printf("%-5s | %-15s | %-10s%n", "ID", "Product Name", "Quantity");
                    System.out.println("--------------------------------------");
                    for (Product prod : itemsEnteredReport) {
                        System.out.printf("%-5d | %-15s | %-10d%n", prod.getID(), prod.getName(), prod.getNumberOfItems());
                    }
                    System.out.println("--------------------------------------");
                    break;
                case 7:
                    // Generate and print the items sent report
                    System.out.print("Enter Store ID: ");
                    int storeIdForSentReport = scanner.nextInt();
                    System.out.print("Enter the month (1-12): ");
                    int sentMonth = scanner.nextInt();
                    System.out.print("Enter the year: ");
                    int sentYear = scanner.nextInt();
                    List<Product> itemsSentReport = reportsManager.generateItemsSentReport(storeIdForSentReport, sentMonth, sentYear);
                    System.out.println("Items Sent Report");
                    System.out.println("--------------------------------------");
                    System.out.printf("%-5s | %-15s | %-10s%n", "ID", "Product Name", "Quantity");
                    System.out.println("--------------------------------------");
                    for (Product prod : itemsSentReport) {
                        System.out.printf("%-5d | %-15s | %-10d%n", prod.getID(), prod.getName(), prod.getNumberOfItems());
                    }
                    System.out.println("--------------------------------------");
                    break;
                case 8:
                    // Generate and print the transaction report
                    System.out.print("Enter Transaction Type (incoming/outgoing): ");
                    String transactionTypeForReport = scanner.nextLine();
                    System.out.print("Enter the month (1-12): ");
                    int transactionMonth = scanner.nextInt();
                    System.out.print("Enter the year: ");
                    int transactionYear = scanner.nextInt();
                    List<Transaction> transactionReport = reportsManager.generateTransactionReport(transactionTypeForReport, transactionMonth, transactionYear);
                    System.out.println("Transaction Report");
                    System.out.println("--------------------------------------");
                    System.out.printf("%-10s | %-15s | %-10s%n", "Transaction ID", "Transaction Type", "Date");
                    System.out.println("--------------------------------------");
                    for (Transaction transaction : transactionReport) {
                        System.out.printf("%-10d | %-15s | %-10s%n", transaction.getTransactionId(), transaction.getTransactionType(), transaction.getDate());
                    }
                    System.out.println("--------------------------------------");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
