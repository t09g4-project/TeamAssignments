import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This savings account is a subclass from the base class BankAccount. This class resembles a savings account.
 *
 * It has two instance variables - annualInterestRate (type double) and minimumBalance(type double).
 * Note: annualInterestRate is a value between 0-1. (Represents 0% - 100%)
 *
 * It has setter methods for annualInterestRate and MinimumBalance.
 * It has a getter method for annualInterestRate.
 *
 * It has a method called getMonthlyFeesAndInterest, which implements the abstract method declared in BankAccount class.
 * It has an override method which overrides withdraw from the base class of BankAccount.
 *
 * It also has 5 constructors. 4 of them are the minor constructors which will call the the major constructor.
 */
public class SavingsAccount extends BankAccount {

    private double annualInterestRate; // value from 0-1. Represents 0% - 100%
    private double minimumBalance;


    /**
     * This is the default constructor takes in no arguments. It will give default values for the arguments.
     * It will set up the Customer information, start balance, and the annual interest rate.
     *
     * The default arguments are a new instance of Customer, balance (type double) of 0.00, and a default interestRate
     * of 0.05 (type double)
     */
    public SavingsAccount() {
        // Calls to major constructor. Will pass in a new Instance of Customer, a start balance of 0.00, a
        // annual interest rate of 0.05.(5%)
        this(new Customer(), 0.00, 0.05);
    }


    /**
     * This construtor takes in one argument (type double) and sets up the annual interest rate.
     *
     * @param interestRate of type double. It is the annual interest rate the user wants to set for the savings account.
     *                     interestRate has to be between a value from 0-1. Represents 0% to 100%.
     */
    public SavingsAccount(double interestRate) {
        // Calls to major constructor. Will pass in some default values. Default values are a new Instance of Customer
        // a balance of 0.00, and the annual interest rate given in the argument of the constructor.
        this(new Customer(), 0.00, interestRate);

    }


    /**
     * Constructor takes in two arguments, both of type double.
     * It will set up the start balance of the bank account and the annual interest rate of the savings account.
     *
     * @param balance of type double. It is the amount of money the customer will start in their balance.
     * @param annualInterestRate (type double) - It is the annual interest rate the user wants to set for the savings account.
     *                     It should be a value between 0-1. (represents 0% to 100%)
     *
     */
    public SavingsAccount(double balance, double annualInterestRate){
        // Calls to major constructor. Will pass a default instance of Customer, and use the two arguments passed in
        // for the major constructor arguments.
        // it will set up the starting balance and annual interest rate.
        this(new Customer(), balance, annualInterestRate);
    }


    /**
     * Construcor takes in two arguemnts, one of type Customer and another of type double.
     * @param accountHolder (type Customer) -  This contains customer information of the account holder. (name and ID)
     * @param balance (type double) - It is the amount of money the customer will start in their balance.
     *                (balance should be a positive value)
     */
    public SavingsAccount(Customer accountHolder, double balance){
        // It will use these arguments passed in and will use it to call the major constructor. The major constructor
        // will set up the customer information, the starting balance, and it will give the annual interest rate a
        // default value of 0.05.
        this(accountHolder, balance, 0.05 );
    }


    /**
     * This is the major constructor. It allows you to set up the Customer information, the start balance and the
     * annaul interest rate.
     * It also sets the minimum balance to a default of 0.00 (type double)
     *
     * @param accountHolder (type Customer) -  This contains customer information of the account holder. (name and ID)
     * @param balance (type double) - It is the amount of money the customer will start in their balance.
     *                (balance should be a positive value)
     * @param interestRate (type double) - It is the annual interest rate the user wants to set for the savings account.
     *                     It should be a value between 0-1. (represents 0% to 100%)
     */
    public SavingsAccount(Customer accountHolder, double balance, double interestRate) {
        // Calls the base class (BankAccount) constructor which takes in an instance of Customer and a
        // balance (type double).
        super(accountHolder, balance);

        // The last argument (interestRate) will be used to set the annual interest rate.
        // Uses method setAnnualInterestRate to ensure the users enters in a valid interest rate value (0-1)
        setAnnualInterestRate(interestRate);
        this.minimumBalance = 0.00; // default value of minimum balance will be 0.00 (type double)
    }


    /**
     * This method implements the abstract method declared in BankAccount. This method will calculate the monthly
     * interest rate from the annual interest rate, then it will calculate the interest earned according to their balance.
     *
     * @return monthlyInterestRate (type double) - this is the monthly interest earned this month.
     */
    @Override
    protected double getMonthlyFeesAndInterest() {
        // divide by 12 since there is 12 months in a year and multiply by the balance to determine the interest earned
        double monthlyInterest = (this.annualInterestRate/12) * getBalance();
        return monthlyInterest;
    }


    /**
     * Sets up the annual interest rate of the saving account. Interest rate passed into the argument must be between
     * 0 - 1. (represents 0% - 100%)
     *
     * @param annualInterestRate (type double)  It is the annual interest rate the user wants to set for the savings
     *                           account. It should be a value between 0-1. (represents 0% to 100%).
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        // Checks if the annualInterestRate is between 0-1 before changing the field variable.
        if (annualInterestRate >= 0 && annualInterestRate <= 1) {
            this.annualInterestRate = annualInterestRate;
        }
    }


    /**
     * Sets up the minimum balance that is required for the account.
     * @param minimumBalance (type double) - min balance required for the account
     */
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }



    /**
     * Gets the annual interest rate of the account
     * @return this.annualInterestRate (type double). It is the annual interest rate of the account.
     */
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }


    /**
     * Getter method that gets minimum balance
     * @return minimumBalance (type double) - The minimum balance required to have in the savings account
     */
    public double getMinimumBalance() {
        return minimumBalance;
    }



    /**
     * This method withdraws money from the savings account balance.
     * It will withdraw as long as the balance after the withdraw is not less than the minimumBalance.
     *
     * @param withdrawAmount (type double). It is the amount of money the customer wants to take out from their
     * savings account. Withdraw amount must be a positive value.
     *
     */
    @Override
    public void withdraw(double withdrawAmount) {
        // if the withdraw amount is positive and when withdrawing, it will not leave the total balance less than the
        // required minimum balance, it will use the base class method withdraw() to withdraw the amount given
        // from the balance.
        if (withdrawAmount >= 0 && (getBalance() - withdrawAmount >= this.minimumBalance)) {
            super.withdraw(withdrawAmount);
        }
    }


    public SavingsAccount(BufferedReader br) throws IOException {
        super(br);
        String line = br.readLine();
        this.annualInterestRate = Double.parseDouble(line);
        line = br.readLine();
        this.minimumBalance = Double.parseDouble(line);
    }

    @Override
    public void saveToTextFile(String filename) throws IOException {
        super.saveToTextFile(filename);
        PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
        pw.println(getAnnualInterestRate());
        pw.println(getMinimumBalance());
        pw.close();
    }
}




