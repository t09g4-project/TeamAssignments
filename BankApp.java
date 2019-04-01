/**
 * T09-G04
 * 
 * This BankApp is a simple GUI that resembles a bank app.
 *
 *
 * It shows the customer's name and balance.
 * It has a textfield that allows the user to enter in an amount.
 * It has a deposit and withdraw button that will deposit/withdraw the amount given in the textfield.
 * The user can enter an amount they want to deposit/withdraw. When they enter in an amount they have to choose between
 * the withdraw or deposit button to perform an action. Pressing deposit will add to their balance. Pressing withdraw
 * will take away from their balance.
 *
 *
 * If a user tries to deposit/withdraw a negative number, nothing will happen.
 * The program does not take into account if the user enters in a character/string.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BankApp extends Application {

    private Customer c1 = new Customer("Bob", 1234);
    private BankAccount b1 = new SavingsAccount(c1, 0); // cannot instantiate from abstract class


    // The textfield and label are fields in order for the innerclass, HandleDeposit, to be able to access them.
    private TextField amountTextField = new TextField();   // Textfield for amount
    private Label balanceLabel = new Label("Balance: " + b1.getBalance()); //Label for Balance




    /**
     * Inner class that handles the deposit button.
     */
    public class HandleDeposit implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event){
            double amount = Double.parseDouble(amountTextField.getText()); // get the amount that was typed into textfield
            b1.deposit(amount); // deposit amount into balance
            balanceLabel.setText("Balance: " + b1.getBalance()); //updates the balance
        }
    }


    public static void main(String[] args) {
        launch(args);

    }

  
    @Override
    public void start(Stage primaryStage) throws Exception  {
        



        GridPane root = new GridPane();    // Create GridPane
        root.setAlignment(Pos.CENTER); // Align to the center.

        Label accountLabel = new Label("Account Holder: " + b1.getAccountHolder().getName()); // Label for account holder

        Label enterAmountLabel = new Label("Enter amount "); // Label for amount message

        // Buttons
        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");

        //set up the locations of the labels/buttons in the grid
        root.add(accountLabel, 1, 0);
        root.add(balanceLabel, 1, 1);
        root.add(enterAmountLabel, 0, 2);
        root.add(amountTextField, 1, 2);
        root.add(depositBtn, 1, 3);
        root.add(withdrawBtn, 2, 3);


        depositBtn.setOnAction(new HandleDeposit()); // handles the deposit button when clicked


        /**
         * Anonymous inner class that handles the withdraw button.
         */
        withdrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double amount = Double.parseDouble(amountTextField.getText());
                b1.withdraw(amount);
                balanceLabel.setText("Balance: " + b1.getBalance());
            }
        });



        primaryStage.setTitle("Bank App"); // set title
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}

