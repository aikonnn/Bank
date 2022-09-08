import java.util.HashMap;

public class AccList {
    HashMap< Integer, Account> collection = new HashMap<Integer, Account>();

    public void addAccount(Account acc)
    {
        collection.put(acc.account_num, acc);
    }

    public void deleteAccount(int id)
    {
        collection.remove(id);
    }
}
