import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CPSC233 Lecture 02. Team 4, Tutorial 9
 *
 * This BankAccount class similarly resembles a real life bank account.
 * It contains field variables, balance (type double), accountNumber (type String), accountHolder (type Customer)
 *
 * It has an abstract method called getMonthyFeesAndInterest.
 * It has getter methods for accountHolder, balance, accountNumber
 * It has setter method for accountHolder
 * It has other methods such as deposit, withdraw, transfer, toString, monthEndUpdate, sufficientFunds
 * IT has 5 constructors which take in different arguments depending on what you choose.
 */




public abstract class BankAccount {

    // fields
    private double balance; // In dollar amount
    private String accountNumber;
    private Customer accountHolder;


    /**
     * This is a getter method that retrieves accountHolder (type Customer)
     * @return this.accountHolder (instance of Customer class). This instance contains the customer's ID and name
     */
    public Customer getAccountHolder() {
        return this.accountHolder;
    }


    /**
     *This setter method sets the field variable accountHolder (to type Customer)
     * @param accountHolder - instance of Customer class. The instance of Customer class you want BankAccount to
     * contain for accountHolder.
     */
    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }


    /**
     * Method retrieves the current balance the customer currently has in their account.
     * @return this.balance. (type double. It is the customer's current balance)
     */
    public double getBalance() {
        return this.balance;
    }


    /**
     * Method retrieves the account number of the bank customer
     * @return this.accountNumber (type String). Return the customer's account number.
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }


    /**
     * Method returns the fields of accountHolder of type Customer and fields of accountNumber and balance in
     * bankAccount.txt in a nice format.
     * @return a String in this format: ([name] [customerID]) [accountNumber]: [balance]
     *
     * Method calls toString method from the Customer class to retrieve the instance's CustomerID and name.
     *
     */
    public String toString() {
        return "(" + accountHolder.toString() + ") " + this.accountNumber + ": " + this.balance;
    }



    /**
     * Method deposits money into the customer's bank balance.
     * The deposit process will only take action as long as the deposit amount is greater than zero.
     * @param depositAmount (type double). It is amount of money the customer wants to deposit into their balance.
     */
    public void deposit(double depositAmount) {
        if (depositAmount > 0){
            this.balance += depositAmount;
        }

    }


    /**
     * Method withdraws money from the customer's bank balance.
     *
     * The withdraw process will only take action if the user has sufficient funds. The method sufficientFunds will be
     * used to check if the user is able to withdraw the amount given in the argument. If the user has sufficient funds,
     * the method sufficientFunds will be true and it will preform the withdraw. Otherwise if sufficientFunds is false,
     * no action will be taken.
     *
     * @param withdrawAmount (type double). It is the amount of money the customer wants to take out from their
     * bank account.
     *
     */
    public void withdraw(double withdrawAmount) {
        if(sufficientFunds(withdrawAmount)){
            this.balance -= withdrawAmount;
        }
    }


    /**
     * This method transfers funds from the balance from one BankAccount instance to another.
     * @param amountToTransfer (type double) The amount of money to be transferred.
     * @param account (type BankAccount) - Another instances from BankAccount.
     *                This is the account receiving the transfer.
     *
     * Condition explained:
     * Transfer will only take action if the user has sufficient funds. It will call on a method called sufficientFunds
     * to determine if the customer has sufficient funds for the transfer. If sufficientFunds returns true, a transfer
     * will occur by withdrawing the transfer amount from one bank account and depositing the transfer amount to a
     * different bank account. If sufficientFunds return false, no transfer will occur.
     */
    public void transfer(double amountToTransfer, BankAccount account){
        if(sufficientFunds(amountToTransfer)){
            withdraw(amountToTransfer);
            account.deposit(amountToTransfer);
           }
    }


    /**
     * Abstract method that returns a double value. The value that should be returned is the monthly fess and interests.
     * @return of type double. This is the monthly fees and interests.
     */
    protected abstract double getMonthlyFeesAndInterest();



    /**
     * Method gets the monthly fees and interest of the customer and applies it to the customer's balance.
     * The monthly fee and balance can be a positive value or negative value. If it is a positive value, it will
     * increase the customer's balance. If it is negative, it will decrease the customer's balance.
     */
    public void monthEndUpdate(){
        double amount = getMonthlyFeesAndInterest();
        this.balance+= amount;
    }


    /**
     * This method determines if the customer has sufficient funds to preform an action that involves taking money out
     * of their balance.
     *
     * @param withdrawAmount (type double. It is the amount the user plans to take out of their balance.)
     * @return boolean. True - if they do have sufficient funds, False- if they do not have sufficient funds.
     *
     * Condition explained:
     * If (balance - withdrawAmount) is greater than or equal to zero, and the withdraw amount is positive, return true.
     * Otherwise, return false.
     */
    public boolean sufficientFunds(double withdrawAmount){
        if((this.balance - withdrawAmount >= 0) && (withdrawAmount > 0)){
            return true;
        }
        return false;
    }



    /**
     * Default constructor that will be used if no arguments were provided.
     * This method will set balance as 0.00 and accountNumber as 0001.
     */
    BankAccount() {
        // calls to the constructor that takes in a double and a String.
        this(0.00, "0001");
    }



    /**
     * Constructor that takes a double from the argument. It will set up the balance with the argument that was given
     * and will give the accountNumber a default value of 0001.
     * @param startBalance (type double). Amount of money the customer will start with in their balance.
     */
    BankAccount(double startBalance) {
        //calls to the constructor that takes in a double and a String.
        this(startBalance, "0001");
    }



    /**
     * This is constructor which takes two arguments. It sets up the customer's starting balance and
     * the customer's account number.
     * @param startBalance (type double) The amount of money the customer will start with in their balance.
     * @param accountNumber (type String) The customer's account number.
     */
    BankAccount(double startBalance, String accountNumber) {
        this.balance = startBalance;
        this.accountNumber = accountNumber;
    }


    /**
     * This constructor takes in customer (type Customer class) and a startBalance(type double) and sets up the field
     * variables accountHolder and balance.
     * It will give accountNumber a default value 0001. 
     * @param customer (type Customer from customer class). Pass in an instance of Customer. This will the customer
     *                 information of the accountHolder.
     *
     * @param startBalance (type double). The amount of money they customer will start with in their balance.
     */
    BankAccount(Customer customer, double startBalance){
        this(startBalance, "0001"); //calls to the constructor that takes in a double and a String.
        this.accountHolder = customer; // sets up the account holder
    }



    /**
     * This is a copy constructor. It takes in another instance of BankAccount as an argument.
     * It takes the instance of BankAccount passed into the argument to copy.
     * Copies the balance and the accountHolder into a new BankAccount instance.
     * @param bankAccountToCopy of class type BankAccount. It is another instance from the BankAccount class.
     */
    BankAccount(BankAccount bankAccountToCopy){
        this.accountNumber = bankAccountToCopy.getAccountNumber();
        this.balance = bankAccountToCopy.getBalance();
        this.accountHolder = bankAccountToCopy.getAccountHolder();

    }

    public BankAccount(BufferedReader br) throws IOException {
        String line = br.readLine();
        this.balance = Double.parseDouble(line);

        line = br.readLine();
        this.accountNumber = line;

        try {
            this.accountHolder = new Customer(br);
        } catch (IOException ioe) {
            this.accountHolder = null;
        }
    }



    public void saveToTextFile(String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(getBalance());
        pw.println(getAccountNumber());
        if(getAccountHolder() == null){
            pw.println("null");
        } else{
            this.accountHolder.save(pw);
        }
        pw.close();
    }










}





