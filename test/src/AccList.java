import java.util.HashMap;

public class AccList {
    static HashMap< Long, Account> collection = new HashMap<Long, Account>();

    public AccList(){
        this.collection = collection;
    }

    public void addAccount(Account acc)
    {
        collection.put(acc.account_num, acc);
    }

    public void deleteAccount(int id){
        collection.remove(id);
    }
}
