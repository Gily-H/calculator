package com.gilmango.calculator.controllers;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class CalculatorController {

  private final String errorMsg = "ERROR";
  List<String> answers = new ArrayList<>();
  private String previousAnswer;

  @FXML
  private Label expressionLabel;
  @FXML
  private Label resultLabel;

  // append operand or operator to the math expression displayed
  private void addToExpression(String input) {
    String expression = expressionLabel.getText();
    expressionLabel.setText(
        input.equals(errorMsg) ? input : expression.concat(input)
    );
  }

  // "="
  // calculate the current displayed expression
  private void calculateExpression() {


    // save answer to history
    answers.add("ANSWER");
  }

  // "DEL"
  // delete the previous input entry made by user
  private void deletePreviousInput() {

  }

  // "HIS"
  // show past expressions that were entered
  private void showHistory() {

  }

  // "ANS"
  // retrieve and display the previous answer calculated
  private void retrievePreviousAnswer() {
    if (!previousAnswer.equals("")) {
      expressionLabel.setText(previousAnswer);
    }
  }

  // "C"
  // removes the current expression that is displayed
  private void clearExpression() {
    expressionLabel.setText("");
  }

  private void displayError() {
    expressionLabel.setText(errorMsg);
  }

  public void onMouseClick(MouseEvent mouseEvent) {
    Button sourceBtn = (Button) mouseEvent.getSource();
    String input = sourceBtn.getText();

    switch (input) {
      // operands
      case "0":
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
      case "6":
      case "7":
      case "8":
      case "9":

      // operators
      case ".":
      case "+":
      case "-":
      case "*":
      case "/":
        addToExpression(input);
        break;
      case "=":
        calculateExpression();
        break;

      // utilities
      case "DEL":
        deletePreviousInput();
        break;
      case "ANS":
        retrievePreviousAnswer();
        break;
      case "HIS":
        showHistory();
        break;
      case "C":
        clearExpression();
        break;
      default:
        displayError();
        break;
    }
  }
}
