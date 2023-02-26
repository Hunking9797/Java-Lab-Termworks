/*
 7]	Write a Java program to demonstrate how the standard operations on a bank account can be synchronized.
 */
import java.util.Scanner;

class BankAccount{
    static final int MIN_BALANCE = 1000;
    private int balance = 0;
    void deposit(int amount){
        balance += amount;
    }
    void withdraw(int amount){
        if(balance - amount >= MIN_BALANCE){
            balance -= amount;
        }
        else{
            System.out.println("Thread " + Thread.currentThread().getName() + ": insufficient balance");
        }
    }
    int getBalance(){
        return balance;
    }
}

class SynchronizedBankAccount extends BankAccount{

    synchronized void deposit(int amount){
        super.deposit(amount);
    }
    synchronized void withdraw(int amount){
        super.withdraw(amount);
    }


}
public class TW7 {
    public static void main(String[] args) throws Exception {
        BankAccount syncAcc = new SynchronizedBankAccount();
        BankAccount unsyncAcc = new BankAccount();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i =0; i<100; i++){
                    syncAcc.deposit(1000);

                }
                System.out.println(syncAcc.getBalance());
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i =0; i<100; i++){
                    unsyncAcc.deposit(1500);

                }
                for(int i =0; i<100; i++){
                    unsyncAcc.withdraw(55);

                }
                System.out.println(unsyncAcc.getBalance());
            }
        });

        t1.start();
        t2.start();
    }
}
