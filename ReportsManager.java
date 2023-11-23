import java.util.List;
import java.util.ArrayList;
class ReportsManager {
    private List<Transaction> transactions;
    private List<Product> products;
    private List<Store> stores;

    public ReportsManager() {
        transactions = new ArrayList<>();
        products = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Product> generateInventoryReport() {
        return products;
    }

    public List<Product> generateItemsEnteredReport(int month, int year) {
        List<Product> itemsEntered = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equalsIgnoreCase("incoming") &&
                    getMonthFromDate(transaction.getDate()) == month && getYearFromDate(transaction.getDate()) == year) {
                for (Product product : transaction.getProductList().keySet()) {
                    int quantity = transaction.getProductList().get(product);
                    product.setNumberOfItems(product.getNumberOfItems() + quantity);
                    itemsEntered.add(product);
                }
            }
        }
        return itemsEntered;
    }

    public List<Product> generateItemsSentReport(Integer storeId, int month, int year) {
        List<Product> itemsSent = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equalsIgnoreCase("outgoing") &&
                    transaction.getStoreId() == storeId &&
                    getMonthFromDate(transaction.getDate()) == month && getYearFromDate(transaction.getDate()) == year) {
                for (Product product : transaction.getProductList().keySet()) {
                    int quantity = transaction.getProductList().get(product);
                    product.setNumberOfItems(product.getNumberOfItems() - quantity);
                    itemsSent.add(product);
                }
            }
        }
        return itemsSent;
    }

    public List<Transaction> generateTransactionReport(String transactionType, int month, int year) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equalsIgnoreCase(transactionType) &&
                    getMonthFromDate(transaction.getDate()) == month && getYearFromDate(transaction.getDate()) == year) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    private int getMonthFromDate(String date) {
        String[] parts = date.split("/");
        return Integer.parseInt(parts[0]);
    }

    private int getYearFromDate(String date) {
        String[] parts = date.split("/");
        return Integer.parseInt(parts[2]);
    }
}
