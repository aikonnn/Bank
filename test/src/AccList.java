import java.util.HashMap;

public class AccList {
    HashMap< Long, Account> collection;

    public AccList(){
        this.collection = new HashMap<>();
    }

    public void addAccount(Account acc)
    {
        collection.put(acc.account_num, acc);
    }

    public void deleteAccount(long id){
        collection.remove(id);
    }
}
