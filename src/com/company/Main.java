package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
public class Main {

    public static void main(String[] args)throws IOException{
	// write your code here
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        ArrayList aryLst = new ArrayList();
        ListIterator iter = aryLst.listIterator();

        FileWriter fw = new FileWriter("bankAccounts.txt");
        PrintWriter output = new PrintWriter("bankAccounts");

        bankAccount thief = new bankAccount("Mr. P", 0);



        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            output.println(name);




            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                output.print(": " + amount);
                System.out.println(" "); // gives an eye pleasing blank line
                // between accounts
                bankAccount theAccount = new bankAccount(name, amount);
                iter.add(theAccount);

            }
        } while (!name.equalsIgnoreCase("EXIT"));
        output.close();
        fw.close();

        List accountlist = new ArrayList();


        // Search aryLst and print out the name and amount of the largest bank
        // account
        bankAccount ba = (bankAccount) iter.previous();
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious()) {
            ba = (bankAccount) iter.previous();
            if (ba.balance > maxBalance) {
                // We have a new winner, chicken dinner
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");

    }
}
