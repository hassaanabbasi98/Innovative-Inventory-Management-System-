import java.util.*;
class Transaction {
    private int transactionId;
    private String transactionType;
    private String date;
    private int storeId; // For outgoing transactions
    private Map<Product, Integer> productList;

    public Transaction(int transactionId, String transactionType, String date) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.date = date;
        this.productList = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        productList.put(product, quantity);
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getDate() {
        return date;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }
}
