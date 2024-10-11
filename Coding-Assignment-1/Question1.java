// Encapsulation in OOP is a concept
// to make crucial elements of objects (e.g. variables)
// inaccessible directly (using private keyword).
// To access them (get value/change value) any other
// exec code in other classes need to use 
// a special methods - accessors.

class BankAccount
{
    private double balance; // a private variable
                            // not accessible directly

    BankAccount(double startingBalance)
    {
        balance = startingBalance;
    }

    // getter
    public double checkBalance()
    {
        return balance;
    }

    // setter 1 - add money
    public void deposit(double money)
    {
        balance += money;
    }

    // setter 2 - substract money
    public void whitdraw(double money)
    {
        balance -= money;
    }
}

public class Question1
{
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount(1200.00);
        account1.deposit(614.50); 
        account1.whitdraw(900.01);
        System.out.println("After the operations balance is:");
        System.out.println(account1.checkBalance());
    }
}