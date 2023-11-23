import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
class TransactionsManager {
    private List<Transaction> transactions;

    public TransactionsManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction tr) {
        transactions.add(tr);
    }

    public void appendToFile(String fileName, String transaction) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(transaction);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
