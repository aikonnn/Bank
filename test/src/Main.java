import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Account testacc = accountCreate();
        testacc.display();
    }

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
