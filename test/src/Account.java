//file to store objects

//account object for user

public class Account{
  long account_num;
  int balance;
  String name;

  //Creators
  public Account(){
    this.balance = 0;
    this.name = "TBD";
    this.account_num = 0;
  }
  
  public Account(String name, long account_num, int balance){
    this.balance = balance;
    this.name = name;
    this.account_num = account_num;
  }

  public void display()
  {
    System.out.println("============================================");
    System.out.println("ID: " + this.account_num);
    System.out.println("NAME: " + this.name);
    System.out.println("BALANCE: " + this.balance);
    System.out.println("============================================");
  }

  //operations
  /*
  withdraw a specified amount, returns the final balance
   */
  public int withdraw(int amount)
  {
    this.balance -= amount;
    return this.balance;
  }

  /*
  deposit a specified amount, returns the final balance
   */
  public int deposit(int amount)
  {
    this.balance += amount;
    return this.balance;
  }
}
