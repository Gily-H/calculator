package com.gilmango.calculator.controllers;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HistoryController {

  @FXML
  private ListView<String> historyList;

  public void initCalculationHistory(List<String> calculations) {
    calculations.forEach(calculation -> historyList.getItems().add(calculation));
  }
}
