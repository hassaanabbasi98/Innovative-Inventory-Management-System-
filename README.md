# Inventory Management System

## Overview

The Inventory Management System is a Java-based console application designed to manage and track products, stores, and transactions within a business. It provides functionalities for adding products, stores, and transactions, generating reports related to inventory, items entered, items sent, and transactions.

## Features

- **Product Management**: Add new products with unique IDs, names, and quantities.
- **Store Management**: Add new stores with unique IDs, names, and addresses.
- **Transaction Management**: Record incoming and outgoing transactions, associating them with specific products and dates.
- **Reporting**: Generate various reports, including inventory reports, items entered reports, items sent reports, and transaction reports.

## Getting Started

 **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/inventory-management-system.git
   cd inventory-management-system

****1. Compile and Run:**

javac InventoryManagementSystem.java
java InventoryManagementSystem

Follow On-Screen Instructions:
The application will prompt you with a menu to perform various actions. Follow the on-screen instructions to add products, stores, transactions, and generate reports.

**Usage**
Adding Products:

Enter product ID, name, and quantity when prompted.
Adding Stores:

Enter store ID, name, and address when prompted.
Adding Incoming Transactions:

Enter transaction ID, type (incoming/outgoing), date, and products to associate with the transaction. Enter -1 when done.
Adding Outgoing Transactions:

Similar to incoming transactions, enter transaction ID, date, and associated products. Enter -1 when done.
Generating Reports:

Choose the report type from the menu and follow the prompts to provide additional information if needed (e.g., month, year, store ID).
Exiting:

Enter 0 to exit the application.

**Structure**

InventoryManagementSystem.java: Main application file containing the entry point and user interface.
StockManager.java: Manages products and stores.
ReportsManager.java: Generates various reports based on the stored data.
TransactionsManager.java: Manages incoming and outgoing transactions.
Product.java: Represents a product with an ID, name, and quantity.
Store.java: Represents a store with an ID, name, and address.
Transaction.java: Represents a transaction with an ID, type, date, and associated products.

**Contributing**

Contributions are welcome! If you have suggestions, improvements, or find any issues, please open an issue or submit a pull request.

   

