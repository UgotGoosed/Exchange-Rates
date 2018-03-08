/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Currency extends Application {

    //Create text field for US Dollar
    TextField tfCurrency = new TextField();
    
    //Create Text area to display Canadian Currency
    TextField tfCanadian = new TextField();

    @Override
    public void start(Stage primaryStage) {

        EventHandler<ActionEvent> handler = event -> exchangeCurrency();
        tfCurrency.setOnAction(handler);
        
        //labels for text fields
        HBox pane = new HBox();
        pane.setSpacing(10);
        pane.setPadding(new Insets(5));
        Label lblUSCurrency = new Label("US Dollar:", tfCurrency);
        lblUSCurrency.setContentDisplay(ContentDisplay.BOTTOM);
        Label lblCanadianCurrency = new Label("Canadian Currency:", tfCanadian);
        lblCanadianCurrency.setContentDisplay(ContentDisplay.BOTTOM);
        

        //Button to calculate loans
        Button btExchange = new Button("Convert");
        btExchange.setOnAction(handler);
        pane.getChildren().addAll(lblUSCurrency, lblCanadianCurrency, btExchange);

        
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Exchange Rate");
        primaryStage.show();
    }

    //Method to get rates from user input text fields
    private void exchangeCurrency() {
        double usDollar = Double.parseDouble(tfCurrency.getText());
        double canadaCurrency = usDollar * 150;

        // Displaying loan info formatted
        String currency = String.format("%-1.3f \n", ((double) (usDollar * canadaCurrency) / 100));

        tfCanadian.setText(currency);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}