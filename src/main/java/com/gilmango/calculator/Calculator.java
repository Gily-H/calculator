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

    root.getStylesheets().add(String.valueOf(getClass().getResource("/styles/stylesheet.css")));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

  public static void main(String args) {
     launch(Calculator.class);
  }
}
