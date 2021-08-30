package com.gilmango.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
            getClass().getResource("/calculator.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Calculator App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args) {
        launch(Calculator.class);
    }
}
