package com.gilmango.calculator.controllers;

import com.gilmango.calculator.utilities.StringEvaluator;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class CalculatorController {

  private final String errorMsg = "ERROR";
  List<String> answers = new ArrayList<>();

  @FXML
  private Label expressionLabel;
  @FXML
  private Label resultLabel;

  // append button input to the end of expression
  private void addInputToExpression(String input) {
    String expression = expressionLabel.getText();
    expressionLabel.setText(
        input.equals(errorMsg) ? input : expression.concat(input)
    );
  }

  // "="
  // calculate the current displayed expression
  private void calculateExpression() {
    String expression = expressionLabel.getText();
    String result = String.valueOf(StringEvaluator.calculateExpression(expression));
    resultLabel.setText(result);
    answers.add(result);
    clearExpression();
  }

  // "DEL"
  // delete the digit/operator at the end of the current expression
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
    if (!answers.isEmpty()) {
      String currentExpression = expressionLabel.getText();
      String previousAnswer = answers.get(answers.size() - 1);
      expressionLabel.setText(currentExpression.concat(previousAnswer));
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
      case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/" -> addInputToExpression(input);
      case "=" -> calculateExpression();
      case "DEL" -> deletePreviousInput();
      case "ANS" -> retrievePreviousAnswer();
      case "HIS" -> showAnswerHistory();
      case "C" -> clearExpression();
      default -> displayError();
    }
  }
}
