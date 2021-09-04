package com.gilmango.calculator.controllers;

import com.gilmango.calculator.HistoryWindow;
import com.gilmango.calculator.utilities.StringEvaluator;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CalculatorController {

  private final String errorMsg = "ERROR";
  List<String> calculations = new ArrayList<>();

  @FXML
  private Label expressionLabel;
  @FXML
  private Label resultLabel;

  // append button input to the end of expression
  private void addInputToExpression(String input) {
    String expression = expressionLabel.getText();
    String toAppend;
    if (input.equals(errorMsg)) {
      toAppend = errorMsg;
    } else if (input.equals("(-)")) {
      toAppend = "-(" + expression + ")";
    } else {
      toAppend = expression + input;
    }

    expressionLabel.setText(toAppend);
  }

  // "="
  // calculate the current displayed expression
  private void calculateExpression() {
    String expression = expressionLabel.getText();
    String result = String.valueOf(StringEvaluator.calculateExpression(expression));
    resultLabel.setText(result);
    addCalculationToHistory(); // must be called after result is set and before expression cleared
    clearExpression();
  }

  // "DEL"
  // delete the digit/operator at the end of the current expression
  private void deletePreviousInput() {
    String expression = expressionLabel.getText();
    if (!expression.isEmpty()) {
      int lastInputIndex = expression.length() - 1;
      expressionLabel.setText(expression.substring(0, lastInputIndex));
    }
  }

  // "HIS"
  // show past expressions that were entered
  private void showCalculationHistory() {
    new HistoryWindow(calculations);
  }

  // "ANS"
  // retrieve and display the previous answer calculated
  private void retrievePreviousAnswer() {
    String previousAnswer = resultLabel.getText();
    expressionLabel.setText(expressionLabel.getText() + previousAnswer);
  }

  // "C"
  // removes the current expression that is displayed
  private void clearExpression() {
    expressionLabel.setText("");
  }

  private void displayError() {
    addInputToExpression(errorMsg);
  }

  private void addCalculationToHistory() {
    String expression = expressionLabel.getText();
    String result = resultLabel.getText();
    calculations.add(expression + " = " + result);
  }

  public void onMouseClick(MouseEvent mouseEvent) {
    Button sourceBtn = (Button) mouseEvent.getSource();
    String input = sourceBtn.getText();

    switch (input) {
      case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", "*", "/", "(-)", "(", ")" -> addInputToExpression(input);
      case "=" -> calculateExpression();
      case "DEL" -> deletePreviousInput();
      case "ANS" -> retrievePreviousAnswer();
      case "HIS" -> showCalculationHistory();
      case "C" -> clearExpression();
      default -> displayError();
    }
  }
}
