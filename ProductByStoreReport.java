import java.util.List;
import java.util.ArrayList;
class ProductByStoreReport implements Report {
    private Store store;
    private List<Transaction> transactions;

    public ProductByStoreReport() {
        transactions = new ArrayList<>();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void printReport() {
        System.out.println("Product By Store Report for Store: " + store.getName());
        System.out.println("--------------------------------------");
        System.out.printf("%-5s | %-15s | %-10s%n", "ID", "Product Name", "Quantity");
        System.out.println("--------------------------------------");

        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equalsIgnoreCase("outgoing") &&
                    transaction.getStoreId() == store.getStoreId()) {
                for (Product product : transaction.getProductList().keySet()) {
                    int quantity = transaction.getProductList().get(product);
                    System.out.printf("%-5d | %-15s | %-10d%n", product.getID(), product.getName(), quantity);
                }
            }
        }

        System.out.println("--------------------------------------");
    }
}
