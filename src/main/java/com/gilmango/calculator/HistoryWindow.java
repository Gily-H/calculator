package com.gilmango.calculator;

import com.gilmango.calculator.controllers.HistoryController;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HistoryWindow {

  public HistoryWindow(List<String> calculations) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/history.fxml"));
      Parent historyRoot = loader.load();
      historyRoot.getStylesheets()
          .add(String.valueOf(getClass().getResource("/styles/stylesheet.css")));

      Calculator.getHistoryStage().setScene(new Scene(historyRoot));

      // populate the history window with past calculations
      HistoryController historyController = loader.getController();
      historyController.initCalculationHistory(calculations);

      Calculator.getHistoryStage().show();

    } catch (IOException e) {
      // popup to inform user of an error retrieving history window
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("History Window Error");
      alert.setHeaderText("Unable to show the history");
      alert.showAndWait();
    }
  }
}
