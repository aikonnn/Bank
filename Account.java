//file to store objects

//account object for user

public class Account{
  int account_num;
  int balance;
  String name;

  public Account(){}
  
  public Account(String name, int account_num, int balance){
    this.balance = balance;
    this.name = name;
    this.account_num = account_num;
  }


}
