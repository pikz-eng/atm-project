import javax.swing.*;
import java.io.IOException;
import java.security.KeyStore;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##50.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123456, 123);
                data.put(2122212, 212);
                System.out.println("Welcome to ATM project");
                System.out.println("Enter your customer NUmber");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your pin number");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid character,Enter only Number" + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("Wrong customer number or id" + "\n");
        } while (x == 1);
    }

    int selection;

    public void getAccountType() {
        System.out.println("Select the Account you want to access");
        System.out.println("Type 1:Checking Account");
        System.out.println("Type 2:Saving Account");
        System.out.println("Type 3:Exit");
        System.out.println("Choice :");
        selection = menuInput.nextInt();
        switch (selection) {
            case 1 -> {
                getChecking();
                break;
            }
            case 2 -> {
                getSaving();
                break;
            }
            case 3 -> {
                System.out.println("Thank you for using this ATM,byeee");
                break;
            }
            default -> {
                System.out.println("Invalid Choice" + "\n");
                getAccountType();
            }


        }
        //Display checking Account menu with selection

    }

    //Display checking Account menu with selection
    public void getChecking() {
        System.out.println("Checking Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw funds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice :" + "\n");
        selection = menuInput.nextInt();
        switch (selection) {
            case 1-> {
                System.out.println("Check Account" + moneyFormat.format(getCheckBalance()));
                getAccountType();
                break;
            }

            case 2 -> {
                getCheckingWithdrawalInput();
                getAccountType();
                break;
            }

            case 3-> {
                getCheckingDepositInput();
                getAccountType();
                break;
            }
            default -> {
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();
            }
        }

    }

    //Display Saving Account meny with election
    public void getSaving() {
        System.out.println("Saving Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw funds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice :" + "\n");
        selection = menuInput.nextInt();
        switch (selection) {
            case 1-> {
                System.out.println("Saving Account" + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            }
            case 2-> {
                getSavingWithdrawaInput();
                getAccountType();
                break;
            }
            case 3-> {
                getSavingDepositInput();
                getAccountType();
                break;
            }
            default -> {
                System.out.println("\n" + "Invalid Choice" + "\n");
                getSaving();
            }
        }
    }
}