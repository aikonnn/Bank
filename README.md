# AIKON BANK
a basic banking operation done with JAVA


Feature now includes:
1. Creating account with a generated account ID
2. Deposit to account by identification with account ID
3. Withdraw from account with identificaiton by account ID

classes:
--Account
  constructor: Account(name, accountnum, balnce)

  methods:
    display() -> display account info
    withdraw(int amount) -> returns final amount
    deposit(int amount) -> returns final amount
    
--AccList
  constructor: AccList() -> contains hashmap <accountID, Account>
  
  methods:
    addAccount(Account acc) -> add account object to list, with accountID as key
    deleteAccount(long id) -> delete specified account object
