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

            switch(choice){
                case 1:
                    Account testacc = accountCreate();
                    testacc.display();
                    list.addAccount(testacc);
                    break;

                case 2:
                    System.out.println("Enter the account number to deposit to (0 to cancel):");
                    long usernum = -1;
                    while( usernum != 0){
                        try {
                            usernum = Long.parseLong(user.nextLine());
                        }
                        catch(Exception e){
                            System.out.println("Enter number");
                            continue;
                        }

                        if(!list.collection.containsKey(usernum)){
                            System.out.println("Account not found!");
                            System.out.println("Please retry:");
                            continue;
                        }
                        else{
                            System.out.println("Please enter the amount to be deposited");
                            int amount;
                            try{
                                amount = Integer.parseInt(user.nextLine());
                            }
                            catch(Exception e){
                                System.out.println("Invalid!");
                                System.out.println("Please try again!");
                                continue;
                            }

                            Account target = list.collection.get(usernum);
                            target.balance+=amount;
                            System.out.println("Success!");
                            System.out.println(amount +" have been added to " + target.name +"'s account!");

                            break;
                        }
                    }
                    on = 0;
                    break;

                case 3:
                    System.out.println("Withdraw not available yet!");
                    on = 0;
                    break;
            }
        }
    }

    //args: name, initial balance
    //return Account object created with the input
    private static Account accountCreate(){
        Scanner input = new Scanner(System.in);
        String name;
        int initbal;
        long accnum;

        System.out.println("Welcome! Let's get you an account.");
        System.out.println("What's your name? :");
        name = input.nextLine();

        System.out.println("What's your initial deposit? :");
        initbal = Integer.parseInt(input.nextLine());

        accnum = System.currentTimeMillis();

        return new Account(name, accnum, initbal);
    }
}
