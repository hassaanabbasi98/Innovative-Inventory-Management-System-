import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class StockManager {
    private List<Product> products;
    private List<Store> stores;

    public StockManager() {
        products = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Store> getStores() {
        return stores;
    }

    // Add this method to get a product by its ID
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getID() == productId) {
                return product;
            }
        }
        return null; // Product with the given ID not found
    }
}
