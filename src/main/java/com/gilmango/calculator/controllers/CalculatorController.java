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
  private void addToInputExpression(String input) {
    String expression = expressionLabel.getText();
    expressionLabel.setText(
        input.equals(errorMsg) ? input : expression.concat(input)
    );
  }

  // "="
  // calculate the current displayed expression
  private void calculateExpression() {

    // extract expression

    // loop through expression string
      // save numbers to list
      // save operators to list

    // loop through numbers list
      // apply operator to every pair of numbers

    // display result in resultLabel

    // save answer to history
    answers.add("ANSWER");
  }

  // "DEL"
  // delete the previous input entry made by user
  private void deletePreviousInput() {
    String expression = expressionLabel.getText();
    if (!expression.equals("")) {
      int lastInputIndex = expression.length() - 1;
      expressionLabel.setText(expression.substring(0, lastInputIndex));
    }
  }

  // "HIS"
  // show past expressions that were entered
  private void showAnswerHistory() {

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
      case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/" -> addToInputExpression(input);
      case "=" -> calculateExpression();
      case "DEL" -> deletePreviousInput();
      case "ANS" -> retrievePreviousAnswer();
      case "HIS" -> showAnswerHistory();
      case "C" -> clearExpression();
      default -> displayError();
    }
  }
}
