import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int on = 1;
        Scanner user = new Scanner(System.in);
        AccList list = new AccList();

        System.out.println("Welcome to AIKON BANK! How can we help today?");

        while(on == 1)
        {
            System.out.println("Choose you service: ");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit to an existing account");
            System.out.println("3. Withdraw from an existing account");

            int choice;

            try {
                choice = Integer.parseInt(user.nextLine());
            }
            catch(Exception e){
                System.out.println("Please enter an integer");
                continue;
            }

            if(choice != 1 && choice != 2 && choice != 3){
                System.out.println("Invalid choice!");
                continue;
            }

            if(choice != 1 && list.collection.size() == 0){
                System.out.println("No account found!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    Account newacc = accountCreate();
                    newacc.display();
                    list.addAccount(newacc);
                }
                case 2 -> {
                    depositOperation(list);
                    on = 0;
                }
                case 3 -> {
                    withdrawOperation(list);
                    on = 0;
                }
            }
        }
    }

    //args: name, initial balance
    //return Account object created with the input
    private static Account accountCreate(){
        Scanner input = new Scanner(System.in);
        String name;
        int initbal = 0;
        long accnum;
        int on = 1;

        System.out.println("Welcome! Let's get you an account.");
        System.out.println("What's your name? :");
        name = input.nextLine();

        while(on == 1){
            System.out.println("What's your initial deposit? :");
            initbal = Integer.parseInt(input.nextLine());

            if(initbal<0){
                System.out.println("Invalid!");
            }
            else{
                on = 0;
            }
        }

        accnum = System.currentTimeMillis();

        return new Account(name, accnum, initbal);
    }

    private static void depositOperation(AccList list)
    {
        Scanner user = new Scanner(System.in);
        long usernum;

        while(true){
            System.out.println("Enter the account number to deposit to (0 to cancel):");
            try {
                usernum = Long.parseLong(user.nextLine());
            }
            catch(Exception e){
                System.out.println("Enter number");
                continue;
            }

            if(usernum == 0){
                System.out.println("Operation Cancelled!");
                return;
            }

            if(!list.collection.containsKey(usernum)){
                System.out.println("Account not found!");
                System.out.println("Please retry:");
            }
            else{
                System.out.println("Please enter the amount to be deposited (-1 to cancel)");
                int amount = 0;
                boolean on = true;
                Account target = list.collection.get(usernum);

                while(on) {
                    try {
                        amount = Integer.parseInt(user.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid!");
                        System.out.println("Please try again!");
                        continue;
                    }

                    if(amount<0 && amount != -1){
                        System.out.println("Invalid amount!");
                    }
                    else{
                        on = false;
                    }
                }

                if(amount == -1) {
                    System.out.println("Cancelled!");
                    return;
                }

                System.out.println("Success!");
                System.out.println(target.deposit(amount) +" is now in " + target.name +"'s account!");

                return;
            }
        }
    }

    private static void withdrawOperation(AccList list)
    {
        Scanner user = new Scanner(System.in);

        long usernum;

        while( true ){
            System.out.println("Enter the account number to deposit to (0 to cancel):");
            try {
                usernum = Long.parseLong(user.nextLine());
            }
            catch(Exception e){
                System.out.println("Enter number");
                continue;
            }

            if(usernum == 0){
                System.out.println("Operation Cancelled!");
                return;
            }

            if(!list.collection.containsKey(usernum)){
                System.out.println("Account not found!");
                System.out.println("Please retry:");
            }
            else{
                boolean on = true;
                int amount = 0;
                Account target = list.collection.get(usernum);

                while(on){
                    System.out.println("Please enter the amount to be withdrawn (-1 to cancel)");
                    try{
                        amount = Integer.parseInt(user.nextLine());
                    }
                    catch(Exception e){
                        System.out.println("Invalid!");
                        System.out.println("Please try again!");
                        continue;
                    }

                    if(amount > target.balance || (amount<0 && amount != -1)){
                        System.out.println("Invalid amount!");
                    }
                    else{
                        on = false;
                    }
                }

                if(amount == -1) {
                    System.out.println("Cancelled!");
                    return;
                }

                System.out.println("Success!");
                System.out.println(target.withdraw(amount) +" is now in " + target.name +"'s account!");

                return;
            }
        }
    }
}
