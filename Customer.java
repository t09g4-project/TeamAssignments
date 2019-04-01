import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Customer class holds the customer information.
 *
 * Has 2 field variables: name (type String), customerID(type int)
 *
 * Has 5 methods. 2 getter methods. One getter for name, another for customerID. 2 setter methods. One for name, another
 * for customerID.
 *
 * Has 3 constructors. One default constructor, one constructor that takes a String and an int as an argument, and a
 * copy constructor that takes a instance of Customer as an argument.
 *
 */

public class Customer {

    private String name;
    private int customerID;

    /**
     * Getter method to retrieve the name
     * @return this.name of type String. This is the customer's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method to set the name
     * @param customerName of type String. It is the name of the customer.
     */
    public void setName(String customerName) {
        this.name = customerName;
    }

    /**
     * Getter method to get the customer's ID
     * @return this.customerID of type Int. This is the customer's ID
     */
    public int getID() {
        return this.customerID;
    }

    /**
     * Setter method to set the customer's ID
     * @param customerID of type int. This is the customer's ID number.
     */
    public void setID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Method takes the instance variables and converts it into a string.
     * @return customerSummary of type String. This is a string containing the instance name and customerID in a
     * well fitted format.
     */
    public String toString(){
        String customerSummary = (this.name + " " + this.customerID);
        return customerSummary;

    }

    /**
     * Default constructor when customer takes no arguments.
     * Assigns the field variables: name as no name, and customerID as 0000
     */
    public Customer(){
        this("No name", 0000);
    }

    /**
     * Constructor that takes in a name of type String and a ID of type int.
     * @param name of type String. The Customer's name.
     * @param customerID of type Int. The customer's ID number.
     */
    public Customer(String name, int customerID) {
        this.name = name;
        this.customerID = customerID;
    }

    /**
     * This is a copy constructor. Takes in another instance of customer as an argument.
     * It will copy the field variables of the customer instance that was passed in the argument.
     * @param customer of class type Customer. This is another instance from Customer class.
     */
    public Customer( Customer customer){
        this.name = customer.name;
        this.customerID = customer.customerID;
    }


    public Customer(BufferedReader br) throws IOException{
        if(br == null){
            this.name = "No name";
            this.customerID = 0000;
        }
        String line;
        line = br.readLine();
        if(line.equals("null")){
            throw new IOException("Customer is null in file");
        }
        else {
            this.name = line;
        }

        line = br.readLine();
        if(line == null){
            throw new IOException("No customer ID found in file");
        } else {
            this.customerID = Integer.parseInt(line);
        }
    }

    public void save(PrintWriter pw)throws IOException{
        pw.println(getName());
        pw.println(getID());
    }
}
