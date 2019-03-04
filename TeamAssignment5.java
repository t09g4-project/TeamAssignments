/**
 * This BankApp is a simple GUI that resembles a bank app.
 *
 * It shows the customer's name and balance.
 * It has a textfield that allows the user to enter in an amount
 * It has a deposit and withdraw button that will deposit/withdraw the amount given in the textfield.
 *
 * Note: This is not a fully functioning program . It will show the label of account holder and balance, but it will
 * not actually display the customer's name and balance. The deposit, withdraw, and textfield are not fully
 * functioning as well.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BankApp extends Application{

    private Customer c1 = new Customer("Bob", 1234);
    private BankAccount b1 = new BankAccount(c1, 0);


    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception{



        // Create GridPane
        GridPane root = new GridPane();



        // Label for account holder
        Label accountLabel = new Label("Account Holder: " + b1.getAccountHolder().getName());

        //Label for Balance
        Label balanceLabel = new Label("Balance: " + b1.getBalance());

        // Label for amount message
        Label enterAmountLabel = new Label("Enter amount ");

        // Textfield for amount
        TextField amountTextField = new TextField();

        // Buttons
        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");

        //set up the locations of the labels/buttons in the grid
        root.add(accountLabel, 1,0);
        root.add(balanceLabel, 1,1);
        root.add(enterAmountLabel, 0,2);
        root.add(amountTextField, 1,2 );
        root.add(depositBtn, 1,3);
        root.add(withdrawBtn, 2 , 3);


        /**
         * Handles the deposit button
         */
        depositBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              int amount = Integer.parseInt(amountTextField.getText());
              b1.deposit(amount);
              balanceLabel.setText("Balance: " + b1.getBalance());
            }
        });

        /**
         * Handles the withdraw button
         */
        withdrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int amount = Integer.parseInt(amountTextField.getText());
                b1.withdraw(amount);
                balanceLabel.setText("Balance: " + b1.getBalance());
            }
        });

        primaryStage.setTitle("Bank App"); // set title
        Scene scene = new Scene(root,400,100);
        primaryStage.setScene(scene);
        primaryStage.show();



    }





}
